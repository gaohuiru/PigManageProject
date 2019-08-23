package com.bd.pigmanage.controller;

import com.bd.pigmanage.service.BaseService;

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
        String[] split = requestURI.split("/");
        //获取返回值地址
        String address = split[1];
        //截取出参数地址
        String uri = "/" + split[2] + "/" + split[3];
        String substring = requestURI.substring(requestURI.indexOf("/"));
        System.out.println(substring);

        //获取请求参数
        Map<String, String[]> parameterMap = req.getParameterMap();

        Map<String,List<Object>> reqMap = new HashMap<>();

        for (Map.Entry<String,String[]> entry:parameterMap.entrySet()) {
            List<Object> paramList = new ArrayList<>();

            String mapKey = entry.getKey();
            String[] mapValue = entry.getValue();

            paramList.add(mapValue[0]);
            reqMap.put(mapKey,paramList);

            System.out.println(mapKey+":"+mapValue[0]);
        }
        //传递给BaseService
        new BaseService(uri,reqMap);

        List<Object> result = reqMap.get("result");
        System.out.println(result.get(0));

        req.getRequestDispatcher("/"+address+".jsp").forward(req,resp);
    }
}
