<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- 
    This is where you login as a user. Database
    is checked to make sure you exist.

    author: Aaron Garnett
    1/29/2020
-->
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1"
	charset="ISO-8859-1">
<title>Game Review Site</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<div id="header">
		<iframe style="border: none;" height="100%" width="100%"
			src="HeaderServlet"></iframe>
	</div>
	<div></div>
	<div class="login-block">
		<div class="error">
			<c:if test="${not empty loginError}">
				${loginError}
			</c:if>
		</div>
		<h1>LOGIN</h1>
		<form action="LoginModelServlet" method="post">
			<input type="text" name="name" value="" placeholder="Username"
				id="username" style="width: 320px" required /> <input
				type="password" id="password" name="pass" value=""
				placeholder="Password" style="width: 320px" required />
			<button>Login</button>
		</form>
	</div>
</body>
</html>