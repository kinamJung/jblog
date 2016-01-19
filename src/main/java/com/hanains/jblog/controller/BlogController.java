package com.hanains.jblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hanains.jblog.annotation.Auth;
import com.hanains.jblog.annotation.AuthUser;
import com.hanains.jblog.service.BlogService;
import com.hanains.jblog.service.CategoryService;
import com.hanains.jblog.vo.BlogVo;
import com.hanains.jblog.vo.CategoryVo;
import com.hanains.jblog.vo.MemberVo;

@Controller
@RequestMapping("/blog")
public class BlogController {

	@Autowired
	BlogService blogService;
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value="/{id}")
	public String goBlog(@PathVariable("id")String id, Model model){

		BlogVo blogVo = blogService.showBlog(id);
		List<CategoryVo> categoryList = categoryService.showCategoryService(id);
		
		
		model.addAttribute("blog", blogVo);
		model.addAttribute("category", categoryList);
		return "/blog/blogmain";
	}
	
	@RequestMapping("/loginformInblog")
	public String loginformInblog(@RequestParam("blogID")String id, Model model){
		
		model.addAttribute("blogID", id);
		return "/user/loginform";
	}
	
	@Auth
	@RequestMapping("/admin")
	public String admin(@RequestParam("blogID")String blogId, Model model){
		
		BlogVo vo = blogService.showBlog(blogId);
		model.addAttribute("blog", vo);
		model.addAttribute("menu", "defalut");
		return "/blog/blogadmin_basic";
	}
	
	@RequestMapping("/update")
	public String update(@ModelAttribute BlogVo vo, Model model){
		
		blogService.updateBlog(vo);
		
		return "redirect:/blog/"+vo.getId();
	}
	
	
	
}
