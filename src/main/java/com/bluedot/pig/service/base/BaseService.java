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
        PageInfo<T> pageInfo = new PageInfo<>(pageNo, pageSize, totalSize, list);
        map.put("pageInfo", pageInfo);
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
