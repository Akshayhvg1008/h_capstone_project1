<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Product</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Product</h2>
		</div>
	</div>

	
		<h3>Add Product</h3>
	
		<form:form action="saveProduct" modelAttribute="product" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Name:</label></td>
						<td><form:input path="name" /></td>
					</tr>
				
					<tr>
						<td><label>Price:</label></td>
						<td><form:input path="price" /></td>
					</tr>

					<tr>
						<td><label>Company:</label></td>
						<td><form:input path="company" /></td>
					</tr>

                    <tr>
						<td><label>Category:</label></td>
						<td><form:input path="category" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		
		<p>
			<a href="${pageContext.request.contextPath}/products/list">Back to List</a>
		</p>
	
	

</body>

</html>









