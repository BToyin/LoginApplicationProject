# LoginApplicationProject

## Requirements
Build a simple login application to demonstrate your knowledge of Java EE so far
- The application will store a number of valid users who will be able to login
- The system should have a reasonable way of dealing with invalid logins
- It looks amazing
- Login details are kept within a Java class or supported file
- Aspects of the application are restricted
- Sections of the website are view-able only by those with an admin role
- User details are kept on a database
- An admin is able to add new users to the database and assign them a role

## Functionalities 
- Users are able to login into the applicaiton based on whether their details are stored inside the database.
- Only Admins have access to the restricted registration page
- Invalid logins receive a messgae informing them of this and are prompted to enter login credentials again
- Security constraints were added to the project through configuration of the web.xml file
- Use of templates for consistent headers and footers
 
## Motivation
This project provided an opportunity to implement the knowledge I have gained on creating a very simple Full stack Java application including a login page for authorisation and authentication. I was able to implement Java EE security into a project and restrict certain areas of the application based on the role assigned to the user. A DAO design pattern was used to communicate to pull data from the database. Furthermore, some simple JSF and CSS were used during this project.

## Technologies
- IntelliJ
- Java (JDK 11)
- Maven
- Java EE
- Payara server (glassfish)
- Hibernate (ORM)
- Beans
- JSFs

## Launch
To launch this project you require IntelliJ (community or ultimate) and then need to clone this github repo and open this project from IntelliJ. You must then configure your databsse through the persistence.xml file (for ORM) by changing the username and password. Then configure the payara server if required. You should then be able to run this application.

## Future Work
- Add the functionality of the registration page so that an admin can add users to the database
- More styling - currrently very basic styling
