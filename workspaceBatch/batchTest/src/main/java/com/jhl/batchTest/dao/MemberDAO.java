package com.jhl.batchTest.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jhl.batchTest.vo.MemberVO;

@Repository
public interface MemberDAO {
	
	public List<MemberVO> getMembers();

	public void insertData(int memberId, String name);
	
	public void insertDataC(int memberId, String name);

	public void commit();

	public void truncateData();
	
}
