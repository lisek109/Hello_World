package com.filters;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AbcFilterTest {

    @Test
    void shouldReturnModifiedResponseWhenRequestParamIsABC() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        FilterChain filterChain = mock(FilterChain.class);

        when(request.getParameter("param")).thenReturn("abc");

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        new AbcFilter().doFilter(request, response, filterChain);

        assertEquals("<style> h1 {background-color: #2D2D2D; color: #C26356; font-size: 50px;\" +\n" +
                "\"font-family: Menlo, Monaco, fixed-width;} </style><h1> abc Hello World abc</h1>", stringWriter.toString());
    }
}