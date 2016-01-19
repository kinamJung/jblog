package com.hanains.jblog.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanains.jblog.vo.BlogVo;
import com.hanains.jblog.vo.MemberVo;

@Repository
public class BlogDao {

	@Autowired
	private SqlSession sqlSession;
	
	public void insert(BlogVo vo){
		sqlSession.insert("blog.insert", vo);		
	}
	
	public BlogVo get(MemberVo vo){
		BlogVo blogVo = sqlSession.selectOne("blog.get", vo);
		return blogVo;
	}
	
	public BlogVo get(String id){
		BlogVo blogVo = sqlSession.selectOne("blog.getById", id);
		return blogVo;
	}
	
	public void update(BlogVo vo){
		System.out.println("update:" + vo);
		sqlSession.update("blog.update",vo);
	}
	
}
