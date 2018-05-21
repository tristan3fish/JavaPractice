package com.t3f;

import com.t3f.model.MultiChoiceQuestion;
import com.t3f.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControllerServlet extends HttpServlet {

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        MultiChoiceQuestion question = new MultiChoiceQuestion("1+1","2",new String[]{"5","35"});
        req.getSession().setAttribute("question", question);

        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/index.jsp");

        dispatcher.forward(req, resp);

    }
}
