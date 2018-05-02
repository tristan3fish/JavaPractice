package com.mantiso;

//import com.tristan3fish.wallpaintings.AllocationStrategies.MyPermutationAllocation;
//import com.tristan3fish.wallpaintings.Gallery;
//import com.tristan3fish.wallpaintings.GalleryFillers.RandomGalleryFiller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tristan on 29/01/2015.
 */
@WebServlet("/m")
public class MyServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().write("<h2>Hello World</h2>");
        resp.getWriter().write("<h2>H!!!!!!!!!</h2>");
        resp.getWriter().write("<h2>H!!!!!!!!!</h2>");
        resp.getWriter().write("<h2>H!!!!!!!!!</h2>");


//        Gallery gallery = new Gallery();
//        gallery.populate(new RandomGalleryFiller());
//        gallery.allocatePaintings(new MyPermutationAllocation(0.96));
//        gallery.printStats();

    }


}
