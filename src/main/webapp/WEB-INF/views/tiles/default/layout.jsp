<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/
		<tiles:insertAttribute name="css" ignore="true" />	" />
<meta charset="utf-8">
</head>
<body>
	<div id="page">
			<div id="header"><tiles:insertAttribute name="header" /></div>
			<div id="left"><tiles:insertAttribute name="left" /></div>
			<div id="main"><tiles:insertAttribute name="main" /></div>
			<div id="footer"><tiles:insertAttribute name="footer" /></div>
	</div>
</body>
</html>

