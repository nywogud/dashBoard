package com.jhl.dashBoard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhl.dashBoard.chart.NumAttem;
import com.jhl.dashBoard.model.DataModel;
import com.jhl.dashBoard.service.DataService;


@CrossOrigin
@Controller
public class homeController {
	
	@Autowired
	DataService dataService;
	
	@RequestMapping("/")
	public String home(Model model) throws Exception {
		
		//각 칼럼의 인증 수단 별 시도 횟수를 반환하는 서비스 객체(리스트 타입으로 반환) 
		List<DataModel> resultList =  dataService.getNumAttem();
		
		//html 소스를 만들어 주는 객체 생성
		NumAttem numAttem = new NumAttem();
		
		//html 소스를 만들어 주는 함수. 파라미터는 각 인증 수단과 시도 횟수를 저장하고 있는 데이터모델 타입의 리스트
		String htmlString = numAttem.resultHtml(resultList);
		
		//모델 객체에 담아 뷰에 전달.
		model.addAttribute("htmlString", htmlString);
		
		return "home";
	}
}
