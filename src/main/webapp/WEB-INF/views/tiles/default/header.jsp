<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.holodniysvitanok.service.GlobalConfigProject" %>

	<div id="subHeader">
		<span class="spanHeader"><a href="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.ORDER %>">Заказы</a></span>
		<span class="spanHeader"><a href="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.PRODUCT %>">Товары</a></span> 
		<span class="spanHeader"><a href="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.USER %>">Пользователи</a></span>
		
		<span id="headerUser" class="spanHeader">${user.name}</span>
		<span class="spanHeader"><a href="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.USER %>/<%= GlobalConfigProject.EXIT_USER %>">Выйти</a></span>
	</div>
