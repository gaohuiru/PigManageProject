package com.bluedot.pig.controller;

import com.bluedot.framework.simplespring.core.annotation.Controller;
import com.bluedot.framework.simplespring.inject.annotation.Autowired;
import com.bluedot.framework.simplespring.mvc.annotation.RequestMapping;
import com.bluedot.framework.simplespring.mvc.annotation.RequestParam;
import com.bluedot.framework.simplespring.mvc.type.ModelAndView;
import com.bluedot.pig.factory.MapInitFactory;
import com.bluedot.pig.service.UserService;

import javax.servlet.http.HttpServlet;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xxbb
 */
@Controller
@RequestMapping("/user")
public class UserController extends HttpServlet {
    @Autowired
    UserService userService;
    @Autowired
    MapInitFactory mapInitFactory;
    @RequestMapping("/queryUsers")
        public ModelAndView queryUsers(@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize){
        //初始化map，处理分页参数
        Map<String, Object> serviceMap = mapInitFactory.createServiceMapForSimpleQueryList(pageNo, pageSize);
        serviceMap.put("service","queryUsers");
        userService.doService(serviceMap);
        System.out.println(serviceMap);
        ModelAndView modelAndView=new ModelAndView();
        //当map中出现该key时说明业务执行过程中出现了错误
        String errorKey="error";
        if(serviceMap.containsKey(errorKey)){
            modelAndView.setView("/error/error.jsp");
        }else{
            modelAndView.setView("/user/user-info-list.jsp").addViewData("result",serviceMap);
        }
        return modelAndView;
    }
}
