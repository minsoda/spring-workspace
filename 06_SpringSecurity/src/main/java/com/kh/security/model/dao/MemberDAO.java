package com.kh.security.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.security.model.vo.Member;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate session;
	
	public int registerMember(Member vo) {
		return session.insert("memberMapper.registerMember", vo);
	}
	//username 이지만 id로 바꿔도 된다
	public Member getMemberById(String id) {
		return session.selectOne("memberMapper.getMemberById", id);
	}
	
}
