<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>dash board</title>

<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<h2>Hello World</h2>
	<button type="button" onclick="/">버튼1</button>
	<button type="button" onclick="/">버튼2</button>
	<button type="button" onclick="/'">버튼3</button>
	
	
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	${htmlString}
   
	<div id="numAttem" style="width:900px; height:	350px;"></div>
	
</body>
</html>