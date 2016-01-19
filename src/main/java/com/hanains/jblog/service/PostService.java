package com.hanains.jblog.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanains.jblog.dao.PostDao;
import com.hanains.jblog.dto.CategoryPostCntDTO;
import com.hanains.jblog.vo.PostVo;


@Service
public class PostService {

	@Autowired
	PostDao postDao;
	
	public List<CategoryPostCntDTO> getPostCount(){
		
		List<CategoryPostCntDTO> postCount = postDao.getCount();
		return postCount;
	}
	
	public void insertPost(PostVo vo){
		postDao.insert(vo);
	}
	
	
}
