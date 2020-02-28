<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!--
    This is the user's page, the user
    can change their avatar here.

    author: Aaron Garnett
    2/28/2020
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
	<div class="siteLayout">
		<div id="mainPage" class="mainDiv">
			<div class="container">
				<div class="row">
					<div class="col-sm-2" style="margin-top: 20px">
						<img src="${u.avatar}"
							style="border-radius: 50%; width: 100px; height: 100px" />
					</div>
					<div class="col-sm-10" style="margin-top: 20px">
						<h3>${u.name}</h3>
						<h4>${u.email}</h4>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>