<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.holodniysvitanok.service.GlobalConfigProject" %>

<form action="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.MANUFACTURER %>/<%= GlobalConfigProject.REVIEW_MANUFACTURER %>" method="get">
	<label for="id">Найти производителей по ID : </label>
	<input type="text" name="id" id="id" required><input type="submit" value="Найти">
</form>