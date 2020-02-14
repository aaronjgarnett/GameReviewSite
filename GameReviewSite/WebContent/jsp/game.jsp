<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!--
    This page will load a game, then load
    all reviews for said game. Reviews may be
    here as well.

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
	<div class="siteLayout">
		<div id="mainPage" class="mainDiv">
			<div class="container p-3 my-3 border center">
				<div class="row">
					<div class="col-sm-12">
						<h1>${game.name}</h1>
						${game.publishingCompany.name} | Release Date:
						<fmt:formatDate value="${game.date}" pattern="yyyy-MM-dd" />
					</div>
				</div>
				<div class="row">
					<div class="col-sm-2">
						<img src="${game.cover}" />
					</div>
					<div class="col-sm-5">
						<p>
							<strong>Summary: </strong>${game.description}</p>
						<strong>Genre(s): </strong>
						<c:forEach items="${game.genres}" var="i">${i.name} </c:forEach>
					</div>
					<div class="col-sm-5 grade">${game.aggregateScore}</div>
				</div>
				<div class="row">
					<c:if test="${loggedIn}">
						<div class="col-sm-12">
							<form method="post">
								<textarea id="subject" name="subject"
									placeholder="Write review here..."
									style="width: 320px; height: 125px" required></textarea>
								<br /> <input id="score" type="number" name="score" min="1"
									max="10" required /> <br />
								<button id="submitReview" type="submit">Submit Review</button>
							</form>
						</div>
					</c:if>
					<c:if test="${!loggedIn}">
						<div class="col-sm-12" style="margin-top: 10px">
							<form action="LoginServlet">
								<button id="submitReview" type="submit">Login to Submit
									Review</button>
							</form>
						</div>
					</c:if>
				</div>
				<div class="row">
					<div class="col-sm-12" style="margin-top: 20px">
						<span class="glyphicon glyphicon-user"></span>aaron says:
						<div class="review">
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
								Sed consectetur eleifend mauris sed porttitor. Etiam vestibulum
								ante eros, sed commodo arcu malesuada id. Nunc fermentum eros ac
								lacus ullamcorper, a semper massa viverra. Quisque id diam elit.
								In orci odio, porttitor in eros nec, imperdiet congue mi.
								Praesent mattis elit eu vehicula semper. Integer eget mauris
								finibus, laoreet augue quis, vehicula ante. Nam volutpat quis
								leo vel condimentum. Praesent at lacus non lacus tempor mattis.
								Nullam at ante dui. In hac habitasse platea dictumst. Proin id
								mi condimentum, scelerisque velit sed, ornare lacus. Donec
								malesuada accumsan augue malesuada rhoncus. Aliquam et nibh
								pharetra, porttitor sem ut, finibus orci. Aliquam nec dictum
								eros, iaculis maximus mauris. Vestibulum ante ipsum primis in
								faucibus orci luctus et ultrices posuere cubilia Curae;</p>
							<br />
							<div class="score">10/10</div>
						</div>
						<c:if test="${loggedIn}">
							<a>remove</a>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</body>
</html>