<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.holodniysvitanok.service.GlobalConfigProject"%>

<form
	action="${pageContext.servletContext.contextPath}/<%= GlobalConfigProject.PRODUCT %>/<%= GlobalConfigProject.SET_PRODUCT %>"
	enctype="multipart/form-data" method="POST">
	<table>
		<tr>
			<td colspan="2"><h2>${message}</h2></td>
		</tr>
<%-- 		<tr>
			<td colspan="2"><input type="hidden" name="category" value="${category.id}"></td>
		</tr> --%>
		<tr>
			<td>ID</td>
			<td><input type="text" name="id" readonly value="${product.id}"></td>
		</tr>
		<tr>
			<td>Базовая цена</td>
			<td><input type="text" name="basePrice"	placeholder="введите число" value="${product.basePrice}"></td>
		</tr>
		<tr>
			<td>Коэффициент цены</td>
			<td><input type="text" name="kPrice" placeholder="введите число"  value="${product.kPrice}"></td>
		</tr>
		<tr>
			<td>Количество</td>
			<td><input type="text" name="count" placeholder="введите число"  value="${product.count}"></td>
		</tr>
		<tr>
			<td>Главное описание</td>
			<td><input type="text" name="mainDescription"	placeholder="введите строку" value="${product.mainDescription}"></td>
		</tr>
		<tr>
			<td>Производитель</td>
			<td><select name="manufacturer">
					<c:forEach var="manufacturer" items="${manufacturerList}">
						<option value="${manufacturer.id}"	<c:if test="${product.manufacturer.id eq manufacturer.id}">selected</c:if>>
							${manufacturer.name}
						</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td>Отображать (показывать на ветрине)</td>
			<td><input type="checkbox" name="show" value="true" <c:if test="${product.show}">checked</c:if>   ></td>
		</tr>
		<tr>
			<td>Акция</td>
			<td><input type="checkbox" name="stock" value="true" <c:if test="${product.stock}">checked</c:if>   ></td>
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
		<c:if test="${not empty product.category.supportFieldName1}">
			<tr>
				<td>${product.category.supportFieldName1}</td>
				<td><input type="text" name="field1" value="${product.supportField1}"></td>
			</tr>
		</c:if>
		<c:if test="${not empty product.category.supportFieldName2}">
			<tr>
				<td>${product.category.supportFieldName2}</td>
				<td><input type="text" name="field2" value="${product.supportField2}"></td>
			</tr>
		</c:if>
		<c:if test="${not empty product.category.supportFieldName3}">
			<tr>
				<td>${product.category.supportFieldName3}</td>
				<td><input type="text" name="field3" value="${product.supportField3}"></td>
			</tr>
		</c:if>
		<c:if test="${not empty product.category.supportFieldName4}">
			<tr>
				<td>${product.category.supportFieldName4}</td>
				<td><input type="text" name="field4" value="${product.supportField4}"></td>
			</tr>
		</c:if>
		<c:if test="${not empty product.category.supportFieldName5}">
			<tr>
				<td>${product.category.supportFieldName5}</td>
				<td><input type="text" name="field5" value="${product.supportField5}"></td>
			</tr>
		</c:if>
		<c:if test="${not empty product.category.supportFieldName6}">
			<tr>
				<td>${product.category.supportFieldName6}</td>
				<td><input type="text" name="field6" value="${product.supportField6}"></td>
			</tr>
		</c:if>
		<c:if test="${not empty product.category.supportFieldName7}">
			<tr>
				<td>${product.category.supportFieldName7}</td>
				<td><input type="text" name="field7" value="${product.supportField7}"></td>
			</tr>
		</c:if>
		<c:if test="${not empty product.category.supportFieldName8}">
			<tr>
				<td>${product.category.supportFieldName8}</td>
				<td><input type="text" name="field8" value="${product.supportField8}"></td>
			</tr>
		</c:if>
		<c:if test="${not empty product.category.supportFieldName9}">
			<tr>
				<td>${product.category.supportFieldName9}</td>
				<td><input type="text" name="field9" value="${product.supportField9}"></td>
			</tr>
		</c:if>
		<c:if test="${not empty product.category.supportFieldName10}">
			<tr>
				<td>${product.category.supportFieldName10}</td>
				<td><input type="text" name="field10" value="${product.supportField10}"></td>
			</tr>
		</c:if>
		<tr>
			<td colspan="2"><input type="submit" value="Сохранить">
			</td>
		</tr>
	</table>
</form>