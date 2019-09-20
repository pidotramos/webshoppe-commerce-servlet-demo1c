<%@ page language="java" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Product Catalog</title>
</head>
<body>
	<c:if test="${!empty catalog.toys}">
		<h2>Toy Catalog</h2>
		<table>
			<tr>
				<td>Id</td>
				<td>Name</td>
				<td>Description</td>
				<td>Price</td>
			</tr>
			<c:forEach items="${catalog.toys}" var="toy">
				<tr>
					<td><c:out value="${toy.id}" /></td>
					<td><c:out value="${toy.name}" /></td>
					<td><c:out value="${toy.description}" /></td>
					<td><c:out value="${toy.price}" /></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${!empty catalog.books}">
		<h2>Book Catalog</h2>
		<table>
			<tr>
				<td>Id</td>
				<td>Name</td>
				<td>Description</td>
				<td>Author</td>
				<td>Price</td>
			</tr>
			<c:forEach items="${catalog.books}" var="book">
				<tr>
					<td><c:out value="${book.id}" /></td>
					<td><c:out value="${book.name}" /></td>
					<td><c:out value="${book.description}" /></td>
					<td><c:out value="${book.author}" /></td>
					<td><c:out value="${book.price}" /></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${!empty catalog.flowers}">
		<h2>Flower Catalog</h2>
		<table>
			<tr>
				<td>Id</td>
				<td>Name</td>
				<td>Description</td>
				<td>Price</td>
			</tr>
			<c:forEach items="${catalog.flowers}" var="flower">
				<tr>
					<td><c:out value="${flower.id}" /></td>
					<td><c:out value="${flower.name}" /></td>
					<td><c:out value="${flower.description}" /></td>
					<td><c:out value="${flower.price}" /></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>