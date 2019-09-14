<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Ninja</title>
</head>
<body>
	<h1>New Ninja</h1>
	<form:form method="post" modelAttribute="ninja" action="/ninjas/create">
	<table>
		<tr>
			<td>
				<form:select path="dojo">
					<c:forEach items="${dojos}" var="dojo">
						<form:option value="${dojo.getId()}">${dojo.getName()}</form:option>
					</c:forEach>
				</form:select>	
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="firstName">First Name</form:label>
				<form:errors path="firstName"/>
				<form:input path="firstName"/>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="lastName">Last Name</form:label>
				<form:errors path="lastName"/>
				<form:input path="lastName"/>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="age">Age</form:label>
				<form:errors path="age"/>
				<form:input path="age"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="create"/>
			</td>
		</tr>
	</table>
	</form:form>
</body>
</html>