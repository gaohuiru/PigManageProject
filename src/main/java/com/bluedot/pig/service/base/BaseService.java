package com.bluedot.pig.service.base;


import com.bluedot.framework.simplespring.core.BeanContainer;
import com.bluedot.framework.simplespring.core.annotation.Service;
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
     * 所以父类的需要依赖注入的属性会为空，运行时会报错
     */
    BeanContainer beanContainer = BeanContainer.getInstance();

    /**
     * 查询数据列表的方法
     * @param map             请求参数map
     * @param serviceCallback 具体查询操作的回调接口
     * @param <T>             泛型
     */
    public <T> void doSimpleQueryListTemplate(Map<String, Object> map, ServiceCallback<T> serviceCallback) {
        BaseMapper baseMapper = ((MapperFactory) beanContainer.getBean(MapperFactory.class)).createMapper();
        int pageNo = (int) map.get("pageNo");
        int pageStart = (int) map.get("pageStart");
        int pageSize = (int) map.get("pageSize");
        List<T> list =serviceCallback.doListExecutor(baseMapper, pageStart, pageSize);
        Long totalSize = serviceCallback.doCountExecutor(baseMapper);
        //页面大小、页码、数据总数、数据列表，注意顺序
        PageInfo<T> pageInfo = new PageInfo<>(pageSize,pageNo,totalSize, list);
        //单独计算总页数
        pageInfo.setTotalPage(totalSize,pageSize);
        map.put("pageInfo", pageInfo);
    }
    public <T>void doRemoveByPrimaryKey(Map<String ,Object> map,ServiceCallback<T> serviceCallback){
        BaseMapper baseMapper=((MapperFactory) beanContainer.getBean(MapperFactory.class)).createMapper();
        int pageNo=(int) map.get("pageNo");
        int pageSize = (int) map.get("pageSize");
        int affectedRows=serviceCallback.doDataModifyExecutor(baseMapper);
        if(affectedRows==0){
            map.put("error","信息删除失败！");
        }
        Long totalSize=serviceCallback.doCountExecutor(baseMapper);

        //计算当前页面数，调整页码，防止最后一条数据被删除后原本的最后一页不存在而出现跳转错误
        long totalPage=totalSize%pageSize==0? totalSize/pageSize:totalSize/pageSize+1;
        if(totalPage<pageNo){
            pageNo=pageNo-1;
            map.put("pageNo",pageNo);
        }
        int pageStart=(pageNo-1)*pageSize;
        List<T> list=serviceCallback.doListExecutor(baseMapper,pageStart,pageSize);
        //页面大小、页码、数据总数、页面总数、数据列表，注意顺序
        PageInfo<T> pageInfo = new PageInfo<>(pageSize,pageNo,totalSize,totalPage,list);
        map.put("pageInfo",pageInfo);
    }



    /**
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
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            map.put("error", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }

    }
}
