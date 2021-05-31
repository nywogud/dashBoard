package com.jhl.dashBoard.chart;

import java.util.List;

import com.jhl.dashBoard.model.DataModel;

public class SucResultNum {
	
	public String sucResultNum(List<DataModel> result) {
		String scriptString = "<!-- 전체 성공 건 중 각 결제수단 성공 비중. 차트 3번. 버튼 1번 -->\r\n"
				+ "			<script type=\"text/javascript\">\r\n"
				+ "      google.charts.load(\"current\", {packages:[\"corechart\"]});\r\n"
				+ "      google.charts.setOnLoadCallback(drawChart);\r\n"
				+ "      function drawChart() {\r\n"
				+ "        var data = google.visualization.arrayToDataTable([\r\n"
				+ "          ['결제수단', '전체 성공 건수 중 각 인증수단 성공 건수 비중'],\r\n";
				
				for(int i=0; i<result.size(); i++) {
					scriptString += "          ['" + result.get(i).getMethod() + "',     " + result.get(i).getSucResultNum() + "],\r\n";
				}
				
				
				scriptString += "        ]);\r\n"
				+ "\r\n"
				+ "        var options = {\r\n"
				+ "          title: '전체 성공 건수 중 각 인증수단 성공 건수 비중',\r\n"
				+ "          is3D: false,\r\n"
				+ "        };\r\n"
				+ "\r\n"
				+ "        var chart = new google.visualization.PieChart(document.getElementById('piechart'));\r\n"
				+ "        chart.draw(data, options);\r\n"
				+ "      }\r\n"
				+ "    </script>\r\n"
				+ "			<div id=\"piechart\" style=\"width: 600px; height: 350px;\"></div>";
				
		return scriptString;
	}

}
