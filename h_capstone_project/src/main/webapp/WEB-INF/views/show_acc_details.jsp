<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/h.css" /> 

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
   

</head>

<body>
   
	<div id="wrapper">
		<div id="header">
			<h2>User Account Details</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<!-- put new button: Add Customer -->



			<!--  add our html table here -->

			<table>
				<tr>
					<th>User ID</th>
					<th>Primary Account Number</th>
					<th>Savings Account Number</th>
					<th>Primary Account Balance</th>
					<th>Savings Account Balance</th>
				</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="tempProduct" items="${details}">

					<%-- 	<!-- construct an "update" link with customer id -->
					<c:url var="buy" value="/user/getid">
						<c:param name="id" value="${tempProduct.id}" />
					</c:url> --%>



					<tr>
						<td>${tempProduct.id}</td>
						<td>${tempProduct.primaryAccount_num}</td>
						<td>${tempProduct.savingsAccount_num}</td>
						<td>${tempProduct.primary_acc_bal}</td>
						<td>${tempProduct.savings_acc_bal}</td>


					</tr>

				</c:forEach>

			</table>
			<br />

		</div>

	</div>
	<br />
<br>
	<div>
		<form action="transferToSavingsAccount" method="post">
			<div align="center" class="center">
				<table>
					<tr>
						<td align="right">Please Enter Your ID</td>
						<td align="left"><input type="text" name="id" /></td>
					</tr>
					<tr>
						<td align="right">Please Enter Amount to transfer to Savings
							Account</td>
						<td align="left"><input type="text" name="amount" /></td>
					</tr>


					<tr>
						<td align="right"></td>
						<td align="left"><input type="submit"
							value="Transfer To Savings Account" /></td>
					</tr>
				</table>
		</form>

	</div>
	<br />
<br>
	<div>
		<form action="transferToPrimaryAccount" method="post">
			<div align="center" class="center">
				<table>
					<tr>
						<td align="right">Please Enter Your ID</td>
						<td align="left"><input type="text" name="id" /></td>
					</tr>
					<tr>
						<td align="right">Please Enter Amount to transfer to Primary
							Account</td>
						<td align="left"><input type="text" name="amount" /></td>
					</tr>


					<tr>
						<td align="right"></td>
						<td align="left"><input type="submit"
							value="Transfer To Primary Account" /></td>
					</tr>
				</table>
		</form>

	</div>
<br />
<br>
<div>
		<form action="toSomeoneAccount" method="post">
			<div align="center" class="center">
				<table>
					<tr>
						<td align="right">Please Enter Your ID</td>
						<td align="left"><input type="text" name="id" /></td>
					</tr>
					<tr>
						<td align="right">Please Enter Recipient ID </td>
						<td align="left"><input type="text" name="someone_id" /></td>
					</tr>
					<tr>
						<td align="right">Please Mention Account </td>
						<td align="left"><input type="text" name="acc_type" /></td>
					</tr>
					<tr>
						<td align="right">Please Enter Amount to transfer to SomeOne's
							Account</td>
						<td align="left"><input type="text" name="amount" /></td>
					</tr>


					<tr>
						<td align="right"></td>
						<td align="left"><input type="submit"
							value="Transfer To Someone's Account" /></td>
					</tr>
				</table>
		</form>

	</div>

</body>

</html>








