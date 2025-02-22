# Apartment Complaint Management System (ACMS)

## Overview 

The Apartment Complaint Management System (ACMS) is a user-friendly desktop application designed to help apartment managers streamline the process of handling tenant complaints. By simplifying the logging, tracking, and resolution of complaints, this system ensures efficient management and improved tenant satisfaction.

## Prerequisites

To make this Application work, you need to meet below requirements:

- **IntelliJ IDEA** to work with the project. Download it from [here](https://www.jetbrains.com/idea/).
- **Gradle** (version 20). You can install it directly from Intellij.
- **JDBC Driver**: Ensure you have the appropriate JDBC driver for the database you're using like MySQL.
- **Database**: You must have access to a running database. Ensure the JDBC connection details (URL, username, password,server name) are correctly configured in your project.

## Installation

1.Clone the repository to your local machine by using below command in terminal:

`git clone https://github.com/Sakshi2336/Java3_ComplaintManagament_Project.git`

2.Then write these commands in your terminal:

`git checkout development`

`git pull`

3.Then open your project into **Intellij IDEA**

4.Now Gradle will automatically download dependencies including JDBC driver.

## How to run the application

You need to run **LoginForm.java** class and once you will enter your username,password,database name and server name, you are all set to use this application.

## Features

### **Login Page**

![Login Page](src/main/resources/org/example/java3_final_project/Images/LoginPage.png)

- This is the Login Page where you will need to enter your username, password of your database then database name where you want to create all tables related to this application and then server name.
- Once you do this and hit **Test Connection** button, you will see Welcome page of the application.


### **Welcome Page**

![Welcome Page](src/main/resources/org/example/java3_final_project/Images/WelcomePage.png)

- This is the entry point of this application.


### **Main Dashboard**

1. **View All Complaints**

![Complaint List](src/main/resources/org/example/java3_final_project/Images/ViewComp.png)

- In View Complaints tab you can see all registered complaints till now.
- You can have every details related to any complaint including
  + Short description
  + Submit time
  + Complaint status - Open , In Process , Resolved
  + Tenant who registered that complaint
  + Flat number 
  + Assigned Manager
    
2. **Update Form**

![Update Form](src/main/resources/org/example/java3_final_project/Images/UpdateForm.png)
   
- By clicking on any complaint you can see update form where you can change complaint description , complaint status and assigned manager.

3. **Add Complaint Form**

![Add Form](src/main/resources/org/example/java3_final_project/Images/AddForm.png)

- In Add complaint form, you can easily add more complaints.

4. **Statistics**

![Menu Page](src/main/resources/org/example/java3_final_project/Images/statistics.png)

- In this tab, we have pie chart showing complaints distribution by each category.

5. **Tenant Information**

![Tenant List](src/main/resources/org/example/java3_final_project/Images/Remove.png)

- Here you can have list of tenants, living in the apartment with associated flat.
- By clicking Remove button after selecting any tenant from list, you can easily delete tenant record from tables after tenant moved out.

6. **Go Back**

- Go Back tab will take you back to the Welcome page.
       

## Database Schema

![Database Schema](src/main/resources/org/example/java3_final_project/Images/databaseSchema.png)
- This is basic database structure for this project.

## Compatibility

This project is compatible with the following platforms and environments:

| Platform               | Version Supported    |
|------------------------|----------------------|
| **Operating System**   |
| Windows                | 10 and later         |
| macOS                  | 10.14 Mojave and later |



| **Development Environment** | Version Supported |
|-----------------------------|-------------------|
| IntelliJ IDEA               | 2020 and later    |
| Java JDK                    | 17 and later      |
| Gradle                      | 20.0    |



| **Dependencies**              | Version Supported     |
|-------------------------------|-----------------------|
| MySQL JDBC Connector (JDBC)    | 8.0.28 and later      |
| JavaFX                        | 17.0.6                |


## Authors:

[Sakshi Patel](https://github.com/Sakshi2336)

[Gian Kaur](https://github.com/Giankaur03)

[Prabhjeet Singh](https://github.com/28Prabh)

[Mankirat Singh](https://github.com/msandhu16)

## Licence

This project is licensed under the MIT License.

MIT License

Copyright (c) 2024 Sakshi Patel , Gian Kaur , Prabhjeet Singh , Mankirat Singh

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
