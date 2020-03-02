<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!--
    This page will load all messages in the
    database (admin only).

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
	<c:if test="${!messages.isEmpty()}">
		<div class="siteLayout">
			<div class="container">
				<c:forEach items="${messages}" var="i">
					<div class="row">
						<div class="col-sm-12" style="margin-top: 20px">
							Author: ${i.author} <br /> Email: ${i.email}
							<div class="review">
								<p>${i.message}</p>
							</div>
							<a href="DeleteServlet?id=${i.id}">delete message</a>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</c:if>
	<c:if test="${messages.isEmpty()}">
		<div class="jumbotron">
			<h1 class="display-4">There are no Messages</h1>
		</div>
	</c:if>
	<div class="footer">
		<iframe style="border: none;" height="100%" width="100%"
			src="FooterServlet"></iframe>
	</div>
</body>
</html>