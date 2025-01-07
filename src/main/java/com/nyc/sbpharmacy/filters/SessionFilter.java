package com.nyc.sbpharmacy.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.print.attribute.standard.PresentationDirection;
import java.io.IOException;

@Component
@Order(1)
public class SessionFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Get the HttpSession from the request object
        HttpSession session = request.getSession();
        if (session.getAttribute("loggedinuser") == null) {
            response.sendRedirect(request.getContextPath() + "/");
        }else{
            filterChain.doFilter(request, response);
        }

    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String url = request.getRequestURL().toString();
       if(url.equals("http://localhost:8080/")
               || url.equals("http://localhost:8080/dologin" )
               || url.contains("/css/")
               || url.contains("/img/")
               || url.contains("/js/")
               || url.contains("/scss/")
               || url.contains("/vendor/")){
           return true;
       }
       return false;
    }

    //    @Override
//    public void doFilter(ServletRequest servletRequest,
//                         ServletResponse servletResponse,
//                         FilterChain filterChain) throws IOException, ServletException {
//        // Get the HttpSession from the request object
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        HttpSession session = request.getSession();
//        if (session.getAttribute("loggedinuser") == null) {
//            response.sendRedirect(request.getContextPath() + "/");
//        }
//        filterChain.doFilter(servletRequest, servletResponse);
//
//    }
}
