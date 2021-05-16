<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/h.css" />
</head>
<body>
<div id="wrapper">
		<div id="header">
			<h2>Users With Threat</h2>
		</div>
	</div>
	<div id="container">

		<div id="content">

			<!-- put new button: Add Customer -->



			<!--  add our html table here -->

			<table>
				<tr>
					<tr>
					<th>Id</th>
					<th>UserName</th>
					<th>Status</th>
					<th>Action</th>
					
				</tr>
				</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="block" items="${blocked}">

					<!-- construct an "update" link with customer id -->
					<c:url var="cb" value="/admin/blockUser">
						<c:param name="username" value="${block.username}" />
					</c:url>



					<tr>
						<td>${block.id}</td>
						<td>${block.username}</td>
						<td>${block.des}</td>
						
						<td>
							<!-- display the update link -->
							<button>
								<a href="${cb}">Block User</a>
							</button>

						</td>

					</tr>

				</c:forEach>

			</table>
			<br />

		</div>

	</div>
</body>