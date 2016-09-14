<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.holodniysvitanok.service.GlobalConfigProject"%>


<form action="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.USER %>/<%= GlobalConfigProject.SET_USER %>" method="POST">
	<input type="hidden" name="id"
				value="${user.id}">
	<table>
		<c:if test="${not empty message}">
			<tr>
				<td colspan="2">${message}</td>
			</tr>
		</c:if>
		<tr>
			<td>Имя</td>
			<td><input type="text" name="name" value="${user.name}"></td>
		</tr>
		<tr>
			<td>Логин</td>
			<td><input type="text" name="login" value="${user.login}"></td>
		</tr>
		<tr>
			<td rowspan="2">Пароль</td>
			<td><input type="password" name="password1"
				 placeholder="введите пароль"></td>
		</tr>
		<tr>
			<td><input type="password" name="password2"
				 placeholder="введите пароль еще раз"></td>
		</tr>
		<tr>
			<td>Уровень доступа
			</td>
			<td>
				<select name="accessLevel">
						<c:forEach var="al" begin="${accessLevel}"
							end="<%= GlobalConfigProject.MIN_ACCESS_LEVEL %>">
							<option value="${al}" 	<c:if test="${al eq user.accessLevel}">selected</c:if>>${al}</option>
						</c:forEach>
				</select>
			</td>
		</tr>
		
		<tr>
			<td colspan="2"><input type="submit" value="Сохранить"></td>
		</tr>
	</table>
</form>