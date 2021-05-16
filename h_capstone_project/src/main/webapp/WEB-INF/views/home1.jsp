

<!DOCTYPE html>
<html lang="en">
<head>
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
}


</style>
<script>var url_string =window.location.href;
var url = new URL(url_string);
var c = url.searchParams.get("h");
alert("Please Note Your ID : "+c);
</script>

</head>
<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Hvg's Bank</a>
    </div>
    <ul class="nav navbar-nav navbar-right ">
    <div class="navbar-header">
    <a href="#" type="button" class="btn btn-default navbar-btn pull-">
      <span class="glyphicon glyphicon-home"></span>Home
    </a>
   
    
  </div>
      <li><a href="show_deposit">Deposit</a></li>
      <li><a href="show_withdraw">Withdraw</a></li>
      <li><a href="req_cb">Request Checkbook</a></li>
      &nbsp; &nbsp; &nbsp; &nbsp; 
      <li text-align="right"><a href="/h_capstone_project/r_admin_login.jsp" class="btn btn-outline-secondary">Logout</a></li>
    
    </ul>
  </div>
</nav>
  

<div align="center">
	<form class="form-inline" action="show_transtions" method="post">
		<div class="form-group mb-2">
			 <input
				type="text" 
				name="id" placeholder="User ID">
		</div>
		
		<button type="submit" class="btn btn-primary mb-2">Get Transactions List</button>
	</form>
</div><br>
<div align="center">
	<form class="form-inline" action="get_acc_details" method="post">
		<div class="form-group mb-2">
			 <input
				type="text" 
				name="id" placeholder="User ID">
		</div>
		
		<button type="submit" class="btn btn-primary">Get Account Details</button>
	</form>
</div><br>
<div align="center">
	<form class="form-inline" action="checkbookDetails" method="post">
		<div class="form-group mb-2">
			 <input
				type="text" 
				name="id" placeholder="User ID">
		</div>
		
		<button type="submit" class="btn btn-primary">Get CheckBook Details</button>
	</form>
	
</div>
</body>
</html>
