<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.holodniysvitanok.service.GlobalConfigProject"%>

<h3>Все категории</h3>
<c:forEach var="category" items="${categoryList}">
	<div class="mainDivShow">

			<div class="imgShow">
				<img src="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.IMAGE_BOX_URL %>/${category.urlImage}" height="240" width="175">
			</div>
			<span>${category.name} (${category.id})</span>
			<div>
				<a href="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.CATEGORY %>/<%= GlobalConfigProject.REVIEW_CATEGORY %>?id=${category.id}">просм.</a>
			 	<a href="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.CATEGORY %>/<%= GlobalConfigProject.SET_CATEGORY %>?id=${category.id}">ред.</a>
				<a href="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.CATEGORY %>/<%= GlobalConfigProject.DEL_CATEGORY %>?id=${category.id}">удл.</a>
			</div>

	</div>
</c:forEach>