package com.hanains.jblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hanains.jblog.service.BlogService;
import com.hanains.jblog.service.CategoryService;
import com.hanains.jblog.service.PostService;
import com.hanains.jblog.vo.BlogVo;
import com.hanains.jblog.vo.CategoryVo;
import com.hanains.jblog.vo.PostVo;

@Controller
@RequestMapping("/post")
public class PostController {

	
	@Autowired 
	BlogService blogService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	PostService postService;
	
	@RequestMapping("/write")
	public String write(@ModelAttribute PostVo vo, @RequestParam("blogID")String blogid){
		
		postService.insertPost(vo);
		
		
		return "redirect:/blog/"+blogid;
	}
	
	@RequestMapping("/writeform")
	public String writeform(@ModelAttribute CategoryVo vo, Model model){
		
		
		BlogVo blogVo = blogService.showBlog(vo.getBlogID());
		List<CategoryVo> categoryList =  categoryService.showCategoryService(vo.getBlogID());
		
		model.addAttribute("category", categoryList);
		model.addAttribute("blog", blogVo);
		return "/blog/blogadmin_write";
	}
	
	
}
