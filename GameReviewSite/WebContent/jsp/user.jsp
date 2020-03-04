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
<title>NewGames.Reviews</title>
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
						<img src="${user.avatar}"
							style="border-radius: 50%; width: 100px; height: 100px" />
					</div>
					<div class="col-sm-10" style="margin-top: 20px">
						<h3>${user.name}</h3>
						<h4>${user.email}</h4>
					</div>
				</div>
				<form action="UserModelServlet?id=${user.id}" method="post"
					enctype="multipart/form-data">
					<label for="avatar" style="margin-top: 5px">You can change
						your Profile picture here</label> <input type="file" name="avatar"
						id="avatar" value="" accept="image/png, image/jpeg" size="50"
						required />
					<button class="profile-change">Change Profile</button>
				</form>
			</div>
		</div>
	</div>
	<div class="footer">
		<iframe style="border: none;" height="100%" width="100%"
			src="FooterServlet"></iframe>
	</div>
</body>
</html>