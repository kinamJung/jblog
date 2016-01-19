package com.hanains.jblog.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hanains.jblog.service.BlogService;
import com.hanains.jblog.service.MemberService;
import com.hanains.jblog.vo.BlogVo;
import com.hanains.jblog.vo.MemberVo;

public class AuthLoginInBlogInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String blogId = request.getParameter("blogID");
		MemberVo vo = new MemberVo();
		vo.setId(id);
		vo.setPassword(password);
		
		ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		MemberService memberService = applicationContext.getBean(MemberService.class);
		
		MemberVo member = memberService.login(vo);
		if( member == null ){
		}
		
		HttpSession session = request.getSession(true);
		session.setAttribute("user", member);
		
		response.sendRedirect(request.getContextPath()+"/blog/"+blogId);
		
		return false;
	
	}

	
}
