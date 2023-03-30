# **Employee System(User)**

Create a Rest Application that does the following

CRUD operations for User class
There is a User class with 2 child class
Manager
Employee
Your application should be able to have a REST endpoint for login using a username and password
Use spring security. If the user had a manager role, then you should give him Admin role using Spring security, and if he was registered as a simple user, you should give him a user role
Password should be encrypted using BCrypt inside the database
Here are the main fields of User class:

ID
username
password
email
TG
Mobile Phone
Home Phone
Address
First Name
Last Name
Date of Entry
Position
Department
Rank
Nationality
Immediate Supervisor
Salary
Salary Currency


**Take note that:**

For hierarchy in your project you should have used Single Table Strategy within hibernate
Both Manager and Employee class should have CRUD operation
You should use Spring Boot and Spring Data JPA for this
You should use Spring Data JPA pagination functionality for listing the users so you can fetch the data in a specified size from the DB not all users at the same time. Spring Data JPA can give this one to you and you don't need to code for it to achieve it
You should use MySQL database and for that, you can ask IT to install XAMPP on your machine

# **Employee System(Promotion Request)**
Create a Rest Application that does the following

CRUD operations for Promotion Request
You should have a consensus with Clarence, Jorge about the parent class of UserRequest, This class have Employee object inside it
Then your class will be ChangePosition class that has the following
Reason of being promoted
Effective Date
The UserRequest object has the following variables: (Parent Class)

id
dateOfRequest
User
dateOfChange
status
remarks


**Take note that:**

You should use Spring Boot and Spring Data JPA for CRUD operation
You shold use Single-Class Hierarchy for your UserRequest
You should use Spring Data JPA pagination functionality for listing the Promotion so you can fetch the data in a specified size from the DB not all users at the same time
You should use MySQL database and for that, you can ask IT to install XAMPP on your machine

# **Employee System(Change Salary Request)**

Create a Rest Application that does the following

CRUD operations for Change Salary Request
You should have a consensus with Clarence, Steven about the parent class of EmployeeRequest, This class have Employee object inside it
Then your class will be ChangeSalary class that has the following
Reason of changing Salary
Old Salary with Currency
New Salary with Currency
Effective Date
Working Summary
The UserRequest object has the following variables: (parent class)

id
dateOfRequest
User
dateOfChange
status
remarks

**Take note that:**

You should use Spring Boot and Spring Data JPA for CRUD operation
You shold use Single-Class Hierarchy for
You should use Spring Data JPA pagination functionality for listing the Salary Request so you can fetch the data in a specified size from the DB not all users at the same time
You should use MySQL database and for that, you can ask IT to install XAMPP on your machine

# **Employee System(Resignation Request)**

Create a Rest Application that does the following

CRUD operations for Resignation Request
You should have a consensus with Jorge, Steven about the parent class of UserRequest.  This class have User object inside it
Then your class will be ResignationRequest class that has the following
Reason of resignation (resign, fired, stop)
Resignation Date
Will return or not (Yes/No)
If Yes Expected Date to return
User Information
Working Summary
Reason of resignation  Summary
The UserRequest object has the following variables: (parent class)

id
dateOfRequest
User
dateOfChange
status
remarks

**Take note that:**

You should use Spring Boot and Spring Data JPA for CRUD operation
You should use hibernate Single-Class Hierarchy
You should use Spring Data JPA pagination functionality for listing the resignation requests so you can fetch the data in a specified size from the DB not all users at the same time
You should use MySQL database and for that, you can ask IT to install XAMPP on your machine