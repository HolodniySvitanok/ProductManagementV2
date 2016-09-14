<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.holodniysvitanok.service.GlobalConfigProject"%>

<h3>Все производители</h3>
<c:forEach var="manufacturer" items="${manufacturerList}">
	<div class="mainDivShow">
			<div class="imgShow">
				<img
					src="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.IMAGE_BOX_URL %>/${manufacturer.urlImage}" height="240" width="175">
			</div>
			<span>${manufacturer.name} (${manufacturer.id})</span>
			<div>
				<a	href="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.MANUFACTURER %>/<%= GlobalConfigProject.REVIEW_MANUFACTURER %>?id=${manufacturer.id}">просм.</a>
				<a	href="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.MANUFACTURER %>/<%= GlobalConfigProject.SET_MANUFACTURER %>?id=${manufacturer.id}">ред.</a>
				<a	href="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.MANUFACTURER %>/<%= GlobalConfigProject.DEL_MANUFACTURER %>?id=${manufacturer.id}">удл.</a>
			</div>
	</div>
</c:forEach>