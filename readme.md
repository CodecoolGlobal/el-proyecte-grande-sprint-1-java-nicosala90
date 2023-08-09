# B-Fit fitness web application for you
## Purpose
A fitness-health-lifestyle application where the user in this app can reach different features for their fitness benefit like BMI calculator and if he/she has already registered a historical sheet and a chart about the results of his/her efforts.
Also the app function like a social media app where users can talk to the coaches or later to each other for example to find a workout buddy, or there will be a section for Q&A

## Technology
PostgreSQL - database\
Spring Boot (Java) - backend\
React (Javascript) - frontend

## How to run

### Without Docker
Needed software: Java JRE for the backend and e.g. NodeJs for the frontend.\
1. The back-end server runs from the cloned repository from the backend subdirectory.\
2. The front-end server runs from the cloned repository from the front-end subdirectory.
   ```
    npm install
   ```
   ```
    npm run dev
   ```

### With Docker 
   ##### Running the Project with Docker
To run the project in a Docker container, follow these steps:

Prerequisites
- Install Docker on your machine. You can download Docker from the official website:
  https://www.docker.com/get-started
#### Building the Docker Image
1. Clone the repository to your local machine.
2. Navigate to the project's root directory.

#### Running the Docker Container
Once you have the Docker environment and the project built, navigate to the root directory.
Backend (Java)
1. Open a terminal or command prompt.
2. Build the Docker image using the following command:
  ```
 docker build -t el-proyecte-grande -f Dockerfile .
 ```
4. Run the Docker container:
   ```
   docker run --name el-proyecte-grande-app --rm -dp 8080:8080 el-proyecte-grande
    ```
   
#### Accessing the Application
Once the Docker container is running, you can access the application using a web browser:
-  Open http://localhost:8080 in your web browser.
