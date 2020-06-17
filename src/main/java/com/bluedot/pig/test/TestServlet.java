package com.bluedot.pig.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("html/text;charset=utf-8");

        User user1 = new User();
        user1.setId(1);
        user1.setName("陈");
        User user2 = new User();
        user2.setId(2);
        user2.setName("wang");

        List<Object> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        req.setAttribute("userList",userList);
        req.getRequestDispatcher("test.jsp").forward(req,resp);
    }
}
