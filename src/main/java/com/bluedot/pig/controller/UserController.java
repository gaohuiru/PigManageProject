package com.bluedot.pig.controller;

import com.bluedot.framework.simplespring.core.annotation.Controller;
import com.bluedot.framework.simplespring.inject.annotation.Autowired;
import com.bluedot.framework.simplespring.mvc.annotation.RequestMapping;
import com.bluedot.framework.simplespring.mvc.annotation.RequestParam;
import com.bluedot.framework.simplespring.mvc.type.ModelAndView;
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
    public ModelAndView queryUsers(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize) {
        StringBuilder dispatchPath = new StringBuilder("/user/user-info-list.jsp");
        return simpleRequestTemplate(userService, pageNo, pageSize, dispatchPath, new ControllerCallback() {
            @Override
            public void beforeDoServiceForSimpleRequest(Map<String, Object> serviceMap, StringBuilder dispatchPath) {
                serviceMap.putIfAbsent("service", "queryUsers");
            }
        });

    }
}
