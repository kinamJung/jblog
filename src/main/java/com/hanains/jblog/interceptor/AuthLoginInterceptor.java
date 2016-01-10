package com.hanains.jblog.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hanains.jblog.dao.MemberDao;
import com.hanains.jblog.service.MemberService;
import com.hanains.jblog.vo.MemberVo;

public class AuthLoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		
		String id = request.getParameter("userId");
		String password = request.getParameter("password");
		
		System.out.println("ID: " + id + " password: " + password);
		
		MemberVo vo = new MemberVo();
		vo.setId(id);
		vo.setPassword(password);
		
		ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		MemberService memberService = applicationContext.getBean(MemberService.class);
		
		MemberVo member = memberService.login(vo);
		if( member == null ){
			
		}
		
		HttpSession session = request.getSession(true);
		System.out.println("Interceptor:" + member);
		session.setAttribute("user", member);
		
		response.sendRedirect(request.getContextPath()+"/");
		
		return false;
	}
	
	
	
}
