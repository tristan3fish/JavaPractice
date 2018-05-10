package com.t3f;


import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
//import javax.servlet.

//@WebServlet("/home")
public class HelloServlet extends HttpServlet {

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


	    //resp.setContentType("text/html");

        displayHelloMessage(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        displayHelloMessage(req, resp);
    }

    private void displayHelloMessage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");

        if(StringUtils.isNotEmpty(name)){
            PrintWriter writer = null;
            writer = resp.getWriter();
            writer.printf("Hello %s", name);
        }/*else {
            resp.sendRedirect("index.jsp");
        }*/
    }
}
