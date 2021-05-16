<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
background-image: url("https://cdn.wallpapersafari.com/1/65/1A74vD.jpg");
	background-repeat: no-repeat;
	background-size: 100%;
}

h1,h2 {
  background-color: white
  ;
}

div {
  background-color: black;
}

p {
  background-color: white;
}

.button {
	border-radius: 4px;
	background-color: #34495e;
	border: none;
	color: #ffffff;
	text-align: auto;
	font-size: 28px;
	padding: 20px;
	width: 200px;
	height: 100px;
	transition: all 0.5s;
	cursor: pointer;
	margin: 200px 200px 200px 200px;
	align-content: center;
}

.button span {
	cursor: pointer;
	display: inline-block;
	position: relative;
	transition: 0.5s;
}

.button span:after {
	content: '\00bb';
	position: absolute;
	opacity: 0;
	top: 0;
	right: -20px;
	transition: 0.5s;
}

.button:hover span {
	padding-right: 25px;
}

.button:hover span:after {
	opacity: 1;
	right: 0;
}
</style>

</head>

<body >
	<a href="r_admin_login.jsp">
		<button class="button" align="center">

			<span> User Login
			</span>
		</button>
	</a>

	<a href="r_login.jsp">
		<button class="button" align="center">

			<span>Admin Login </span>
		</button>
	</a>
	<section >
        <div align="center">
            <div class="col-lg-8 col-lg-offset-2">
                <h1>About Developer Details</h1>
            <b>    <h2>Developed By Maligi Anantha Akshay , TEKsystems Global Services.</h2></b>
            </div>
        </div>
    </section>
</body>
</html>