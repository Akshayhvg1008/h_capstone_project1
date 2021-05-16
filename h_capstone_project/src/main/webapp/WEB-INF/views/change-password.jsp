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

	<div id="container">
		<h3>Add Product</h3>
	
		<form action="saveNewPassword" method="post"> 
	<div align="center" class="center">
  <table>
    <tr>
      <td align="right">UserName</td>
      <td align="left"><input type="text" name="username" /></td>
    </tr>
    <tr>
      <td align="right">Password</td>
      <td align="left"><input type="int" name="password" /></td>
    </tr>
    <tr>
      <td align="right">New Password</td>
      <td align="left"><input type="text" name="newpassword" /></td>
    </tr>
   
     <tr>
      <td align="right"></td>
      <td align="left"><input type="submit" name="where" value="Change Password" /></td>
    </tr>
  </table>
  </div>
</form>
		
		

</body>

</html>









