package com.helloworld;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello.world")
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {

        resp.setContentType("text/html");
        PrintWriter pr = resp.getWriter();
        pr.write("<style> h1 {background-color: #2D2D2D; color: #C26356; font-size: 50px;" +
                "font-family: Menlo, Monaco, fixed-width;} </style><h1> Hello World</h1>");
    }


    }

