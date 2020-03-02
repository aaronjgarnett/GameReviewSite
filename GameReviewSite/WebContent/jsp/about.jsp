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
<title>NewGames.Reviews</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<div id="header">
		<iframe style="border: none;" height="100%" width="100%"
			src="HeaderServlet"></iframe>
	</div>
	<div id="siteLayout">
		<div id="mainPage" class="mainDiv">
			<div class="container">
				<h1>Summary</h1>
				<div class="row">
					<div class="col-sm-12">
						<p>This is a website that aggregates reviews of video games.
							For each product, the scores from each review are averaged. This
							site was created by Aaron Garnett, for his per scholas case
							study. The site provides a list of reviews for each game.</p>
						<p>Websites such as these do exist already on the web but when
							determining whether or not to purchase a game, it never hurts to
							look at multiple sources.</p>
					</div>
				</div>
				<h1>Technology</h1>
				<div class="row">
					<div class="col-sm-7">
						<img src="images/javaee.jpg"
							title="From book: Java EE 7 Essentials by Arun Gupta"
							style="height: 300px; width: 600px" /> <img
							src="images/jpa_class_level_architecture.png" title="JPA Diagram" />
						<img src="images/600px-JSPLife.png" title="A JSP Life" />
						<h2>My Database</h2>
						<img src="images/ReviewSiteERD.png" />
					</div>
					<div class="col-sm-5">
						<p>Java EE Technology was decidedly used to make this website.
							Specifically these technologies were used:</p>
						<ul>
							<li><strong>Java Persistance API (JPA)</strong> (Now called
								<strong>Jakarta Persistence</strong>)</li>
							<li><strong>Enterprise JavaBeans (EJB)</strong> (for JPA)</li>
							<li>MySQL</li>
							<li>Java <strong>Sevlets</strong></li>
							<li><strong>JavaServer Pages (JSP)</strong></li>
							<li>HTML, CSS, and JavaScript</li>
						</ul>
						<h4>Java Entities</h4>
						<ul>
							<li><em>User.java</em> - Entity for the people who will use
								this site.</li>
							<li><em>Game.java</em> - Entity for the games within the
								site.</li>
							<li><em>Review.java</em> - Entity for the reviews associated
								with each game. Written by the users.</li>
							<li><em>Genre.java</em> - Entity for the genres that each
								game fall under.</li>
							<li><em>PublishingCompany.java</em> - Entity for the
								Companies that go out and publish the games that are on this
								site.</li>
							<li><em>ContactMessage.java</em> - Entity for the messages
								that are sent to the site.</li>
						</ul>
						Each entity has a service class that has methods to obtain
						information from the database that corresponds with the entities.
						<h4>JSPs</h4>
						<ul>
							<li><em>index.jsp</em> - Homepage for case study. This will
								list the top 10 games based on aggregate score for each genre.</li>
							<li><em>about.jsp</em> - The page you're on.</li>
							<li><em>contact.jsp</em> - Where you send a message.</li>
							<li><em>game.jsp</em> - This page will load a game, then
								load all reviews for said game. Reviews may be written here as
								well.</li>
							<li><em>login.jsp</em> - This is where you login as a user.
								Database is checked to make sure you exist.</li>
							<li><em>register.jsp</em> - This is where you enter a
								correct password and email to register as a user.</li>
							<li><em>user.jsp</em> - This is the user's page, the user
								can change their avatar here.</li>
						</ul>
						<h5>For Admins ONLY</h5>
						<ul>
							<li><em>gameForm.jsp</em> - This is where you can add a game
								to the site.</li>
							<li><em>viewUsers.jsp</em> - This page will list all users
								and have the option to block or unblock them.</li>
							<li><em>viewMessages.jsp</em> - This page will load all
								messages in the database.</li>
						</ul>
						Other JSPs exist, but these are the main interactable ones.
						<h4>Java Servlets</h4>
						<p>Each JSP has has a corresponding Servlet attached to it
							which loads the jsp along with the data in the page. Other
							Servlets include:</p>
						<ul>
							<li><em>ReviewServlet.java</em> - Adds a review to the
								database submitted in the Game.jsp.</li>
							<li><em>RemoveServlet.java</em> - Removes a review from the
								database called from the Game.jsp.</li>
							<li><em>ContactModelServlet</em> - Takes input from the
								contact page a adds a contact message to the database.</li>
							<li><em>LoginModelServlet.java</em> - Checks input from the
								login page to see if you may login into the site.</li>
							<li><em>RegisterModelServlet.java</em> - Takes input from
								the register page and creates a user using that input.</li>
							<li><em>LogoutServlet.java</em> - Logsout the current user.</li>
							<li><em>AddGameModelServlet.java</em> - Takes input from the
								gameForm page and adds a game to the database.</li>
							<li><em>ChangeBlockStatusServlet.java</em> - Changes
								selected user from viewUsers.jsp from blocked to unblocked (or
								vice versa).</li>
							<li><em>DeleteServlet.java</em> - Deletes a message from the
								database called from viewMessages.jsp</li>
						</ul>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12">
						<strong>Other Specifications:</strong>
						<ul>
							<li>Made in Eclipse</li>
							<li>Runs on Apache Tomcat Server 9.0</li>
							<li>Uses Bootstrap and JQuery</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="footer">
		<iframe style="border: none;" height="100%" width="100%"
			src="FooterServlet"></iframe>
	</div>
</body>
</html>