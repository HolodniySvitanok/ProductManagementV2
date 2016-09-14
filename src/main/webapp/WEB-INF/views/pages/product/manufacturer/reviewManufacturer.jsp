<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.holodniysvitanok.service.GlobalConfigProject" %>


<table>
	<tr>
		<td>ID</td>
		<td>${manufacturer.id}</td>
	</tr>
	<tr>
		<td>Название</td>
		<td>${manufacturer.name}</td>
	</tr>
	<tr>
		<td>Изображение</td>
		<td><img src="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.IMAGE_BOX_URL %>/${manufacturer.urlImage}"></td>
	</tr>
	<tr>
		<td>Описание</td>
		<td>${manufacturer.description}</td>
	</tr>
	<tr>
		<td>Страна</td>
		<td>${manufacturer.country}</td>
	</tr>
	<tr>
		<td colspan="2">
			<a href="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.MANUFACTURER %>/<%= GlobalConfigProject.SET_MANUFACTURER %>?id=${manufacturer.id}">ред.</a>
			<a href="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.MANUFACTURER %>/<%= GlobalConfigProject.DEL_MANUFACTURER %>?id=${manufacturer.id}">удл.</a>
		</td>
	</tr>
</table>