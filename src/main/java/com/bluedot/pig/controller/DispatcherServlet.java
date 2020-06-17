package com.bluedot.pig.controller;

import com.bluedot.pig.service.HandlerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chb
 */
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //获取URI
        String requestURI = req.getRequestURI();
        System.out.println("获取到的URI"+requestURI);
        String[] split = requestURI.split("/");
        //获取返回值地址
        String address = split[1];
        //截取出参数地址
        String uri = "/" + split[2] + "/" + split[3]+"/"+split[4];

        //获取请求参数
        Map<String, String[]> parameterMap = req.getParameterMap();

        //遍历出请求参数并把它存入List,再把key和参数传入reqMap
        Map<String,List<Object>> reqMap = new HashMap<>();
        for (Map.Entry<String,String[]> entry:parameterMap.entrySet()) {
            List<Object> paramList = new ArrayList<>();

            String mapKey = entry.getKey();
            String[] mapValue = entry.getValue();
            //先加入到List中，然后加入到reqMap中
            for (int i = 0; i < mapValue.length; i++) {
                paramList.add(mapValue[i]);
            }
            reqMap.put(mapKey,paramList);

            System.out.println(mapKey+":"+mapValue[0]);
        }

        //传递给HandlerService进行解析调用具体Service执行操作
        new HandlerService(uri,reqMap);

        //获取操作完成后的结果

        System.out.println("Servlet层的反馈结果： "+reqMap.get("result").get(0));
        System.out.println("Servlet层的获取到的Key个数： "+reqMap.size());
        if(reqMap.containsKey("DiseaseJudgeSet")) {
            System.out.println("Servlet层的数据显示：" + reqMap.get("DiseaseJudgeSet").get(0));
        }
        if(reqMap.containsKey("PigInfo")) {
            System.out.println("Servlet层的数据显示：" + reqMap.get("PigInfo"));
        }

        System.out.println("Servlet层的显示需要跳转到的页面："+address);
        //

        req.setAttribute("reqMap",reqMap);
        //请求转发至显示界面
        req.getRequestDispatcher("/"+address+".jsp").forward(req,resp);
    }
}
