package com.jhl.dashBoard.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jhl.dashBoard.chart.CountNumAttem;
import com.jhl.dashBoard.chart.FailResultNum;
import com.jhl.dashBoard.chart.NumAttem;
import com.jhl.dashBoard.chart.SucPerFail;
import com.jhl.dashBoard.chart.SucResultNum;
import com.jhl.dashBoard.model.DataModel;
import com.jhl.dashBoard.service.DataService;

@CrossOrigin
@Controller
public class homeController {

	private static final String FILE_SERVER_PATH = "D:/uploadCVS/";
	
	@Autowired
	DataService dataService;

	@RequestMapping("/")
	public String home(Model model) throws Exception {

		// 인증수단별 시도횟수 차트를 생성하는 로직
		// 각 칼럼의 인증 수단 별 시도 횟수를 반환하는 서비스 객체(리스트 타입으로 반환)
		List<DataModel> result1List = dataService.getNumAttem();

		// 자바스크립트 소스를 만들어 주는 클래스 객체 생성
		NumAttem numAttem = new NumAttem();

		// 자바스크립트 소스를 만들어 주는 함수. 파라미터는 각 인증 수단과 시도 횟수를 저장하고 있는 데이터모델 타입의 리스트
		String scriptString = numAttem.resultHtml(result1List);

		// 모델 객체에 담아 뷰에 전달.
		model.addAttribute("script1String", scriptString);

		// 인증시도 횟수 분포 차트를 생성하는 로직(시도횟수 분포 확인)
		List<DataModel> result2List = dataService.getConuntNumAttem();

		CountNumAttem countNumAttem = new CountNumAttem();

		String script2String = countNumAttem.countNumAttem(result2List);

		model.addAttribute("script2String", script2String);

		// 표 차트 내용을 뷰에 전달하는 코드

		List<DataModel> numAttemWithRowNum = dataService.getNumAttemWithRowNum();

		model.addAttribute("numAttemWithRowNum", numAttemWithRowNum);

		List<DataModel> ResultNum = dataService.getSucResultNum();
		SucResultNum sucResultNum = new SucResultNum();
		String scriptButton1 = sucResultNum.sucResultNum(ResultNum);
		model.addAttribute("scriptButton1", scriptButton1);
		return "home";
	}

	// 각 메소트 별 성공 건수 조회, 전송(ajax 통신, button1)
	@RequestMapping(value = "/sucResultNum", method = RequestMethod.POST)
	@ResponseBody
	public String sucResultNum() throws Exception {
		List<DataModel> ResultNum = dataService.getSucResultNum();
		SucResultNum sucResultNum = new SucResultNum();
		String scriptButton1 = sucResultNum.sucResultNum(ResultNum);

		return scriptButton1;
	}

	// 각 메소트 별 실패 건수 조회, 전송(ajax 통신, button2)
	@RequestMapping(value = "/failResultNum", method = RequestMethod.POST)
	@ResponseBody
	public String failResultNum() throws Exception {
		List<DataModel> ResultNum = dataService.getFailResultNum();
		FailResultNum failResultNum = new FailResultNum();
		String scriptButton2 = failResultNum.failResultNum(ResultNum);

		return scriptButton2;
	}

	// 각 메소트 별 성공 건수 대비 실패 건수(ajax 통신, button3)
	@RequestMapping(value = "/sucPerFail", method = RequestMethod.POST)
	@ResponseBody
	public String sucPerFail() throws Exception {
		List<DataModel> sucResultNum = dataService.getSucResultNum();
		List<DataModel> failResultNum = dataService.getFailResultNum();
		
		//arrayList 확인해야 함.
		ArrayList<Object> sucPerFailResult = new ArrayList<>();
		
		for(int i=0; i<sucResultNum.size(); i++) {
			sucPerFailResult.add(sucResultNum.get(i).getSucResultNum()/failResultNum.get(i).getFailResultNum());
		}
		
		SucPerFail sucPerFail = new SucPerFail();
		String scriptButton3 = sucPerFail.sucPerFail(sucResultNum, sucPerFailResult);
		
		return scriptButton3;
	}
	
	//파일 업로드 맵핑. 디비 델리트와 커밋, 인서트와 커밋을 진행하고서 다시 홈 화면으로 redirect함.
	@RequestMapping(value="/fileUpload", method= RequestMethod.POST)
	public String fileUpload(@RequestParam("fileCsv") MultipartFile file, DataModel dataModel) throws Exception{
		//파일 로컬에 저장 확인
		file.transferTo(new File(FILE_SERVER_PATH, file.getOriginalFilename()));
		//파일의 풀 url 저장
		String fileLoca = FILE_SERVER_PATH + file.getOriginalFilename();
		
		//2차원 리스트를 만들어 각 row를 DB에 insert
		List<List<String>> insertCVS = new ArrayList<List<String>>();
		BufferedReader br = null;
		
		try {
			br = Files.newBufferedReader(Paths.get(fileLoca));
			
			String line ="";
			
			while((line = br.readLine()) !=null) {
				List<String> temp = new ArrayList<String>();
				String array[]= line.trim().split(",");
				temp = Arrays.asList(array);
				insertCVS.add(temp);
			}
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(br != null) {
					br.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		//디비 델리트 로직 먼저 실행
		dataService.deleteDB();
		
		dataService.doCommit();
		
		//값 읽어옴(트림으로 공백 제거해 사용해야 함.)
		for(int i =1; i< insertCVS.size(); i++ ) {
			int testNumber = i+1;
			if(i !=0) {
								
				dataModel.setTestNumber(testNumber);
				dataModel.setMethod(insertCVS.get(i).get(0).trim());
				dataModel.setResult(insertCVS.get(i).get(1).trim());
				
				dataService.insertCVS(dataModel);
			}
		}
		
		dataService.doCommit();
			
		return "redirect:/";
	}

}
