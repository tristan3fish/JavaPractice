package com.t3f;


import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/home")
public class SimpleServlet extends HttpServlet {

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String name = req.getParameter("name");

        if(name != null){
            PrintWriter writer = resp.getWriter();

            writer.printf("<h2>Hello %s </h2>", name);
            writer.printf("<h2>Hello %s </h2>", name);
            writer.printf("<h2>Hello %s </h2>", name);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");

        if(StringUtils.isNotEmpty(name)){
            PrintWriter writer = resp.getWriter();

            writer.printf("<h2>Hello %s </h2>", name);
            writer.printf("<h2>Hello %s </h2>", name);
            writer.printf("<h2>Hello %s </h2>", name);

        }else {
            resp.sendRedirect("index.jsp");
        }
    }
}
