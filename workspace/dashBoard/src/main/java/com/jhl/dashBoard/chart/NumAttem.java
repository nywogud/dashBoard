package com.jhl.dashBoard.chart;

import java.util.List;

import com.jhl.dashBoard.model.DataModel;


public class NumAttem {
	//각 좌표를 채워주는 반복문을 실행하며 html 텍스트를 완성
	public String resultHtml(List<DataModel> resultList) {
		
		String script = "<script type=\"text/javascript\">\r\n"
				+ "      google.charts.load('current', {'packages':['bar']});\r\n"
				+ "      google.charts.setOnLoadCallback(drawStuff);\r\n"
				+ "\r\n"
				+ "      function drawStuff() {\r\n"
				+ "        var data = new google.visualization.arrayToDataTable([\r\n"
				+ "          ['인증 수단', '시도횟수'],\r\n";
		
				for(int i =0; i<resultList.size(); i++) {
					
					
					script += "['" + resultList.get(i).getMethod() + "', " + resultList.get(i).getNumAttem() + "],\r\n";
				}
						
				script += "        ]);\r\n"
				+ "        var options = {\r\n"
				+ "          title: '인증 수단 별 시도 횟수',\r\n"
				+ "          width: 500,\r\n"
				+ "          legend: { position: 'none' },\r\n"
				+ "          chart: { title: '인증 수단 별 시도 횟수' },\r\n"
				+ "          bars: 'horizontal', // Required for Material Bar Charts.\r\n"
				+ "          axes: {\r\n"
				+ "            x: {\r\n"
				+ "              0: { side: 'top', label: '시도횟수'} // Top x-axis.\r\n"
				+ "            }\r\n"
				+ "          },\r\n"
				+ "          bar: { groupWidth: \"90%\" },\r\n"
				+ "        };\r\n"
				+ "\r\n"
				+ "        var chart = new google.charts.Bar(document.getElementById('numAttem'));\r\n"
				+ "        chart.draw(data, options);\r\n"
				+ "      };\r\n"
				+ "</script>";
		
		//script 텍스트를 반환	
		return script;
		
	}
}
