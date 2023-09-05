package com.kh.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.api.dao.PhoneDAOImpl;
import com.kh.api.model.Phone;
import com.kh.api.model.UserInfo;

@Service
public class PhoneServiceImpl implements PhoneService{

	@Autowired
	private PhoneDAOImpl dao;

	@Override
	public int insert(Phone phone) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Phone phone) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Phone select(String num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Phone> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo select(UserInfo user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
