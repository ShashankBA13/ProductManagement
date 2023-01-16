<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Product Management</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
	<h1>Product Management</h1>
	<div id="product-form">
		<form action="<c:url value='/products'/>" method="post">
			<label>Product ID:</label>
			<input type="text" id="product-id" disabled> <br>
			<label>Product Name:</label>
			<input type="text" id="product-name" name="name"> <br>
			<label>Product Type:</label>
			<input type="text" id="product-type" name="productType"><br>
			<label>Product Category:</label>
			<input type="text" id="product-category" name="category"> <br>
			<label>Product Price:</label>
			<input type="text" id="product-price" name="basePrice"> <br>
			<input type="submit" value="Add Product" id="add-button">
			<input type="submit" value="Update Product" id="update-button" style="display: none;">
		</form>
		<form action="<c:url value='/products'/>" method="post" id="delete-form" style="display: none;">
			<input type="hidden" id="delete-id" name="id">
			<input type="submit" value="Delete Product" id="delete-button">
		</form>
	</div>
	<table id="product-table">
		<tr>
			<th>Product ID</th>
			<th>Product Name</th>
			<th>Product Type</th>
			<th>Product Category</th>
			<th>Product Price</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="product" items="${products}">
			<tr>
				<td>${product.productId}</td>
				<td>${product.name}</td>
				<td>${product.productType}</td>
				<td>${product.category}</td>
				<td>${product.basePrice}</td>
				<td>
					<a href="#" onclick="editProduct(${product.productId},'${product.name}',
						'${product.productType}',
						'${product.category}',
						'${product.basePrice}')">Edit</a>
					<a href="#" onclick="confirmDelete(${product.productId})">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<script>
		function editProduct(id, name, type, category, price) {
			document.getElementById("product-id").value = id;
			document.getElementById("product-name").value = name;
			document.getElementById("product-type").value = type;
			document.getElementById("product-category").value = category;
			document.getElementById("product-price").value = price;
			document.getElementById("add-button").style.display = "none";
			document.getElementById("update-button").style.display = "inline-block";
		}

		function confirmDelete(id) {
			if (confirm("Are you sure you want to delete this product?")) {
				document.getElementById("delete-id").value = id;
				document.getElementById("delete-form").submit();
			}
		}
	</script>
</body>
</html>


