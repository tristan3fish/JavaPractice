package com.t3f;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/data")
public class GraphDataServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/csv");
        resp.getWriter().write(
                "year,population\n"
                + "2006,40\n"
                + "2008,45\n"
                + "2010,48\n"
                + "2012,51\n"
                + "2014,53\n"
                + "2016,57\n"
                + "2017,62\n"
        );

    }
}
