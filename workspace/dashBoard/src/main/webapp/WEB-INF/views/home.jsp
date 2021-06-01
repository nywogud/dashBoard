<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Dash board</title>

<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(
			function() {
				$('#button1').click(
						function() {
							$.ajax({
								type : "POST",
								url : "${contextPath}/sucResultNum",
								success : function(result) {
									$("#convertChart").empty();
									$("#convertChart").append(result);
								},

								error : function(request, status, error) {
									alert("code = " + request.status
											+ "message = "
											+ request.responseText + "error = "
											+ error);
								}
							});
						});
			});
</script>

<script type="text/javascript">
	$(document).ready(
			function() {
				$('#button2').click(
						function() {
							$.ajax({
								type : "POST",
								url : "${contextPath}/failResultNum",
								success : function(result) {
									$("#convertChart").empty();
									$("#convertChart").append(result);
								},

								error : function(request, status, error) {
									alert("code = " + request.status
											+ "message = "
											+ request.responseText + "error = "
											+ error);
								}
							});
						});
			});
</script>

<script type="text/javascript">
	$(document).ready(
			function() {
				$('#button3').click(
						function() {
							$.ajax({
								type : "POST",
								url : "${contextPath}/sucPerFail",
								success : function(result) {
									$("#convertChart").empty();
									$("#convertChart").append(result);
								},

								error : function(request, status, error) {
									alert("code = " + request.status
											+ "message = "
											+ request.responseText + "error = "
											+ error);
								}
							});
						});
			});
</script>

</head>
<body>
	<h2>Hello World</h2>
	<input style="display: inline-block;" type="button" id="button1" value="버튼1" />
	<input style="display: inline-block;" type="button" id="button2" value="버튼2" />
	<input style="display: inline-block;" type="button" id="button3" value="버튼3" />

	<form style="display: inline-block; float:right;" method="POST" action="fileUpload" enctype="multipart/form-data">
		<input name="fileCsv" type="file" placeholder="CVS파일 업로드" /> 
		<input type="submit" name="upload" value="CSV파일 올리기"/>
	</form>

	<div>

		<script type="text/javascript"
			src="https://www.gstatic.com/charts/loader.js"></script>
		<!-- 결제 수단별 시도 횟수 차트. 차트 1번 -->
		${script1String}
		<div style="display: inline-block; width: 600px; height: 350px;"
			id="numAttem"></div>

		<!-- 아작스 통신 시 바꿔 끼울 코드(초기값은 버튼 1) -->
		<div id="convertChart" style="display: inline-block;">${scriptButton1}</div>

	</div>

	<br>

	<div>
		<!-- 시도 횟수 분포 차트. 차트 2번 -->
		${script2String}
		<div id="countNumAttem"
			style="display: inline-block; width: 600px; height: 300px;"></div>

		<!-- 결제 수단별 시도횟수 표 -->
		<div style="display: inline-block">
			<table border="1">
				<tr>
					<th>번호</th>
					<th style="width: 200px;">인증수단</th>
					<th style="width: 200px;">시도횟수</th>
				</tr>

				<c:forEach var="list" items="${numAttemWithRowNum}">
					<tr>
						<td><c:out value="${list.rowNum}" /></td>
						<td style="width: 200px;"><c:out value="${list.method}" /></td>
						<td style="width: 200px;"><c:out value="${list.numAttem}" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>