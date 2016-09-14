<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.holodniysvitanok.service.GlobalConfigProject" %>
<table>
	<tr>
		<td>ID</td>
		<td>${category.id}</td>
	</tr>
	<tr>
		<td>Название</td>
		<td>${category.name}</td>
	</tr>
	<tr>
		<td>Изображение</td>
		<td><img src="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.IMAGE_BOX_URL %>/${category.urlImage}"></td>
	</tr>
	<tr>
		<td>Описание</td>
		<td>${category.description}</td>
	</tr>
	<tr>
		<td>Название поле #1</td>
		<td>${category.supportFieldName1}</td>
	</tr>
	<tr>
		<td>Название поле #2</td>
		<td>${category.supportFieldName2}</td>
	</tr>
	<tr>
		<td>Название поле #3</td>
		<td>${category.supportFieldName3}</td>
	</tr>
	<tr>
		<td>Название поле #4</td>
		<td>${category.supportFieldName4}</td>
	</tr>
	<tr>
		<td>Название поле #5</td>
		<td>${category.supportFieldName5}</td>
	</tr>
	<tr>
		<td>Название поле #6</td>
		<td>${category.supportFieldName6}</td>
	</tr>
	<tr>
		<td>Название поле #7</td>
		<td>${category.supportFieldName7}</td>
	</tr>
	<tr>
		<td>Название поле #8</td>
		<td>${category.supportFieldName8}</td>
	</tr>
	<tr>
		<td>Название поле #9</td>
		<td>${category.supportFieldName9}</td>
	</tr>
	<tr>
		<td>Название поле #10</td>
		<td>${category.supportFieldName10}</td>
	</tr>
	<tr>
		<td colspan="2">
			<a href="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.CATEGORY %>/<%= GlobalConfigProject.SET_CATEGORY %>?id=${category.id}">ред.</a>
			<a href="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.CATEGORY %>/<%= GlobalConfigProject.DEL_CATEGORY %>?id=${category.id}">удл.</a>
		</td>
	</tr>
</table>