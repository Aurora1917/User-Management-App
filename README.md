
## Overview

The User and Task Management Application is a full-stack web application developed using **Spring Boot** and **Thymeleaf**. It is designed to manage users and their associated tasks efficiently. The application supports operations like creating, updating, and deleting users and tasks, assigning tasks to users, filtering tasks by user or status, and updating task statuses.

## Features

### User Management
- Add new users with details such as name, email, and password.
- View a list of all registered users.
- Delete users directly from the user list.

<img width="1427" alt="Screenshot 2025-01-25 at 18 31 08" src="https://github.com/user-attachments/assets/7e9667e6-62cc-44bd-8088-27a2754163a8" />

### Task Management
- Create tasks with a title and description.
- Assign tasks to specific users.
- Filter tasks by user and status (Pending or Completed).
- Update task statuses dynamically.
- Delete tasks from the task list.
- Navigate seamlessly between the **User Management** and **Task Management** pages using the navigation buttons.
- PS: There are few bugs releated to Front-end button mappings, but backend API's doing their job completely.
<img width="1437" alt="Screenshot 2025-01-25 at 18 26 42" src="https://github.com/user-attachments/assets/ccfb91ec-d2f2-4d88-a819-a740d93907c0" />
<img width="1440" alt="Screenshot 2025-01-25 at 18 27 07" src="https://github.com/user-attachments/assets/b94343e0-5319-4358-9c37-b81cb45e56f3" />
<img width="1431" alt="Screenshot 2025-01-25 at 18 32 14" src="https://github.com/user-attachments/assets/74348900-bfc6-4f2c-9e0c-1000a992f9ee" />

  


### Responsive Design
- The application is styled using CSS, providing a clean and modern user interface.
- Layouts are optimized for different screen sizes.
- ChatGPT used for Frontend 

## Technologies Used
- **Backend**: Spring Boot
- **Frontend**: Thymeleaf templates (Ai generated frontend)
- **Database**: PostgreSQL
- **CSS**: Custom styling for a modern and intuitive UI

## How to Run the Application

1. Clone this repository:
 
2. Navigate to the project directory:
   ```bash
   cd user-task-management
3. Update the application Properties file:
   update the properties for your own database and port preferences. 
   ```
4. Build the project using Maven:
   ```bash
   mvn clean install
   ```
5. Run the application:
   ```bash
   mvn spring-boot:run
   ```
6. Access the application in your browser at:
   ```
   http://localhost:8090
   ```

## Project Structure

```
user-task-management/
|-- src/
|   |-- main/
|       |-- java/
|           |-- com.example/
|               |-- UserTaskManagementApplication.java
|               |-- controller/
|               |-- model/
|               |-- repository/
|               |-- service/
|       |-- resources/
|           |-- static/
|               |-- css/
|                   |-- styles.css
|           |-- templates/
|               |-- user-management.html
|               |-- task-management.html
|           |-- application.properties
|-- pom.xml
|-- README.md
```

## Key Files

- **User Management Page**: Displays a form to add users and a table to view/delete users.
- **Task Management Page**: Includes forms for adding and filtering tasks, and a table for viewing/updating/deleting tasks.
- **CSS File**: Provides consistent styling across the application.



Feel free to contact me with any questions or suggestions!
# User-Management-App
