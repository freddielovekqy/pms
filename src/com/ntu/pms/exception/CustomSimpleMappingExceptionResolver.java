package com.ntu.pms.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class CustomSimpleMappingExceptionResolver extends SimpleMappingExceptionResolver {

    private static final Logger LOGGER = Logger.getLogger(CustomSimpleMappingExceptionResolver.class);
    private HttpServletRequest request;

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) {
        this.request = request;
        // TODO 异常处理模块
        if (ex instanceof Exception) {
            return null;
        } else {
            LOGGER.error(ex.getStackTrace(), ex);
            return null;
        }
    }

    private boolean isAjaxRequest(HttpServletRequest request2) {
        // TODO Auto-generated method stub
        return false;
    }
}
