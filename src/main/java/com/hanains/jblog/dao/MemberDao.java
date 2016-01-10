package com.hanains.jblog.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanains.jblog.vo.MemberVo;

@Repository
public class MemberDao {

	@Autowired
	private SqlSession sqlSession;
	
	public MemberVo getMember(MemberVo vo){
		MemberVo memberVo = sqlSession.selectOne("member.get", vo);		
		return memberVo;
	}
	
	public void insertMember(MemberVo vo){
		sqlSession.insert("member.insert",vo);
	}
	
	public List<MemberVo> getMember(){
		List<MemberVo> memberList = sqlSession.selectList("member.getAllData");
		return memberList;
	}
	
	
}
