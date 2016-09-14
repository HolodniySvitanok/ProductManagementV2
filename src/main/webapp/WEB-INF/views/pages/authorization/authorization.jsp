<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.holodniysvitanok.service.GlobalConfigProject"%>

<div id="message">${message}</div>
<div id="auth">
	<form action="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.AUTHORIZATION %>" method="POST">
		
		<table>
			<tr>
				<td><label for="l1">Логин :</label></td>
				<td><input type="text" name="login" id="l1" placeholder="введите логин" required></td>
			</tr>
			<tr>
				<td><label for="p1">Пароль :</label></td>
				<td><input type="password" name="password" id="p1" placeholder="введите пароль" required></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="Войти" ></td>
			</tr>
		</table>
	</form>
</div>