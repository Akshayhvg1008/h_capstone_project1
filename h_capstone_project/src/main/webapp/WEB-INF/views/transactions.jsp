<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/h.css" />
</head>
<body>
<div id="wrapper">
		<div id="header">
			<h2>Transactions Details</h2>
		</div>
	</div>
	<div id="container">

		<div id="content">

			<!-- put new button: Add Customer -->



			<!--  add our html table here -->

			<table>
				<tr>
					<tr>
					<th>Transaction ID</th>
					<th>User ID</th>
					<th>From</th>
					<th>To</th>
					<th>Amount</th>
					<th>Status</th>
				</tr>
				</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="transDetails" items="${trans}">

					<!-- construct an "update" link with customer id -->
					<%-- <c:url var="cb" value="/admin/confirmCheckBook">
						<c:param name="user_id" value="${checkbookPendingList.user_id}" />
						<c:param name="type" value="${checkbookPendingList.type}" />
					</c:url> --%>



					<tr>
						<td>${transDetails.trans_id}</td>
						<td>${transDetails.user_id}</td>
						<td>${transDetails.from}</td>
						<td>${transDetails.to}</td>
						<td>${transDetails.amount}</td>
						<td>${transDetails.status}</td>
						

					</tr>

				</c:forEach>

			</table>
			<br />

		</div>

	</div>
</body>