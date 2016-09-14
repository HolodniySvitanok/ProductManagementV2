<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.holodniysvitanok.service.GlobalConfigProject" %>

<%-- <form action="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.PRODUCT %>/<%= GlobalConfigProject.ACTION_DEL_PRODUCT %>" method="get">
	<label for="id">Удалить по ID : </label>
	<input type="text" name="id" value="${id}" id="id"><input type="submit" value="Удалить">
</form> --%>




<form action="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.PRODUCT %>/<%= GlobalConfigProject.ACTION_DEL_PRODUCT %>" method="get">
	<span>${product.id} ${product.category.name} ${product.manufacturer.name} ${product.mainDescription}</span><br>
	<input type="hidden" name="id" value="${product.id}" ><input type="submit" value="Удалить">
</form>

