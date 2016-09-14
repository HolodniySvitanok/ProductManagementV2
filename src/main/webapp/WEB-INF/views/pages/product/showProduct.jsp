<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.holodniysvitanok.service.GlobalConfigProject"%>


<div id="tableShowProduct">
	<table>
		<tr>
			<td>ID</td>
			<td>Категория</td>
			<td>Производитель</td>
			<td>Главное описание</td>
			<td>Цена</td>
			<td>Количество</td>
			<td>Действие</td>
		</tr>
	
	
		<c:forEach var="product" items="${productList}">
			<tr>
				<td>${product.id}</td>
				<td>${product.category.name}</td>
				<td>${product.manufacturer.name}</td>
				<td>${product.mainDescription}</td>
				<td>${product.getPrice()} грн</td>
				<td>${product.count}</td>
				<td><a
					href="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.PRODUCT %>/<%= GlobalConfigProject.REVIEW_PRODUCT %>?id=${product.id}">просм.</a>
					<a
					href="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.PRODUCT %>/<%= GlobalConfigProject.SET_PRODUCT %>?id=${product.id}">ред.</a>
					<a
					href="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.PRODUCT %>/<%= GlobalConfigProject.DEL_PRODUCT %>?id=${product.id}">удл.</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>