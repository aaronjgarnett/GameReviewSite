<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!--
    This page will the user that it failed
    to find a game with the searched title.

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
</head>
<body>
	<div id="header">
		<iframe style="border: none;" height="100%" width="100%"
			src="HeaderServlet"></iframe>
	</div>
	<div class="jumbotron">
		<h1 class="display-4">404 - Not Found</h1>
		<p class="lead">The game you searched for does not exist within
			our database, we are sorry. Please try again.</p>
	</div>
</body>
</html>