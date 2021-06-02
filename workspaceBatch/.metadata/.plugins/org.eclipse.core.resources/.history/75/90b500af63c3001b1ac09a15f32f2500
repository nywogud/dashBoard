package com.jhl.batchTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhl.batchTest.dao.MemberDAO;
import com.jhl.batchTest.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDAO memberDAO;
	
	@Override
	public List<MemberVO> getMembers() throws Exception{
		return memberDAO.getMembers();
	}
	
	@Override
	public void insertData(int memberId, String name) throws Exception{
		memberDAO.insertData(memberId, name);
	}
	
	@Override
	public void insertDataC(int memberId, String name) throws Exception{
		memberDAO.insertDataC(memberId, name);
	}
	
	@Override
	public void commit() throws Exception{
		memberDAO.commit();
	}
	
	@Override
	public void truncateData() throws Exception{
		memberDAO.truncateData();
	}

}
