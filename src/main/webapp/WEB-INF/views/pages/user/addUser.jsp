<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.holodniysvitanok.service.GlobalConfigProject"%>

<div id="addUserForm">
	<form action="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.USER %>/<%= GlobalConfigProject.ADD_USER %>" method="POST">
		<table>
		<c:if test="${not empty message}">
			<tr>
				<td colspan="2">${message}</td>
			</tr>
			</c:if>
			<tr>
				<td>Имя</td>
				<td><input type="text" placeholder="введите имя" name="name" required></td>
			</tr>
			<tr>
				<td>Логин</td>
				<td><input type="text" placeholder="введите логин" name="login" required></td>
			</tr>
			<tr>
				<td rowspan="2">Пароль</td>
				<td><input type="password" placeholder="введите пароль"
					name="password1" required></td>
			</tr>
			<tr>
				<td><input type="password" placeholder="введите пароль еще раз"
					name="password2" required></td>
			</tr>
			<tr>
				<td>Уровень доступа</td>
				<td><select name="accessLevel">
						<c:forEach var="al" begin="${accessLevel}" end="<%= GlobalConfigProject.MIN_ACCESS_LEVEL %>"  >
							<option value="${al}">${al}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Сохранить"></td>
			</tr>
		</table>
	</form>
</div>