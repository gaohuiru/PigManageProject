package com.bluedot.pig.controller;

import com.bluedot.framework.simplespring.core.annotation.Controller;
import com.bluedot.framework.simplespring.inject.annotation.Autowired;
import com.bluedot.framework.simplespring.mvc.annotation.RequestMapping;
import com.bluedot.framework.simplespring.mvc.annotation.RequestParam;
import com.bluedot.framework.simplespring.mvc.type.ModelAndView;
import com.bluedot.pig.controller.base.BaseController;
import com.bluedot.pig.controller.callback.ControllerCallback;
import com.bluedot.pig.service.LogService;
import com.bluedot.pig.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;

import java.util.Map;

/**
 * 日处理志请求
 * @author xxbb
 */
@RequestMapping("/log")
@Controller
public class LogController extends BaseController {
    @Autowired
    LogService logService;

    @RequestMapping("/queryLoginLogs")
    public ModelAndView queryLoginLogs(@RequestParam("map") Map<String,Object> serviceMap){
        StringBuilder dispatchPath=new StringBuilder("/WEB-INF/log/login-log-list.jsp");
        return simpleRequestTemplate(logService, serviceMap, dispatchPath, new ControllerCallback() {});
    }
    @RequestMapping("/queryOperationLogs")
    public ModelAndView queryOperationLogs(@RequestParam("map") Map<String,Object> serviceMap){
        StringBuilder dispatchPath=new StringBuilder("/WEB-INF//log/operation-log-list.jsp");
        return simpleRequestTemplate(logService, serviceMap, dispatchPath, new ControllerCallback() {});
    }
    @RequestMapping("/queryErrorLogs")
    public ModelAndView queryErrorLogs(@RequestParam("map") Map<String,Object> serviceMap){
        StringBuilder dispatchPath=new StringBuilder("/WEB-INF//log/error-log-list.jsp");
        return simpleRequestTemplate(logService, serviceMap, dispatchPath, new ControllerCallback() {});
    }

}
