package com.jhl.batchTest.service;

import java.util.List;

import com.jhl.batchTest.vo.MemberVO;

public interface MemberService {
	
	public List<MemberVO> getMembers() throws Exception;

	public void insertData(int memberId, String name) throws Exception;
	
	public void insertDataC(int memberId, String name) throws Exception;

	public void commit() throws Exception;

	public void truncateData() throws Exception;

}
