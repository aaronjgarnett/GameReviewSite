# GameReviewSite
Summary
This is a website that aggregates reviews of video games. For each product, the scores from each review are averaged. This site was created by Aaron Garnett, for his per scholas case study. The site provides a list of reviews for each game.

Websites such as these do exist already on the web but when determining whether or not to purchase a game, it never hurts to look at multiple sources.

Java EE Technology was decidedly used to make this website. Specifically these technologies were used:

Java Persistance API (JPA) (Now called Jakarta Persistence)

Enterprise JavaBeans (EJB) (for JPA)

MySQL

Java Sevlets

JavaServer Pages (JSP)

HTML, CSS, and JavaScript

Java Entities

User.java - Entity for the people who will use this site.

Game.java - Entity for the games within the site.

Review.java - Entity for the reviews associated with each game. Written by the users.

Genre.java - Entity for the genres that each game fall under.

PublishingCompany.java - Entity for the Companies that go out and publish the games that are on this site.

ContactMessage.java - Entity for the messages that are sent to the site.

Each entity has a service class that has methods to obtain information from the database that corresponds with the entities.

JSPs

index.jsp - Homepage for case study. This will list the top 10 games based on aggregate score for each genre.

about.jsp - The page you're on.

contact.jsp - Where you send a message.

game.jsp - This page will load a game, then load all reviews for said game. Reviews may be written here as well.

login.jsp - This is where you login as a user. Database is checked to make sure you exist.

register.jsp - This is where you enter a correct password and email to register as a user.

user.jsp - This is the user's page, the user can change their avatar here.

For Admins ONLY

gameForm.jsp - This is where you can add a game to the site.

viewUsers.jsp - This page will list all users and have the option to block or unblock them.

viewMessages.jsp - This page will load all messages in the database.

Other JSPs exist, but these are the main interactable ones.

Java Servlets

Each JSP has has a corresponding Servlet attached to it which loads the jsp along with the data in the page. Other Servlets include:

ReviewServlet.java - Adds a review to the database submitted in the Game.jsp.

RemoveServlet.java - Removes a review from the database called from the Game.jsp.

ContactModelServlet - Takes input from the contact page a adds a contact message to the database.

LoginModelServlet.java - Checks input from the login page to see if you may login into the site.

RegisterModelServlet.java - Takes input from the register page and creates a user using that input.

LogoutServlet.java - Logsout the current user.

AddGameModelServlet.java - Takes input from the gameForm page and adds a game to the database.

ChangeBlockStatusServlet.java - Changes selected user from viewUsers.jsp from blocked to unblocked (or vice versa).

DeleteServlet.java - Deletes a message from the database called from viewMessages.jsp

Other Specifications:

Made in Eclipse

Runs on Apache Tomcat Server 9.0

Uses Bootstrap and JQuery
