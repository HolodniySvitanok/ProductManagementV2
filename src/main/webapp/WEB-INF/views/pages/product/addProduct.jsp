<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.holodniysvitanok.service.GlobalConfigProject"%>




<c:if test="${showCategory}">
	<c:if test="${empty categoryList}">
		<span>Добавьте категорию</span>
	</c:if>
	<c:if test="${not empty categoryList}">
		<form
			action="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.PRODUCT %>/<%= GlobalConfigProject.ADD_PRODUCT %>"
			method="GET">
			Выбери категорию <select name="category">
				<c:forEach var="category" items="${categoryList}">
					<option value="${category.id}">${category.name}</option>
				</c:forEach>
			</select><input type="submit" value="выбрать">
		</form>
	</c:if>
</c:if>


<c:if test="${not showCategory}">
	<c:if test="${empty manufacturerList}">Добавьте производителя</c:if>


	<c:if test="${not empty manufacturerList}">
		<span>Добавить товар</span>
		<form
			action="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.PRODUCT %>/<%= GlobalConfigProject.ADD_PRODUCT %>"
			method="POST" enctype="multipart/form-data">
			<input type="hidden" name="category" value="${category.id}">
			<table>
				<tr>
					<td>Базовая цена</td>
					<td><input type="text" name="basePrice"
						placeholder="введите число" required></td>
				</tr>
				<tr>
					<td>коэффициент цены</td>
					<td><input type="text" name="kPrice"
						placeholder="введите число" required></td>
				</tr>
				<tr>
					<td>Количество</td>
					<td><input type="text" name="count"
						placeholder="введите число" required></td>
				</tr>
				<tr>
					<td>Главное описание</td>
					<td><input type="text" name="mainDescription"
						placeholder="введите строку"></td>
				</tr>
				<tr>
					<td>Производитель</td>
					<td><select name="manufacturer">
							<c:forEach var="manufacturer" items="${manufacturerList}">
								<option value="${manufacturer.id}">${manufacturer.name}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>Отображать (показывать на ветрине)</td>
					<td><input type="checkbox" name="show" value="true"></td>
				</tr>
				<tr>
					<td>Акция</td>
					<td><input type="checkbox" name="stock" value="true"></td>
				</tr>
				<tr>
					<td>Изображение товара 1</td>
					<td><input type="file" name="fileImage1"></td>
				</tr>
				<tr>
					<td>Изображение товара 2</td>
					<td><input type="file" name="fileImage2"></td>
				</tr>
				<tr>
					<td>Изображение товара 3</td>
					<td><input type="file" name="fileImage3"></td>
				</tr>
				<c:if test="${not empty category.supportFieldName1}">
					<tr>
						<td>${category.supportFieldName1}</td>
						<td><input type="text" name="field1"></td>
					</tr>
				</c:if>
				<c:if test="${not empty category.supportFieldName2}">
					<tr>
						<td>${category.supportFieldName2}</td>
						<td><input type="text" name="field2"></td>
					</tr>
				</c:if>
				<c:if test="${not empty category.supportFieldName3}">
					<tr>
						<td>${category.supportFieldName3}</td>
						<td><input type="text" name="field3"></td>
					</tr>
				</c:if>
				<c:if test="${not empty category.supportFieldName4}">
					<tr>
						<td>${category.supportFieldName4}</td>
						<td><input type="text" name="field4"></td>
					</tr>
				</c:if>
				<c:if test="${not empty category.supportFieldName5}">
					<tr>
						<td>${category.supportFieldName5}</td>
						<td><input type="text" name="field5"></td>
					</tr>
				</c:if>
				<c:if test="${not empty category.supportFieldName6}">
					<tr>
						<td>${category.supportFieldName6}</td>
						<td><input type="text" name="field6"></td>
					</tr>
				</c:if>
				<c:if test="${not empty category.supportFieldName7}">
					<tr>
						<td>${category.supportFieldName7}</td>
						<td><input type="text" name="field7"></td>
					</tr>
				</c:if>
				<c:if test="${not empty category.supportFieldName8}">
					<tr>
						<td>${category.supportFieldName8}</td>
						<td><input type="text" name="field8"></td>
					</tr>
				</c:if>
				<c:if test="${not empty category.supportFieldName9}">
					<tr>
						<td>${category.supportFieldName9}</td>
						<td><input type="text" name="field9"></td>
					</tr>
				</c:if>
				<c:if test="${not empty category.supportFieldName10}">
					<tr>
						<td>${category.supportFieldName10}</td>
						<td><input type="text" name="field10"></td>
					</tr>
				</c:if>
				<tr>
					<td colspan="2"><input type="submit" value="Сохранить"></td>
				</tr>
			</table>
		</form>
	</c:if>
</c:if>