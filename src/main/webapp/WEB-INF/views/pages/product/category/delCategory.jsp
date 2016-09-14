<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.holodniysvitanok.service.GlobalConfigProject" %>

<%-- <form action="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.CATEGORY %>/<%= GlobalConfigProject.ACTION_DEL_CATEGORY %>" method="get">
	<label for="id">Удалить категорию по ID :</label> 
	<input type="text" name="id" value="${id}" id="id">
	<input type="submit" value="Удалить">
</form> --%>

<div class="delForm">
<form action="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.CATEGORY %>/<%= GlobalConfigProject.ACTION_DEL_CATEGORY %>" method="get">
	<div><img src="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.IMAGE_BOX_URL %>/${category.urlImage}" height="240" width="175"></div>
	<span>${category.id} ${category.name}</span><br>
	<input type="hidden" name="id" value="${category.id}" >
	<input type="submit" value="Удалить">
</form>
</div>