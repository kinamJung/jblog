package com.hanains.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanains.jblog.dao.BlogDao;
import com.hanains.jblog.dao.CategoryDao;
import com.hanains.jblog.vo.BlogVo;
import com.hanains.jblog.vo.CategoryVo;
import com.hanains.jblog.vo.MemberVo;

@Service
public class BlogService {

	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	
	public void insertBlog(BlogVo vo){
		blogDao.insert(vo);
		
		//add defalut category
		CategoryVo cVo = null;
		categoryDao.insert(cVo);
	}
	
	public BlogVo showBlog(MemberVo vo){
		BlogVo blogVo = blogDao.get(vo);
		return blogVo;
	}
	
	public BlogVo showBlog(String id){
		BlogVo blogVo = blogDao.get(id);
		return blogVo;
	}
	
	public void updateBlog(BlogVo vo){
		blogDao.update(vo);
	}
	
}
