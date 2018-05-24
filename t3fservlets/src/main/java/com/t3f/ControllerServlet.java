package com.t3f;

import com.t3f.repository.TranslationRepository;
import com.t3f.service.QuestionService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControllerServlet extends HttpServlet {

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        QuestionService questionService = new QuestionService(new TranslationRepository());

        req.getSession().setAttribute("question", questionService.generateRandomQuestion());

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/index.jsp");

        dispatcher.forward(req, resp);
    }

}
