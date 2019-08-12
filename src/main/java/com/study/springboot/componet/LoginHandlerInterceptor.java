package com.study.springboot.componet;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Alfie
 * @date 2019/8/12 0012 20:51
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        if(user == null){
            request.setAttribute("msg","没有权限访问");
            request.getRequestDispatcher("/index.html").forward(request,response );
            return false;
        }else {
            return true;
        }

    }
}
