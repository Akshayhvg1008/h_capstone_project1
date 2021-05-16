<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
   @import url('https://fonts.googleapis.com/css?family=Montserrat:400,500,600,700|Poppins:400,500&display=swap');
*{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  user-select: none;
}
.bg-img{
  background: url('bg.jpg');
  height: 100vh;
  background-size: cover;
  background-position: center;
}
.bg-img:after{
  position: absolute;
  content: '';
  top: 0;
  left: 0;
  height: 100%;
  width: 100%;
  background: rgba(0,0,0,0.7);
}
.content{
  position: absolute;
  top: 50%;
  left: 50%;
  z-index: 999;
  text-align: center;
  padding: 60px 32px;
  width: 370px;
  transform: translate(-50%,-50%);
  background: rgba(255,255,255,0.04);
  box-shadow: -1px 4px 28px 0px rgba(0,0,0,0.75);
}
.content header{
  color: white;
  font-size: 33px;
  font-weight: 600;
  margin: 0 0 35px 0;
  font-family: 'Montserrat',sans-serif;
}
.field{
  position: relative;
  height: 45px;
  width: 100%;
  display: flex;
  background: rgba(255,255,255,0.94);
}
.field{
  position: relative;
  height: 45px;
  width: 100%;
  display: flex;
  background: rgba(255,255,255,0.94);
}

.field span{
  color: #222;
  width: 40px;
  line-height: 45px;
}
.field input{
  height: 100%;
  width: 100%;
  background: transparent;
  border: none;
  outline: none;
  color: #222;
  font-size: 16px;
  font-family: 'Poppins',sans-serif;
}
.space{
  margin-top: 16px;
}
.show{
  position: absolute;
  right: 13px;
  font-size: 13px;
  font-weight: 700;
  color: #222;
  display: none;
  cursor: pointer;
  font-family: 'Montserrat',sans-serif;
}
.pass-key:valid ~ .show{
  display: block;
}
.pass{
  text-align: left;
  margin: 10px 0;
}
.pass a{
  color: white;
  text-decoration: none;
  font-family: 'Poppins',sans-serif;
}
.pass:hover a{
  text-decoration: underline;
}
.field input[type="submit"]{
  background: #3498db;
  border: 1px solid #2691d9;
  color: white;
  font-size: 18px;
  letter-spacing: 1px;
  font-weight: 600;
  cursor: pointer;
  font-family: 'Montserrat',sans-serif;
}
.field input[type="submit"]:hover{
  background: #2691d9;
}
.login{
  color: white;
  margin: 20px 0;
  font-family: 'Poppins',sans-serif;
}

i span{
  margin-left: 8px;
  font-weight: 500;
  letter-spacing: 1px;
  font-size: 16px;
  font-family: 'Poppins',sans-serif;
}
.signup{
  font-size: 15px;
  color: white;
  font-family: 'Poppins',sans-serif;
}
.signup a{
  color: #3498db;
  text-decoration: none;
}
.signup a:hover{
  text-decoration: underline;
}
   
   </style>

</head>

<body>
	<div class="bg-img" >
	
		<div class="content" align="center">
			<b><header>User Registration</header></b>
			<form action="/user_registration" method="post">
				<div class="field" align="center">
					<span class="fa fa-user"></span> <input type="text" required
						placeholder="UserName" name="username">
				</div>
				<div class="field space" align="center">
					<span class="fa fa-lock"></span> <input type="password"
						class="pass-key" required placeholder="Password" name="password1">
					
				</div>
				<div class="field space" align="center">
					<span class="fa fa-lock"></span> <input type="number"
						class="pass-key" required placeholder="age" name="age">
					
				</div>
				<div class="field space" align="center">
					<span class="fa fa-lock"></span> <input type="text"
						class="pass-key" required placeholder="City" name="city">
					
				</div>
				<div class="field space" align="center">
					<span class="fa fa-lock"></span> <input type="text"
						class="pass-key" required placeholder="Gender" name="gender">
					
				</div>
			
				<div class="field space" align="center">
					<span class="fa fa-lock"></span> <input type="text"
						class="pass-key" required placeholder="Phone Number" name="ph_no">
					
				</div>
				<div class="field space" align="center">
					<span class="fa fa-lock"></span> <input type="text"
						class="pass-key" required placeholder="Country" name="country">
					
				</div>
				<div class="pass">
					<a href="#">   </a>
				</div>
				<div class="field">
					<input type="submit" name="submit" value="Register">
				</div>
			</form>

			
		</div>
	</div>

</body>





</html>