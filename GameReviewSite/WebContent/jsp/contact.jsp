<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- 
    This is where you send a message.

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
<script src="js/validate.js" type="text/javascript"></script>
</head>
<body>
	<div id="header">
		<iframe style="border: none;" height="100%" width="100%"
			src="HeaderServlet"></iframe>
	</div>
	<div></div>
	<div class="login-block">
		<h1>CONTACT US</h1>
		<form onsubmit="sendMessage()">
			<input type="text" name="name" value="" placeholder="Name" id="name"
				style="width: 320px" required /> <input type="email" id="email"
				name="email" value="" placeholder="Email" style="width: 320px"
				required />
			<textarea id="subject" name="subject" placeholder="Enter Message"
				style="width: 320px; height: 125px" required></textarea>
			<button type="submit">Submit</button>
		</form>
	</div>
</body>
</html>