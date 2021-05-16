<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- reference our style sheet -->

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/h.css" />


	
	<div id="wrapper">
		<div id="header">
			<h2>Transaction List</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<!-- put new button: Add Customer -->



			<!--  add our html table here -->

			<table>
				<tr>
					<th>Transaction ID</th>
					<th>User ID</th>
					<th>From</th>
					<th>To</th>
					<th>Amount</th>
					<th>Status</th>
					<th>Action</th>
				</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="pendingList" items="${details}">

					<!-- construct an "update" link with customer id -->
					<c:url var="buy" value="/admin/confirmPendingTransaction">
						<c:param name="user_id" value="${pendingList.user_id}" />
						<c:param name="amount" value="${pendingList.amount}" />
						<c:param name="type" value="${pendingList.type}" />
						<c:param name="someone_id" value="${pendingList.some_id}" />
						<c:param name="trans_id" value="${pendingList.trans_id}" />
					</c:url>



					<tr>
						<td>${pendingList.trans_id}</td>
						<td>${pendingList.user_id}</td>
						<td>${pendingList.from}</td>
						<td>${pendingList.to}</td>
						<td>${pendingList.amount}</td>
						<td>${pendingList.status}</td>
						<td>
							<!-- display the update link -->
							<button>
								<a href="${buy}">Authorize Transaction</a>
							</button>

						</td>

					</tr>

				</c:forEach>

			</table>
			<br />

		</div>

	</div>
	<br />


	


</html>







