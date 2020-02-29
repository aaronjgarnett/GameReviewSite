<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!--
    Homepage for case study. This will list the
    top 10 games based on aggregate score for
    each genre.

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
					<div class="col-sm-2">
						<div class="dropdown">
							<button type="button" class="btn btn-primary dropdown-toggle"
								data-toggle="dropdown" style="background-color: #258e3f;">Browse
								by Genre</button>
							<ul class="dropdown-menu">
								<li><a href="IndexServlet">all</a></li>
								<c:forEach items="${genres}" var="i">
									<li><a href="IndexServlet?id=${i.id}">${i.name}</a></li>
								</c:forEach>
							</ul>
						</div>
					</div>
					<div class="col-sm-10">
						<div class="container">
							<c:forEach items="${games}" var="i">
								<div class="row">
									<div class="col-sm-2">
										<img src="${i.cover}" style="margin-top: 10px" />
									</div>
									<div class="col-sm-6">
										<h1>
											<a href="GameServlet?id=${i.id}">${i.name}</a>
										</h1>
										<fmt:formatDate value="${i.date}" pattern="yyyy-MM-dd" />
										<p>${i.description}</p>
									</div>
									<div class="col-sm-4 grade">
										<fmt:formatNumber value="${i.aggregateScore}" type="number"
											maxFractionDigits="1" />
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>