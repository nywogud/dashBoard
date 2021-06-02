package com.jhl.batchTest.main;

import org.springframework.beans.factory.annotation.Autowired;

import com.jhl.batchTest.controller.HomeController;
import com.jhl.batchTest.dao.MemberDAO;
import com.jhl.batchTest.service.MemberService;

public class ExecuTest {
	
	@Autowired
	HomeController homeController;
	
	@Autowired
	MemberService mewMemberService;
	
	@Autowired
	MemberDAO memberDAO;

	public static void main(String[] args) throws Exception {
		HomeController hc = new HomeController();
		hc.home();
	}
}
