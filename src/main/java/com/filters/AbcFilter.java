package com.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/hello.world")
public class AbcFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        PrintWriter out = servletResponse.getWriter();

        String param = servletRequest.getParameter("param");
        if (param == null) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else if (param.equals("abc")) {
            out.print("<style> h1 {background-color: #2D2D2D; color: #C26356; font-size: 50px;\" +\n" +
                    "\"font-family: Menlo, Monaco, fixed-width;} </style><h1> abc Hello World abc</h1>");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
