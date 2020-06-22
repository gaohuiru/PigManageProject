package com.bluedot.pig.controller.base;

import com.bluedot.framework.simplespring.core.annotation.Controller;
import com.bluedot.framework.simplespring.mvc.type.ModelAndView;
import com.bluedot.pig.controller.callback.ControllerCallback;
import com.bluedot.pig.factory.MapInitFactory;
import com.bluedot.pig.service.base.BaseService;

import javax.servlet.http.HttpServlet;
import java.util.Map;

/**
 * 抽取请求处理中的共性的内容
 * @author xxbb
 */
@Controller
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
    public ModelAndView simpleRequestTemplate(BaseService service, Integer pageNo, Integer pageSize, StringBuilder dispatchPath , ControllerCallback controllerCallback){
        //初始化map，处理分页参数
        Map<String, Object> serviceMap = MapInitFactory.createServiceMapForPageParameters(pageNo, pageSize);
        //执行service的方法
        controllerCallback.doServiceForSimpleRequest(serviceMap,dispatchPath);
        System.out.println("转发路径："+dispatchPath.toString());
        System.out.println("转发携带参数"+serviceMap);

        return setModelAndView(dispatchPath,serviceMap);

    }
    /**
     * 设置转发路径
     * @param dispatchPath 转发路径
     * @return modelAndView视图
     */
    public ModelAndView setModelAndView(StringBuilder dispatchPath,Map<String,Object> serviceMap){
        ModelAndView modelAndView=new ModelAndView();
        //当map中出现该key时说明业务执行过程中出现了错误
        String errorKey="error";
        if(serviceMap.containsKey(errorKey)){
            modelAndView.setView("/error/error.jsp");
        }else{
            modelAndView.setView(dispatchPath.toString()).addViewData("result",serviceMap);
        }
        return modelAndView;
    }
}
