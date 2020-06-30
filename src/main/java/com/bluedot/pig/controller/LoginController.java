package com.bluedot.pig.controller;

import com.bluedot.framework.simplespring.core.annotation.Controller;
import com.bluedot.framework.simplespring.inject.annotation.Autowired;
import com.bluedot.framework.simplespring.mvc.annotation.RequestMapping;
import com.bluedot.framework.simplespring.mvc.annotation.RequestParam;
import com.bluedot.framework.simplespring.mvc.type.ModelAndView;
import com.bluedot.framework.simplespring.mvc.type.RequestMethod;
import com.bluedot.pig.controller.base.BaseController;
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
public class LoginController extends BaseController {
    @Autowired
    LoginService loginService;

    @RequestMapping("/")
    public String toLoginPage() {
        return "login.jsp";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("map") Map<String,Object>serviceMap, @RequestParam("request") HttpServletRequest request) {
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
            Integer employeeId=purview.getEmployeeId();
            //返回视图
            return modelAndView.setView("index.jsp")
                    .addViewData("session.name",realName)
                    .addViewData("session.id",employeeId)
                    .addViewData("session.purview",purview);
        }

    }
}
