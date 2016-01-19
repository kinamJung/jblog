package com.hanains.jblog.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanains.jblog.dto.CategoryPostCntDTO;
import com.hanains.jblog.vo.CategoryVo;
import com.hanains.jblog.vo.PostVo;

@Repository
public class PostDao {

	@Autowired
	SqlSession sqlsession;
	
	public List<CategoryPostCntDTO> getCount(){
		
		List<CategoryPostCntDTO>  postCount = sqlsession.selectList("post.getCount");
		
		return postCount;
		
	}
	
	public void insert(PostVo vo){
		sqlsession.insert("post.insert", vo);
	}
	
	
}
