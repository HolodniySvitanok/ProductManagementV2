<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.holodniysvitanok.service.GlobalConfigProject"%>

<form action="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.USER %>/<%= GlobalConfigProject.DEL_USER %>" method="POST">
	<span>${user.id} ${user.name}</span><br>
	<input type="hidden" name="id"  value="${user.id}">
	<input type="submit" value="Удалить">
</form>