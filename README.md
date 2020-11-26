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
- ~Invalid logins receive a messgae informing them of this and are prompted to enter login credentials again 
 
## Motivation
This project provided an opportunity to implement the knowledge I have gained on creating a very simple Full stack Java application including a login page for authorisation and authentication. I was able to implement Java EE security into a project and restrict certain areas of the application based on the role assigned to the user. A DAO design pattern was used to communicate to pull data from the database. Furthermore, soem simple HTML and CSS were implemented during this project.

## Technologies
- IntelliJ
- Java (JDK 11)
- Maven
- Java EE

## Launch
To launch this project you require IntelliJ (community or ultimate) and then need to clone this github repo and open this project from IntelliJ.
To use this program, Add your employee records CSV file to the resources directory, ensuring the column headings are the same as those in the EmployeeDTO class.
After completing this, change the variable ReadFile.inputFile to the path of your new file. Then run the program.

## Future Work
- Adding additional Crud functionalities - updating, deleting employee records
- Adding a front end
