package com.hanains.jblog.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hanains.jblog.annotation.Auth;
import com.hanains.jblog.vo.MemberVo;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if( handler instanceof HandlerMethod == false){
			return true;
		}
		
		Auth auth = ((HandlerMethod)handler).getMethodAnnotation(Auth.class);
		if(auth == null){
			return true;
		}
		
		HttpSession session = request.getSession();
		if( session == null){
			response.sendRedirect(request.getContextPath());
			return false;
		}
		
		MemberVo user = (MemberVo)session.getAttribute("user");
		String blogID = request.getParameter("blogID");
		
		System.out.println("User :" + user);
		System.out.println("blogID:" + blogID);
		
		if( user == null ){
			response.sendRedirect(request.getContextPath()+"/blog/"+blogID);
			return false;
		}
		
		if( user.getId().equals( blogID ) == false){
			response.sendRedirect(request.getContextPath()+"/blog/"+blogID);
			return false;
		}
		
		return true;
	}
	
	
}
