package com.bluedot.pig.controller;

import com.bluedot.framework.simplespring.core.annotation.Controller;
import com.bluedot.framework.simplespring.inject.annotation.Autowired;
import com.bluedot.framework.simplespring.mvc.annotation.RequestMapping;
import com.bluedot.framework.simplespring.mvc.annotation.RequestParam;
import com.bluedot.framework.simplespring.mvc.type.ModelAndView;
import com.bluedot.framework.simplespring.mvc.type.RequestMethod;
import com.bluedot.pig.pojo.domain.Employee;
import com.bluedot.pig.pojo.domain.Purview;
import com.bluedot.pig.service.LoginService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xxbb
 */
@Controller
public class LoginController extends HttpServlet {
    @Autowired
    LoginService loginService;

    @RequestMapping("/")
    public String toLoginPage() {
        return "login.jsp";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("request") HttpServletRequest request) {
        Map<String,Object> serviceMap=new HashMap<>(16);
        serviceMap.put("username",username);
        serviceMap.put("password",password);
        serviceMap.put("service","login");
        loginService.doService(serviceMap);
        ModelAndView modelAndView=new ModelAndView();

        String errorKey="error";
        if(serviceMap.containsKey(errorKey)){
            return modelAndView.setView("login.jsp").addViewData("success",false);
            
        }
        else{
            System.out.println(serviceMap);
            //设置用户姓名和权限的session
            String realName=((Employee) serviceMap.get("employee")).getRealName();
            Purview purview= (Purview) serviceMap.get("purview");
            //返回视图
            return modelAndView.setView("index.jsp")
                    .addViewData("session.name",realName)
                    .addViewData("session.purview",purview);
        }

    }
}
