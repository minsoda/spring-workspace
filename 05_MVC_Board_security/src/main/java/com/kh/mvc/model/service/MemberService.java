package com.kh.mvc.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kh.mvc.model.dao.MemberDAO;
import com.kh.mvc.model.vo.Member;

@Service
public class MemberService implements UserDetailsService{

	@Autowired
	private MemberDAO dao;

	// 작성후 security-context 작성
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//로그인시 username이 여기로 옴
		Member member = dao.getMemberById(username);
		
		 if(member==null) {
			 throw new UsernameNotFoundException("username not found");
		 }
		return member;
	}
	
	public int register(Member vo) {
		return dao.register(vo);
	}
	}


