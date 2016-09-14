<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.holodniysvitanok.service.GlobalConfigProject" %>
<span>Добавить категорию</span>
<form action="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.CATEGORY %>/<%= GlobalConfigProject.ADD_CATEGORY %>" method="POST" enctype="multipart/form-data">
	<table>
		<c:if test="${not empty message}">
			<tr>
				<td colspan="2"><h2>${message}</h2></td>
			</tr>
		</c:if>
		<tr>
			<td>Название категории</td>
			<td><input type="text" name="name" placeholder="введите строку" required></td>
		</tr>
		<tr>
			<td>Изображение<br>разм. 175x240</td>
			<td><input type="file" name="fileImage"></td>
		</tr>
		<tr>
			<td>Описание категории</td>
			<td><input type="text" name="description" placeholder="введите строку"></td>
		</tr>
		<tr>
			<td>Название поля #1</td>
			<td><input type="text" name="supportFieldName1" placeholder="введите строку"></td>
		</tr>
		<tr>
			<td>Название поля #2</td>
			<td><input type="text" name="supportFieldName2" placeholder="введите строку"></td>
		</tr>
		<tr>
			<td>Название поля #3</td>
			<td><input type="text" name="supportFieldName3" placeholder="введите строку"></td>
		</tr>
		<tr>
			<td>Название поля #4</td>
			<td><input type="text" name="supportFieldName4" placeholder="введите строку"></td>
		</tr>
		<tr>
			<td>Название поля #5</td>
			<td><input type="text" name="supportFieldName5" placeholder="введите строку"></td>
		</tr>
		<tr>
			<td>Название поля #6</td>
			<td><input type="text" name="supportFieldName6" placeholder="введите строку"></td>
		</tr>
		<tr>
			<td>Название поля #7</td>
			<td><input type="text" name="supportFieldName7" placeholder="введите строку"></td>
		</tr>
		<tr>
			<td>Название поля #8</td>
			<td><input type="text" name="supportFieldName8" placeholder="введите строку"></td>
		</tr>
		<tr>
			<td>Название поля #9</td>
			<td><input type="text" name="supportFieldName9" placeholder="введите строку"></td>
		</tr>
		<tr>
			<td>Название поля #10</td>
			<td><input type="text" name="supportFieldName10" placeholder="введите строку"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Сохранить"></td>
		</tr>
	</table>
</form>