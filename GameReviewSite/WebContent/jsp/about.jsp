<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- 
    This is an about page.

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
	<div id="siteLayout">
		<div id="mainPage" class="mainDiv">
			<div class="container p-3 my-3 border">
				<div class="row">
					<div class="col-sm-12">
						<p>This is a website that aggregates reviews of video games.
							For each product, the scores from each review are averaged. This
							site was created by Aaron Garnett, for his per scholas case
							study. The site provides a list of reviews for each game.</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>