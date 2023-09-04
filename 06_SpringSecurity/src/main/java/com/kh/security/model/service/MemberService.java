package com.kh.security.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kh.security.model.dao.MemberDAO;
import com.kh.security.model.vo.Member;

@Service
public class MemberService implements UserDetailsService{

	@Autowired
	private MemberDAO dao;
	
	public int registerMember(Member vo) {
		return dao.registerMember(vo);
	}

	@Override // login 하고 post하는순간 낚아채서 username(jsp에 정의한 name값)이 여기로 옴. member에서 id로 해놨기때문에 연결이됨.
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member member = dao.getMemberById(username);
		
		if(member==null) {
			// spring이 가지고 있는 오류 
			throw new UsernameNotFoundException("username : " + username + "not found");
		}
		return member;
	}
	
}
