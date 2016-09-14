<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.holodniysvitanok.service.GlobalConfigProject"%>



<table>
	<tr>
		<td>ID</td>
		<td>Имя</td>
		<td>Логин</td>
		<td>Уровень доступа</td>
		<td>Действие</td>
	</tr>
	<c:forEach var="user" items="${userList}">
		<tr>
			<td>${user.id}</td>
			<td>${user.name}</td>
			<td>${user.login}</td>
			<td>${user.accessLevel}</td>
			<td>
				<a href="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.USER %>/<%= GlobalConfigProject.REVIEW_USER %>?id=${user.id}">просм.</a>
				<a href="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.USER %>/<%= GlobalConfigProject.SET_USER %>?id=${user.id}">ред.</a>
				<a href="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.USER %>/<%= GlobalConfigProject.DEL_USER %>?id=${user.id}">удл.</a>
			</td>
		</tr>
	</c:forEach>
</table>