package com.example.aramide.myapplication.backend;

/**
 * Created by aramide on 15/03/2016.
 */

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.*;

public class ServletReturnBulk extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String nameParam = req.getParameter("name");
        resp.setContentType("text/plain");
        PrintWriter info = resp.getWriter();
        info.print("Content linked is: ");
        info.print(nameParam);

        //PrintWriter out = resp.getWriter();
        info.println("Servlet successful call. Now let's attempt another get...");

    }
}
