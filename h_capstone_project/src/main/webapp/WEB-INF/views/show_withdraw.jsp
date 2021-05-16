<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
    body {
	background-image: url("https://cdn.wallpapersafari.com/1/65/1A74vD.jpg");
	background-repeat: no-repeat;
	background-size: 100%;
margin-top: 100px;
} 
</style>
</head>
<body>
<div>
		<form action="withdraw" method="post">
			<div align="center" class="center">
				<table>
					<tr>
						<td align="right">Please Enter Your ID</td>
						<td align="left"><input type="text" name="id" /></td>
					</tr>
					<tr>
						<td align="right">Please Enter Amount to withdraw </td>
						<td align="left"><input type="text" name="amount" /></td>
					</tr>
					<tr>
						<td align="right">Plase Enter Account Type</td>
						<td align="left"><input type="text" name="type" /></td>
					</tr>
<br>
					<tr>
						<td align="right"></td>
						<td align="left"><input type="submit" class="btn btn-success"
							value="WithDraw" /></td>
					</tr>
				</table>
		</form>

	</div>
	</body>