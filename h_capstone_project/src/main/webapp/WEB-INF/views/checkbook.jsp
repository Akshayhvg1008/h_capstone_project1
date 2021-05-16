<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/h.css" />
</head>
<body>
<div id="wrapper">
		<div id="header">
			<h2>CheckBook Request List</h2>
		</div>
	</div>
	<div id="container">

		<div id="content">

			<!-- put new button: Add Customer -->



			<!--  add our html table here -->

			<table>
				<tr>
					<th>User ID</th>
					<th>Description</th>
					<th>Status</th>
					<th>Action</th>

				</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="checkbookPendingList" items="${checkbook}">

					<!-- construct an "update" link with customer id -->
					<c:url var="cb" value="/admin/confirmCheckBook">
						<c:param name="user_id" value="${checkbookPendingList.user_id}" />
						<c:param name="type" value="${checkbookPendingList.type}" />
					</c:url>



					<tr>
						<td>${checkbookPendingList.user_id}</td>
						<td>${checkbookPendingList.des}</td>
						<td>${checkbookPendingList.status}</td>
						
						<td>
							<!-- display the update link -->
							<button>
								<a href="${cb}">Grant CheckBook</a>
							</button>

						</td>

					</tr>

				</c:forEach>

			</table>
			<br />

		</div>

	</div>
	<br />

</body>