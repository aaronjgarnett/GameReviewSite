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
<title>NewGames.Reviews</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<link rel="stylesheet" href="css/style.css" />
<script src="js/validate.js" type="text/javascript"></script>
<script src="js/color-change.js" type="text/javascript"></script>
</head>
<body>
	<div id="header">
		<iframe style="border: none;" height="100%" width="100%"
			src="HeaderServlet"></iframe>
	</div>
	<div class="siteLayout">
		<div id="mainPage" class="mainDiv">
			<div class="container"
				style="background-color: rgba(255, 255, 255, 1)">
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
					<div class="col-sm-5 grade">
						<fmt:formatNumber value="${game.aggregateScore}" type="number"
							maxFractionDigits="1" />
					</div>
				</div>
				<div class="row">
					<c:if test="${loggedIn}">
						<div class="col-sm-12">
							<form action="ReviewServlet?id=${game.id}" method="post">
								<textarea id="subject" name="subject"
									placeholder="Write review here..."
									style="width: 320px; height: 125px" required></textarea>
								<br /> <input id="score" type="number" name="score" min="1"
									max="10" placeholder="Score(1-10)" required /> <br />
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
				<c:forEach items="${reviews}" var="i">
					<div class="row">
						<div class="col-sm-12" style="margin-top: 20px">
							<img src="${i.user.avatar}"
								style="border-radius: 50%; width: 25px; height: 25px" />${i.user.name}
							says:
							<div class="review">
								<p>${i.content}</p>
								<br />
								<div class="score">
									<fmt:formatNumber value="${i.score}" type="number"
										maxFractionDigits="1" />
									/10
								</div>
							</div>
							<c:if test="${loggedIn}">
								<c:if test="${i.user.name == user || isAdmin}">
									<a href="RemoveServlet?id=${i.id}&game=${game.id}">remove</a>
								</c:if>
							</c:if>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<div class="footer">
		<iframe style="border: none;" height="100%" width="100%"
			src="FooterServlet"></iframe>
	</div>
</body>
</body>
</html>