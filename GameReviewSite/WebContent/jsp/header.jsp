<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!--
    Header for case study. Contains links to
    all webpages. Has a search bar to search
    games.

    author: Aaron Garnett
    1/29/2020
-->
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<nav class="navbar navbar-inverse" style="background-color: #258e3f;">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="IndexServlet" target="_top"><img
				src="images/5a0752ca77b52_thumb900.jpg"
				style="width: 150px; height: 25px" /></a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="IndexServlet" target="_top">Home </a></li>
			<li><a href="AboutServlet" target="_top">About </a></li>
			<li><a href="ContactServlet" target="_top">Contact</a></li>
		</ul>
		<form class="navbar-form navbar-left" action="GameServlet"
			method="get" target="_top">
			<div class="form-group">
				<input type="search" list="game-titles" class="form-control"
					placeholder="Search" name="search" />
				<datalist id="game-titles">
					<c:forEach items="${games}" var="i">
						<option value="${i.name}" />
					</c:forEach>
				</datalist>
			</div>
			<button type="submit" class="btn btn-default">Search</button>
		</form>
		<ul class="nav navbar-nav navbar-right">
			<c:if test="${!loggedIn}">
				<li><a href="RegisterServlet" target="_top"><span
						class="glyphicon glyphicon-user"></span>Register</a></li>
				<li><a href="LoginServlet" target="_top"><span
						class="glyphicon glyphicon-log-in"></span>Login</a></li>
			</c:if>
			<c:if test="${loggedIn}">
				<li><a href="UserServlet?id=${u.id}" target="_top"><img
						src="${u.avatar}"
						style="border-radius: 50%; width: 25px; height: 25px" />Hello,
						${user}</li>
				</a>
				<li><a href="LogoutServlet" target='_top'><span
						class="glyphicon glyphicon-log-out"></span>Logout</a></li>
			</c:if>
		</ul>
	</div>
	<c:if test="${isAdmin}">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="IndexServlet" target="_top">Admin
					Controls</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="AddGameServlet" target="_top">Add Game </a></li>
				<li><a href="ViewUsersServlet" target="_top">View Users </a></li>
				<li><a href="ViewMessageServlet" target="_top">View
						Messages</a></li>
			</ul>
		</div>
	</c:if>
</nav>