package com.hanains.jblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hanains.jblog.service.MemberService;
import com.hanains.jblog.vo.MemberVo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	MemberService memberService;
	
	@RequestMapping("/loginform")
	public String loginform(){
		return "/user/login";
	}
	
	@RequestMapping("/loginformInblog")
	public String loginformWithBlog(){
		return "/user/loginform";
	}
	
	@RequestMapping("/userRegisterForm")
	public String userRegisterForm(){
		return "/user/userRegisterForm";
	}

	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String regist(@ModelAttribute MemberVo vo){
		vo.setRole("USER");
		memberService.regist(vo);
		return "redirect:/";
	}
	
	@RequestMapping("/userlist")
	public String userList( Model model ){
		
		List<MemberVo> memberList = memberService.showUserList();
		model.addAttribute("userlist", memberList);
		model.addAttribute("userCount", memberList.size());
		
		return "/user/userlist"; 
	}
	
	
}
