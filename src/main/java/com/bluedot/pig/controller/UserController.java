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
public class UserController extends HttpServlet {
    @Autowired
    UserService userService;
    /**
     * 由于Controller已经继承了HttpServlet，所以这里使用组合的方式使用baseController的功能
     * 抽取了具有共性的请求处理操作的controller类
     */
    @Autowired
    BaseController baseController;

    @RequestMapping("/queryUsers")
    public ModelAndView queryUsers(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize) {
        String dispatchPath = "/user/user-info-list.jsp";
        return baseController.simpleQueryRequestTemplate(userService, pageNo, pageSize, dispatchPath, new ControllerCallback() {
            @Override
            public void doServiceForSimpleQueryRequestExecutor(Map<String, Object> serviceMap) {
                serviceMap.put("service", "queryUsers");
                userService.doService(serviceMap);
            }
        });

    }
}
