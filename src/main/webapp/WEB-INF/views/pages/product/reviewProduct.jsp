<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.holodniysvitanok.service.GlobalConfigProject"%>

<table>
	<tr>
		<td>Изображение</td>
		<td><c:if test="${not empty product.urlImage1}">
				<img
					src="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.IMAGE_BOX_URL %>/${product.urlImage1}">
			</c:if>
			<c:if test="${not empty product.urlImage2}">
				<img
					src="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.IMAGE_BOX_URL %>/${product.urlImage2}">
			</c:if>
			<c:if test="${not empty product.urlImage3}">
				<img
					src="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.IMAGE_BOX_URL %>/${product.urlImage3}">
			</c:if></td>
	</tr>
	<tr>
		<td>ID</td>
		<td>${product.id}</td>
	</tr>
	<tr>
		<td>Базовая цена</td>
		<td>${product.basePrice}</td>
	</tr>
	<tr>
		<td>К цены</td>
		<td>${product.kPrice}</td>
	</tr>
	<tr>
		<td>Цена (расчетная)</td>
		<td>${product.getPrice()}</td>
	</tr>
	<tr>
		<td>Количество</td>
		<td>${product.count}</td>
	</tr>
	<tr>
		<td>Рейтинг</td>
		<td>${product.rate}</td>
	</tr>
	<tr>
		<td>Категория</td>
		<td>${product.category.name}</td>
	</tr>
	<tr>
		<td>Производитель</td>
		<td>${product.manufacturer.name}</td>
	</tr>
	<tr>
		<td>Главное описание</td>
		<td>${product.mainDescription}</td>
	</tr>
	<tr>
		<td>Показывать</td>
		<td>${product.show}</td>
	</tr>
	<tr>
		<td>Акция</td>
		<td>${product.stock}</td>
	</tr>


	<tr>
		<td>Показывать</td>
		<td>${product.show}</td>
	</tr>
	<c:if test="${not empty product.category.supportFieldName1}">
		<tr>
			<td>${product.category.supportFieldName1}</td>
			<td>${product.supportField1}</td>
		</tr>
	</c:if>
	<c:if test="${not empty product.category.supportFieldName2}">
		<tr>
			<td>${product.category.supportFieldName2}</td>
			<td>${product.supportField2}</td>
		</tr>
	</c:if>
	<c:if test="${not empty product.category.supportFieldName3}">
		<tr>
			<td>${product.category.supportFieldName3}</td>
			<td>${product.supportField3}</td>
		</tr>
	</c:if>
	<c:if test="${not empty product.category.supportFieldName4}">
		<tr>
			<td>${product.category.supportFieldName4}</td>
			<td>${product.supportField4}</td>
		</tr>
	</c:if>
	<c:if test="${not empty product.category.supportFieldName5}">
		<tr>
			<td>${product.category.supportFieldName5}</td>
			<td>${product.supportField5}</td>
		</tr>
	</c:if>
	<c:if test="${not empty product.category.supportFieldName6}">
		<tr>
			<td>${product.category.supportFieldName6}</td>
			<td>${product.supportField6}</td>
		</tr>
	</c:if>
	<c:if test="${not empty product.category.supportFieldName7}">
		<tr>
			<td>${product.category.supportFieldName7}</td>
			<td>${product.supportField7}</td>
		</tr>
	</c:if>
	<c:if test="${not empty product.category.supportFieldName8}">
		<tr>
			<td>${product.category.supportFieldName8}</td>
			<td>${product.supportField8}</td>
		</tr>
	</c:if>
	<c:if test="${not empty product.category.supportFieldName9}">
		<tr>
			<td>${product.category.supportFieldName9}</td>
			<td>${product.supportField9}</td>
		</tr>
	</c:if>
	<c:if test="${not empty product.category.supportFieldName10}">
		<tr>
			<td>${product.category.supportFieldName10}</td>
			<td>${product.supportField10}</td>
		</tr>
	</c:if>
	<tr>
		<td colspan="2"><a
			href="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.PRODUCT %>/<%= GlobalConfigProject.SET_PRODUCT %>?id=${product.id}">ред.</a>
			<a
			href="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.PRODUCT %>/<%= GlobalConfigProject.DEL_PRODUCT %>?id=${product.id}">удл.</a>
		</td>
	</tr>
</table>