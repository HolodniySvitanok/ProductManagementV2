<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.holodniysvitanok.service.GlobalConfigProject" %>
<span>Добавить производителя</span>
<form action="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.MANUFACTURER %>/<%= GlobalConfigProject.ADD_MANUFACTURER %>"  enctype="multipart/form-data" method="POST">
	<table>
		<c:if test="${not empty message}">
			<tr>
				<td colspan="2"><h2>${message}</h2></td>
			</tr>
		</c:if>
		<tr>
			<td>Название</td>
			<td><input type="text" name="name" placeholder="введите строку" required> </td>
		</tr>
		<tr>
			<td>Страна</td>
			<td><input type="text" name="country" placeholder="введите строку"> </td>
		</tr>
		<tr>
			<td>Описание</td>
			<td><input type="text" name="description" placeholder="введите строку"> </td>
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