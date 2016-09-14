<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.holodniysvitanok.service.GlobalConfigProject" %>

<form action="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.MANUFACTURER %>/<%= GlobalConfigProject.SET_MANUFACTURER %>"  enctype="multipart/form-data" method="POST">
	<table>
		<tr>
			<td colspan="2"><h2>${message}</h2></td>
		</tr>
		<tr>
			<td>ID</td>
			<td><input type="text" name="id" readonly value="${manufacturer.id}" > </td>
		</tr>
		<tr>
			<td>Название</td>
			<td><input type="text" name="name" placeholder="введите строку" value="${manufacturer.name}"> </td>
		</tr>
		<tr>
			<td>Страна</td>
			<td><input type="text" name="country" placeholder="введите строку" value="${manufacturer.country}"> </td>
		</tr>
		<tr>
			<td>Описание</td>
			<td><input type="text" name="description" placeholder="введите строку" value="${manufacturer.description}"> </td>
		</tr>
		<tr>
			<td>Изображение<br>разм. 175x240</td>
			<td><input type="file" name="fileImage" > </td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Сохранить"> </td>
		</tr>
	</table>
</form>