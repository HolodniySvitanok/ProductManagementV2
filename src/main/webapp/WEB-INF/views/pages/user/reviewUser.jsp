<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.holodniysvitanok.service.GlobalConfigProject"%>

<table>
	<tr>
		<td><b>ID</b></td>
		<td><b>${user.id}</b></td>
	</tr>
	<tr>
		<td><b>Имя</b></td>
		<td>${user.name}</td>
	</tr>
	<tr>
		<td><b>Логин</b></td>
		<td>${user.login}</td>
	</tr>
	<tr>
		<td><b>Уровень<br>доступа</b></td>
		<td>${user.accessLevel}</td>
	</tr>
	<tr>
		<td><b>Действие</b></td>
		<td>
			<a href="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.USER %>/<%= GlobalConfigProject.SET_USER %>?id=${user.id}">ред.</a>
			<a href="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.USER %>/<%= GlobalConfigProject.DEL_USER %>?id=${user.id}">удл.</a>
		</td>
	</tr>
	
</table>