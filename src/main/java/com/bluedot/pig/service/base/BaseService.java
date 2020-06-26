package com.bluedot.pig.service.base;


import com.bluedot.framework.simplespring.core.BeanContainer;
import com.bluedot.framework.simplespring.core.annotation.Service;
import com.bluedot.pig.mapper.BaseDao;
import com.bluedot.pig.mapper.BaseMapper;
import com.bluedot.pig.factory.MapperFactory;
import com.bluedot.pig.pojo.PageInfo;
import com.bluedot.pig.service.callback.ServiceCallback;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.List;
import java.util.Map;

/**
 * @author xxbb
 */
@Service
public class BaseService {

    /**
     * IoC容器，用来获取在反射时需要的对象（在容器中的对象的成员变量已经实例化了）
     * 由于希望其他Service能够直接继承该类获取该类中的方法，就需要该类不能能使用@AutoWired注解
     * 因为子类实例化时同时会将父类先实例化，但是这里实例化的父类并没有进依赖注入
     * 所以如果子类使用了父类的需要依赖注入的成员变量，该变量的属性值时会为空，运行时会报错
     *
     * BaseMapper和BaseDao不作为成员变量从beanContainer获取的原因：
     * 在IoC容器在加载过程中的先后问题，可能BaseService类先加载而
     * BaseMapper和BaseDao后加载，这就可能导致在它们如果作为成员变量可能获取不到值
     */
    BeanContainer beanContainer = BeanContainer.getInstance();

    /**
     * 查询数据列表的方法
     *
     * @param map             请求参数map
     * @param serviceCallback 具体查询操作的回调接口
     * @param <T>             泛型
     */
    protected  <T> void doSimpleQueryListTemplate(Map<String, Object> map, ServiceCallback<T> serviceCallback) {
        BaseMapper baseMapper = ((MapperFactory) beanContainer.getBean(MapperFactory.class)).createMapper();
        int pageNo = (int) map.get("pageNo");
        int pageStart = (int) map.get("pageStart");
        int pageSize = (int) map.get("pageSize");
        boolean hasQueryCondition = (boolean) map.get("hasQueryCondition");
        List<T> list;
        Long totalSize;
        try {
            if (hasQueryCondition) {
                String queryCondition = (String) map.get("queryCondition");
                String queryValue = (String) map.get("queryValue");
                list = serviceCallback.doListExecutorByQueryCondition(baseMapper, pageStart, pageSize, queryCondition, queryValue);
                totalSize = serviceCallback.doCountExecutorByQueryCondition(baseMapper, queryCondition, queryValue);
            } else {
                list = serviceCallback.doListExecutor(baseMapper, pageStart, pageSize);
                totalSize = serviceCallback.doCountExecutor(baseMapper);
            }

            //页面大小、页码、数据总数、数据列表，注意顺序
            PageInfo<T> pageInfo = new PageInfo<>(pageSize, pageNo, totalSize, list);
            //单独计算总页数
            pageInfo.setTotalPage(totalSize, pageSize);
            map.put("pageInfo", pageInfo);
        } catch (Exception e) {
            map.put("error", "数据查询出错");
        }

    }

    /**
     * 操作数据库列表的方法（增删改方法）的模板方法
     *
     * @param map             请求参数map
     * @param serviceCallback 具体查询操作的回调接口
     * @param <T>             泛型
     */
    protected  <T> void doSimpleModifyTemplate(Map<String, Object> map, ServiceCallback<T> serviceCallback) {
        BaseMapper baseMapper = ((MapperFactory) beanContainer.getBean(MapperFactory.class)).createMapper();
        BaseDao baseDao=(BaseDao) beanContainer.getBean(BaseDao.class);
        int pageNo = (int) map.get("pageNo");
        int pageSize = (int) map.get("pageSize");
        int affectedRows = serviceCallback.doDataModifyExecutor(baseDao);
        if (affectedRows == 0) {
            map.put("error", "数据库信息操作失败！受影响的行数为0");
        }

        boolean hasQueryCondition = (boolean) map.get("hasQueryCondition");
        List<T> list;
        Long totalSize;
        long totalPage;
        if(hasQueryCondition){
            String queryCondition = (String) map.get("queryCondition");
            String queryValue = (String) map.get("queryValue");
            totalSize = serviceCallback.doCountExecutorByQueryCondition(baseMapper, queryCondition, queryValue);

            //计算当前页面数，调整页码，防止最后一条数据被删除后原本的最后一页不存在而出现跳转错误
            totalPage = totalSize % pageSize == 0 ? totalSize / pageSize : totalSize / pageSize + 1;
            if (totalPage < pageNo) {
                pageNo = pageNo - 1;
                map.put("pageNo", pageNo);
            }
            int pageStart = (pageNo - 1) * pageSize;
            list = serviceCallback.doListExecutorByQueryCondition(baseMapper, pageStart, pageSize, queryCondition, queryValue);
        }else{
            totalSize = serviceCallback.doCountExecutor(baseMapper);

            //计算当前页面数，调整页码，防止最后一条数据被删除后原本的最后一页不存在而出现跳转错误
            totalPage = totalSize % pageSize == 0 ? totalSize / pageSize : totalSize / pageSize + 1;
            if (totalPage < pageNo) {
                pageNo = pageNo - 1;
                map.put("pageNo", pageNo);
            }
            int pageStart = (pageNo - 1) * pageSize;
            list = serviceCallback.doListExecutor(baseMapper, pageStart, pageSize);
        }

        //页面大小、页码、数据总数、页面总数、数据列表，注意顺序
        PageInfo<T> pageInfo = new PageInfo<>(pageSize, pageNo, totalSize, totalPage, list);
        map.put("pageInfo", pageInfo);
    }


    /**
     * service层的调用接口，所有的具体业务方法都通过该方法进行调用
     * 根据map中的service参数反射调用对应的service方法
     *
     * @param map 包含请求参数和需要执行的service方法参数
     */
    public void doService(Map<String, Object> map) {
        String methodName = (String) map.get("service");
        Class<?> clazz = this.getClass();
        Object obj = beanContainer.getBean(clazz);
        try {
            Method method = clazz.getDeclaredMethod(methodName, Map.class);
            method.setAccessible(true);
            method.invoke(obj, map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("error", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }

    }
}
