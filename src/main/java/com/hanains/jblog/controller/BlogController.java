package com.hanains.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hanains.jblog.annotation.AuthUser;
import com.hanains.jblog.service.BlogService;
import com.hanains.jblog.vo.BlogVo;
import com.hanains.jblog.vo.MemberVo;

@Controller
@RequestMapping("/blog")
public class BlogController {

	@Autowired
	BlogService blogService;
	
	@RequestMapping(value="/{id}")
	public String goBlog(@PathVariable("id")String id, Model model){

		BlogVo blogVo = blogService.showBlog(id);
		model.addAttribute("blog", blogVo);
		return "/blog/blogmain";
	}
	
	@RequestMapping("/loginformInblog")
	public String loginformInblog(@RequestParam("blogId")String id, Model model){
		
		model.addAttribute("blogId", id);
		return "/user/loginform";
	}
	
}
