package com.hanains.jblog.annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.hanains.jblog.vo.MemberVo;


public class AuthUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

	
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		// TODO Auto-generated method stub
		return (parameter.getParameterAnnotation(AuthUser.class) != null ) && ( parameter.getParameterType().equals( MemberVo.class) == true );
	
	}
	
	@Override
	public Object resolveArgument(MethodParameter parameter, 
			ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
			WebDataBinderFactory binderFactory) throws Exception {
		
		System.out.println("AuthUserHandlerMethodArgumentResolver");
		
		if( this.supportsParameter(parameter) == false ){
			return WebArgumentResolver.UNRESOLVED;
		}
		
		HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
		HttpSession session = request.getSession();
		
		if( session == null ){
			return WebArgumentResolver.UNRESOLVED;
		}
		
		MemberVo authUser = (MemberVo)session.getAttribute("user");
		
		return authUser;
	}
}
