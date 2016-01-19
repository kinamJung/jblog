package com.hanains.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanains.jblog.dao.CategoryDao;
import com.hanains.jblog.vo.CategoryVo;

@Service
public class CategoryService {

	@Autowired
	CategoryDao categoryDao;
	
	public void insertCategoryService(CategoryVo vo){
		categoryDao.insert(vo);
	}
	
	/*public List<CategoryVo> showCategoryService(CategoryVo vo){	
		List<CategoryVo> list = categoryDao.get(vo.getBlogID());		
		return list;
	}*/
	
	public List<CategoryVo> showCategoryService(String id){	
		List<CategoryVo> list = categoryDao.get(id);		
		return list;
	}
	
}
