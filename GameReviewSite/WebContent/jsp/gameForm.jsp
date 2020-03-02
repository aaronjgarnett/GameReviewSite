<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 
    This is where you can add a game to
    the site (admin only).

    author: Aaron Garnett
    2/29/2020
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
		<div class="login-block">
			<div class="error">
				<c:if test="${not empty addError}">
				${addError}
			</c:if>
			</div>
			<h1>ADD A GAME</h1>
			<form action="AddGameModelServlet" onsubmit="addGame()" method="post"
				enctype="multipart/form-data">
				<input type="text" name="name" value="" placeholder="Name" id="name"
					style="width: 320px" required /> <input type="text" list="genres"
					placeholder="Select its genre" name="genreType" required />
				<datalist id="genres">
					<c:forEach items="${genres}" var="i">
						<option value="${i.name}" />
					</c:forEach>
				</datalist>
				<input type="text" list="publishers"
					placeholder="Select its publisher" name="publisher" required />
				<datalist id="publishers">
					<c:forEach items="${publishers}" var="i">
						<option value="${i.name}" />
					</c:forEach>
				</datalist>
				<label for="date">Release Date:</label> <input type="date" id="date"
					name="date" required /> <label for="cover">Select its
					Cover:</label> <input type="file" name="cover" id="cover" value=""
					accept="image/png, image/jpeg" size="50" required />
				<textarea id="description" name="description"
					placeholder="Give a description of the Game"
					style="width: 320px; height: 125px" required></textarea>
				<button type="submit">Submit</button>
			</form>
		</div>
	</div>
	<div class="footer">
		<iframe style="border: none;" height="100%" width="100%"
			src="FooterServlet"></iframe>
	</div>
</body>
</html>