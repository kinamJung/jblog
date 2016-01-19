package com.hanains.jblog.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hanains.jblog.annotation.Auth;
import com.hanains.jblog.dto.CategoryPostCntDTO;
import com.hanains.jblog.service.BlogService;
import com.hanains.jblog.service.CategoryService;
import com.hanains.jblog.service.PostService;
import com.hanains.jblog.vo.BlogVo;
import com.hanains.jblog.vo.CategoryVo;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@Autowired 
	BlogService blogService;
	
	@Autowired
	PostService postService;
	
	
	@RequestMapping("/insert")
	public String insertCategory(@ModelAttribute CategoryVo vo, Model model){
		
		categoryService.insertCategoryService(vo);
		model.addAttribute("blogID", vo.getBlogID());
		
		
		model.addAttribute("menu", "category");
		
		return "redirect:/category/list";
	}
	
	@Auth
	@RequestMapping("/list")
	public String display(@ModelAttribute CategoryVo vo, Model model){
		BlogVo blogVo = blogService.showBlog(vo.getBlogID());
		
		List<CategoryVo> list = categoryService.showCategoryService(vo.getBlogID());
		
		List<CategoryPostCntDTO>  postCount = postService.getPostCount();
		
		model.addAttribute("blog", blogVo);
		model.addAttribute("categoryList", list);
		System.out.println("categoryListCnt: " + list.size() );
		model.addAttribute("postCountWithCategory", postCount);
		return "/blog/blogadmin_category";
	}
	
	
	
	
}
