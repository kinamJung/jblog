package com.hanains.jblog.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanains.jblog.vo.BlogVo;
import com.hanains.jblog.vo.CategoryVo;

@Repository
public class CategoryDao {

	@Autowired
	SqlSession sqlsession;
	
	public void insert(CategoryVo vo){
		sqlsession.insert("category.insert",vo);		
	}
	
	public void insert(BlogVo vo){
		sqlsession.insert("category.insertDefalut",vo);		
	}
	
/*	public List<CategoryVo> get(CategoryVo vo){
		
		List<CategoryVo> list = sqlsession.selectList("category.getList", vo.get);
		
		return list;
	}*/
	
	public List<CategoryVo> get(String id){
		
		List<CategoryVo> list = sqlsession.selectList("category.getList", id);
		
		return list;
	}
	
}
