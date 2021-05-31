package com.jhl.dashBoard.chart;

import java.util.List;

import com.jhl.dashBoard.model.DataModel;

public class CountNumAttem {
	
	public String countNumAttem(List<DataModel> resultList) {
		
		String scriptString = "<script type=\"text/javascript\">\r\n"
				+ "    google.charts.load(\"current\", {packages:['corechart']});\r\n"
				+ "    google.charts.setOnLoadCallback(drawChart);\r\n"
				+ "    function drawChart() {\r\n"
				+ "      var data = google.visualization.arrayToDataTable([\r\n"
				+ "        [\"시도횟수\", \"분포\", { role: \"style\" } ],\r\n";
		
				for (int i=0; i<resultList.size(); i++) {
					scriptString += "['" + resultList.get(i).getNumAttem() + "', " +resultList.get(i).getCountNumAttem() + ", \"#4374D9\"],\r\n";
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
				+ "        title: \"인증 시도 횟수 분포\",\r\n"
				+ "        width: 600,\r\n"
				+ "        height: 400,\r\n"
				+ "        bar: {groupWidth: \"95%\"},\r\n"
				+ "        legend: { position: \"none\" },\r\n"
				+ "      };\r\n"
				+ "      var chart = new google.visualization.ColumnChart(document.getElementById(\"countNumAttem\"));\r\n"
				+ "      chart.draw(view, options);\r\n"
				+ "  }\r\n"
				+ "  </script>";
				
		
		return scriptString;
	}

}
