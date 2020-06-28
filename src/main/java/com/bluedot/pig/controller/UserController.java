package com.bluedot.pig.controller;

import com.bluedot.framework.simplespring.core.annotation.Controller;
import com.bluedot.framework.simplespring.inject.annotation.Autowired;
import com.bluedot.framework.simplespring.mvc.annotation.RequestMapping;
import com.bluedot.framework.simplespring.mvc.annotation.RequestParam;
import com.bluedot.framework.simplespring.mvc.type.ModelAndView;
import com.bluedot.framework.simplespring.mvc.type.RequestMethod;
import com.bluedot.pig.controller.base.BaseController;
import com.bluedot.pig.controller.callback.ControllerCallback;
import com.bluedot.pig.service.UserService;

import javax.servlet.http.HttpServlet;
import java.util.Map;

/**
 * @author xxbb
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    UserService userService;

    @RequestMapping("/queryUsers")
    public ModelAndView queryUsers(@RequestParam("map") Map<String,Object> serviceMap) {
        StringBuilder dispatchPath = new StringBuilder("/user/user-info-list.jsp");
        return simpleRequestTemplate(userService, serviceMap, dispatchPath, new ControllerCallback() {});
    }
    @RequestMapping(value = "/removeUser",method= RequestMethod.POST)
    public ModelAndView removeUser(@RequestParam("map") Map<String,Object> serviceMap) {
        StringBuilder dispatchPath = new StringBuilder("/user/user-info-list.jsp");
        return simpleRequestTemplate(userService, serviceMap, dispatchPath, new ControllerCallback() {});
    }
    @RequestMapping(value = "/modifyUser",method= RequestMethod.POST)
    public ModelAndView modifyUser(@RequestParam("map") Map<String,Object> serviceMap) {
        StringBuilder dispatchPath = new StringBuilder("/user/user-info-list.jsp");
        return simpleRequestTemplate(userService, serviceMap, dispatchPath, new ControllerCallback() {});
    }
    @RequestMapping(value = "/addUser",method= RequestMethod.POST)
    public ModelAndView addUser(@RequestParam("map") Map<String,Object> serviceMap) {
        StringBuilder dispatchPath = new StringBuilder("/user/user-info-list.jsp");
        return simpleRequestTemplate(userService, serviceMap, dispatchPath, new ControllerCallback() {});
    }

    @RequestMapping("/queryUserPurviews")
    public ModelAndView queryUserPurviews(@RequestParam("map") Map<String,Object> serviceMap) {
        StringBuilder dispatchPath = new StringBuilder("/user/user-purview-list.jsp");
        return simpleRequestTemplate(userService, serviceMap, dispatchPath, new ControllerCallback() {});
    }
    @RequestMapping(value = "/modifyUserPurview",method= RequestMethod.POST)
    public ModelAndView modifyUserPurview(@RequestParam("map") Map<String,Object> serviceMap) {
        StringBuilder dispatchPath = new StringBuilder("/user/user-purview-list.jsp");
        return simpleRequestTemplate(userService, serviceMap, dispatchPath, new ControllerCallback() {});
    }

    /**
     * 删除权限信息，暂时不使用
     * @param serviceMap 请求参数
     * @return 视图
     */
    @RequestMapping(value = "/removeUserPurview",method= RequestMethod.POST)
    public ModelAndView removeUserPurview(@RequestParam("map") Map<String,Object> serviceMap) {
        StringBuilder dispatchPath = new StringBuilder("/user/user-purview-list.jsp");
        return simpleRequestTemplate(userService, serviceMap, dispatchPath, new ControllerCallback() {});
    }

    /**
     * 添加权限信息，暂时不使用
     * @param serviceMap 请求参数
     * @return 视图
     */
    @RequestMapping(value = "/addUserPurview",method= RequestMethod.POST)
    public ModelAndView addUserPurview(@RequestParam("map") Map<String,Object> serviceMap) {
        StringBuilder dispatchPath = new StringBuilder("/user/user-purview-list.jsp");
        return simpleRequestTemplate(userService, serviceMap, dispatchPath, new ControllerCallback() {});
    }

}
