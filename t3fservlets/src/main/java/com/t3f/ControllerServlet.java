package com.t3f;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/home")
public class ControllerServlet extends HttpServlet {

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	    User user = new User("Fred", "fred@fred.com");

        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/index.jsp");

        req.setAttribute("user", user);
        dispatcher.forward(req, resp);


    }

}
