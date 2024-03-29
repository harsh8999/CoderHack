# CoderHack Leaderboard API

Welcome to the CoderHack Leaderboard API! This application provides a RESTful API service to manage the leaderboard for a coding platform's contest. It utilizes Spring Boot for backend development and MongoDB for data persistence.

## Requirements

- Handle CRUD operations for user registrations
- Each user has a unique identifier, username, score, and badges
- Updation of user scores is allowed
- Badges are awarded based on user scores
- User retrieval must be sorted based on scores
- Implement basic validation and error handling
- Include basic JUnit test cases
- Implement a layered approach: Entity, Controller, Service, Repository

## Endpoints

- GET /users - Retrieve a list of all registered users
- GET /users/{userId} - Retrieve the details of a specific user
- POST /users - Register a new user to the contest
## Request Body
```json
{
   "username":"Harsh"
}
```
- PUT /users/{userId} - Update the score of a specific user
## Request Body
```json
{
   "score":97
}
```
- DELETE /users/{userId} - Deregister a specific user from the contest



## Setup

To run this application locally, follow these steps:

1. Clone this repository:

   ```bash
   git clone https://github.com/harsh8999/CoderHack.git
   ```

2. Build the application using Maven:
    ```bash
   mvnw clean package
   ```

3. Run the application:
    ```bash
    java -jar target/coderhack-0.0.1-SNAPSHOT.jar
    ```

Make sure you have MongoDB running on your local machine or update the application.properties file to point to your MongoDB instance.

## Testing
Run the JUnit test cases using:

    mvnw test

The tests include Mockito for mocking dependencies and verifying interactions between components.

## Postman Collection
https://elements.getpostman.com/redirect?entityId=7585977-91431c0d-2f04-429f-ba63-8bb8b9310765&entityType=collection

## License
Harsh Nayak