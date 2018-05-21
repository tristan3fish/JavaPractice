package com.t3f;


import com.t3f.model.MultiChoiceQuestion;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AnswerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String proposedAnswer = req.getParameter("proposedAnswer");
        MultiChoiceQuestion question = (MultiChoiceQuestion) req.getSession().getAttribute("question");

        if(StringUtils.isNotEmpty(proposedAnswer)){
            PrintWriter writer = resp.getWriter();
            
            String result = "Your proposed answer of " + proposedAnswer + " is " + question.isCorrectAnswer(proposedAnswer);
            
            writer.print(result);
        }
    }
}
