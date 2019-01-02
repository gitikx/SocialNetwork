package com.senla.filter;

import com.senla.utils.JwtUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter(filterName = "myFilter", urlPatterns = "/*")
public class AuthFilter implements Filter {

    private boolean verifyToken(String token) {
        try {
            return (!JwtUtil.verifyToken(token).equals(null));
        } catch (Exception ex) {
            return false;
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request1 = (HttpServletRequest) request;
        HttpServletResponse response1 = (HttpServletResponse) response;
        HttpSession session = request1.getSession();
        boolean isAuthorized;
        try {
            isAuthorized = verifyToken(session.getAttribute("authToken").toString());
        } catch (Exception ex) {
            isAuthorized = false;
        }
        if (request1.getRequestURI().equals("/login") || request1.getRequestURI().equals("/register")) {
            if (isAuthorized) {
                response1.sendRedirect("/myPage");
            } else {
                chain.doFilter(request, response);
            }
        } else if (request1.getRequestURI().equals("/") && isAuthorized) {
            if (isAuthorized) {
                response1.sendRedirect("/myPage");
            } else {
                response1.sendRedirect("/login");
            }
        } else if (!isAuthorized) {
            response1.sendRedirect("/login");
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}