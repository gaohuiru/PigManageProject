package com.bluedot.pig.controller.callback;

import com.bluedot.framework.simplespring.mvc.type.ModelAndView;
import com.bluedot.pig.service.base.BaseService;

import javax.security.auth.callback.Callback;
import java.util.Map;

/**
 * @author xxbb
 */
public interface ControllerCallback extends Callback {

    /**
     * service方法执行完成之前的处理
     * 设置service的方法名，执行service的方法，
     * 由于方法的闭包问题，service类是逻辑上的final，可以直接在方法里调用到，这里就不用传入service对象
     * @param serviceMap 参数map
     * @param dispatchPath 转发路径
     */
    default  void beforeDoServiceForSimpleRequest(Map<String,Object> serviceMap, StringBuilder dispatchPath){}

    /**
     * service方法执行完成之后的处理
     * @param serviceMap 参数map
     * @param dispatchPath 转发路径
     *
     */
    default  void afterDoServiceForSimpleRequest(Map<String,Object> serviceMap, StringBuilder dispatchPath){}
}
