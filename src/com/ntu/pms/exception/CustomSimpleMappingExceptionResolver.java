package com.ntu.pms.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

public class CustomSimpleMappingExceptionResolver extends SimpleMappingExceptionResolver {

    private static final Logger LOGGER = Logger.getLogger(CustomSimpleMappingExceptionResolver.class);
    private HttpServletRequest request;

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) {
        this.request = request;
        ModelAndView mav = new ModelAndView();
        // TODO 异常处理模块
        if (ex instanceof Exception) {
            if (ex instanceof ValidationException) {
                String message = ex.getMessage();
                mav.setView(new MappingJackson2JsonView());
                mav.addObject("exceptionMessage", message);
                mav.addObject("validate", false);
            }
            return mav;
        } else {
            LOGGER.error(ex.getStackTrace(), ex);
            return null;
        }
    }

    private boolean isAjaxRequest(HttpServletRequest request) {
        String header = request.getHeader("X-Requested-With");

        if (header != null && "XMLHttpRequest".equals(header)) {
            return true;
        } else {
            return false;
        }
    }
}
