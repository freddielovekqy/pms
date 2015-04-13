package com.ntu.pms.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import com.ntu.pms.constant.OtherConstants;
import com.ntu.pms.constant.PageNameConstant;

public class LoginFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        boolean doFilter = true;
        String[] noFilters = new String[] { "/images", "/js", "/css", "/user/register", "/user/logout",
                "/user/checkUser", "/user/login" };

        for (String noFilter : noFilters) {
            if (uri.indexOf(noFilter) != -1) {
                doFilter = false;
                break;
            }
        }

        if (doFilter) {
            Object user = request.getSession().getAttribute(OtherConstants.CURRRENT_USER);
            if (user == null) {
                response.sendRedirect("../" + PageNameConstant.PAGE_NAME_USER_LOGIN);
                return;
            }
        }
        filterChain.doFilter(request, response);
    }
}
