package com.bluedot.pig.controller.base;

import com.bluedot.framework.simplespring.core.BeanContainer;
import com.bluedot.framework.simplespring.core.annotation.Controller;
import com.bluedot.framework.simplespring.mvc.type.ModelAndView;
import com.bluedot.framework.simplespring.util.LogUtil;
import com.bluedot.pig.controller.callback.ControllerCallback;
import com.bluedot.pig.factory.MapInitFactory;
import com.bluedot.pig.mapper.BaseDao;
import com.bluedot.pig.pojo.domain.ErrorLog;
import com.bluedot.pig.pojo.domain.OperationLog;
import com.bluedot.pig.service.base.BaseService;

import javax.servlet.http.HttpServlet;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

/**
 * 抽取请求处理中的共性的内容
 * @author xxbb
 */
public class BaseController extends HttpServlet {

    /**
     * 简单数据列表查询请求的处理模板
     * @param service 具体调用的service
     * @param pageNo 页码
     * @param pageSize 页面大小
     * @param dispatchPath 成功后的转发路径
     * @param controllerCallback 回调接口
     * @return modelAndView
     */
    protected ModelAndView simpleRequestTemplate(BaseService service, Integer pageNo, Integer pageSize, StringBuilder dispatchPath , ControllerCallback controllerCallback){
        //初始化map，处理分页参数
        Map<String, Object> serviceMap = MapInitFactory.createServiceMapForPageParameters(pageNo, pageSize);
        //执行service的方法
        controllerCallback.beforeDoServiceForSimpleRequest(serviceMap,dispatchPath);
        System.out.println("转发路径："+dispatchPath.toString());
        System.out.println("转发携带参数"+serviceMap);

        return setModelAndView(dispatchPath,serviceMap);

    }

    /**
     * 简单数据列表查询请求的处理模板
     * @param service 具体调用的service
     * @param serviceMap 参数映射
     * @param dispatchPath 成功后的转发路径
     * @param controllerCallback 回调接口
     * @return modelAndView
     */
    protected ModelAndView simpleRequestTemplate(BaseService service, Map<String,Object> serviceMap, StringBuilder dispatchPath , ControllerCallback controllerCallback){
        //获取数据库操作类
        BaseDao baseDao= (BaseDao) BeanContainer.getInstance().getBean(BaseDao.class);
        try {
            //初始化map，处理分页参数
            MapInitFactory.createServiceMapForPageParameters(serviceMap);
            //判断所执行的方法是否需附带的查询条件（保证在使用搜索后的展示的页面视图的分页能够继续是显示搜索结果的数据集合）
            serviceMap.put("hasQueryCondition",hasQueryCondition(serviceMap));
            //执行service的方法
            controllerCallback.beforeDoServiceForSimpleRequest(serviceMap,dispatchPath);
            service.doService(serviceMap);
            controllerCallback.afterDoServiceForSimpleRequest(serviceMap,dispatchPath);
            //记录操作日志
            insertOperationLog(serviceMap,baseDao);
            LogUtil.getLogger().debug ("转发路径："+dispatchPath.toString());
            LogUtil.getLogger().debug ("转发携带参数 result:"+serviceMap);
            return setModelAndView(dispatchPath,serviceMap);
        } catch (Exception e) {
            serviceMap.putIfAbsent("error",e.getMessage());
            insertOperationLog(serviceMap,baseDao);
            throw new RuntimeException(e);
        }
    }
    /**
     * 设置转发路径
     * @param dispatchPath 转发路径
     * @return modelAndView视图
     */
    protected ModelAndView setModelAndView(StringBuilder dispatchPath,Map<String,Object> serviceMap){
        ModelAndView modelAndView=new ModelAndView();
        //当map中出现该key时说明业务执行过程中出现了错误
        String errorKey="error";
        if(serviceMap.containsKey(errorKey)){
            modelAndView.setView("/error/error.jsp").addViewData("result",serviceMap);
        }else{
            modelAndView.setView(dispatchPath.toString()).addViewData("result",serviceMap);
        }
        return modelAndView;
    }

    /**
     * 判断传入的参数中是否由查询条件，目的是在有条件的查询结果的页面实现分页效果
     * @param serviceMap 请求参数映射
     * @return 是否有查询条件
     */
    private boolean hasQueryCondition(Map<String,Object> serviceMap){
        String key="queryCondition";
        String valueOfKey="queryValue";
        //第一步判断是否有key
        if(!serviceMap.containsKey(key)&&!serviceMap.containsKey(valueOfKey)){
            return false;
        }
        //第二步判断是否有value
        String queryCondition=String.valueOf(serviceMap.get("queryCondition"));
        String queryValue=String.valueOf(serviceMap.get("queryValue"));
        return !queryCondition.isEmpty()&&!queryValue.isEmpty();
    }

    /**
     *
     * @param map 参数
     */
    private void insertOperationLog(Map<String,Object> map,BaseDao baseDao) {
        String operatorId="operatorId";
        String errorKey="error";
        //登录时没有id
        if (map.get(operatorId) == null) {
            return;
        }

        Integer employeeId = Integer.valueOf((String) map.get("operatorId"));
        String service = (String) map.get("service");
        String parameter = map.toString();
        Timestamp timestamp=new Timestamp(System.currentTimeMillis());
        if (map.containsKey(errorKey)) {
            String errorMsg = (String) map.get(errorKey);
            ErrorLog errorLog = new ErrorLog(employeeId, service, parameter, errorMsg, timestamp);
            LogUtil.getLogger().debug("插入异常记录");
            baseDao.insert(errorLog);
        } else {
            OperationLog operationLog = new OperationLog(employeeId, service, parameter, timestamp);
            LogUtil.getLogger().debug("插入操作记录");
            baseDao.insert(operationLog);
        }
    }
}
