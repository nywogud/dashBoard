package com.jhl.dashBoard.chart;

import java.util.ArrayList;
import java.util.List;

import com.jhl.dashBoard.model.DataModel;

public class SucPerFail {
	
	public String sucPerFail(List<DataModel> sucResultNum , ArrayList<Object> sucPerFailResult) {
		
		String scriptString = "<script type=\"text/javascript\">\r\n"
				+ "    google.charts.load(\"current\", {packages:['corechart']});\r\n"
				+ "    google.charts.setOnLoadCallback(drawChart);\r\n"
				+ "    function drawChart() {\r\n"
				+ "      var data = google.visualization.arrayToDataTable([\r\n"
				+ "        [\"인증 수단\", \"실패 대비 성공 건수\", { role: \"style\" } ],\r\n";
		
				for (int i=0; i<sucResultNum.size(); i++) {
					scriptString += "['" + sucResultNum.get(i).getMethod() + "', " +sucPerFailResult.get(i)+ ", \"#4374D9\"],\r\n";
				}
				
				
				scriptString += "      ]);\r\n"
				+ "\r\n"
				+ "      var view = new google.visualization.DataView(data);\r\n"
				+ "      view.setColumns([0, 1,\r\n"
				+ "                       { calc: \"stringify\",\r\n"
				+ "                         sourceColumn: 1,\r\n"
				+ "                         type: \"string\",\r\n"
				+ "                         role: \"annotation\" },\r\n"
				+ "                       2]);\r\n"
				+ "\r\n"
				+ "      var options = {\r\n"
				+ "        title: \"결제 수단 별 실패 대비 성공 건수\",\r\n"
				+ "        width: 600,\r\n"
				+ "        height: 400,\r\n"
				+ "        bar: {groupWidth: \"95%\"},\r\n"
				+ "        legend: { position: \"none\" },\r\n"
				+ "      };\r\n"
				+ "      var chart = new google.visualization.ColumnChart(document.getElementById(\"sucPerFail\"));\r\n"
				+ "      chart.draw(view, options);\r\n"
				+ "  }\r\n"
				+ "  </script>"
				+ "			<div id=\"sucPerFail\" style=\"width: 600px; height: 350px;\"></div>";
		
		return scriptString;
	}

}
