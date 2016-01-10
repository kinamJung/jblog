package com.hanains.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.hanains.jblog.dao.BlogDao;
import com.hanains.jblog.dao.MemberDao;
import com.hanains.jblog.vo.BlogVo;
import com.hanains.jblog.vo.MemberVo;


@Service
public class MemberService {

	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private BlogDao blogDao;
	
	public MemberVo login(MemberVo vo) {
		MemberVo memberVo = memberDao.getMember(vo);
		return memberVo;
	}
	
	public void regist(MemberVo vo){
		BlogVo blogVo = new BlogVo();
		blogVo.setId(vo.getId());
		blogVo.setTitle("My blog");
		blogVo.setStatus("default");
		blogVo.setTags(" ");
		System.out.println(blogVo);
		
		
		memberDao.insertMember(vo);			
		blogDao.insert(blogVo);
	}
	
	public List<MemberVo> showUserList(){
		
		List<MemberVo> list = memberDao.getMember();
		return list;
		
	}
	
}
