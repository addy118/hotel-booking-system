# Hotel Booking System API

This is a Hotel Booking application built using Java Spring Boot. The application allows users to search, review, and manage hotel data, while providing a set of RESTful APIs for interaction. All data is stored in a relational database (RDBMS) like MySQL.

## Features:

### Search Hotels:
- Search hotels by city, check-in date, check-out date, number of rooms required, number of travelers, etc.
- Filters can include number of stars, facilities like Wi-Fi, restaurant availability, air conditioning, meals included, etc.
- Hotels will be displayed sorted by rating, relevance, or cost.

### Hotel Ratings and Reviews:
- Display ratings (out of 10) and user comments/reviews for hotels.

### User Filters:
- Filters can be applied based on gender, city of residence, or overall rating.

### Hotel and User Information Management:
- Services to add, update, and delete hotel and user information.

### Review Management:
- Allow users to add, update, and delete reviews for hotels.

### Database:
- All data is stored in an RDBMS like MySQL.

## Steps to Setup:

### 1. Clone the repository:
```bash
git clone https://github.com/your-username/hotel-booking-system.git
```
### 2. Create a MySQL database:
```lua
create database your_database_name;
```
### 3. Configure MySQL credentials:
Open ```src/main/resources/application.properties```
Update the following properties with your MySQL database credentials:
1. `spring.datasource.url`
2. `spring.datasource.username`
3. `spring.datasource.password`

### 4. Build and run the application using Maven:
To build the application into a JAR:
```perl
mvn package
java -jar target/hotel-booking-system-0.0.1-SNAPSHOT.jar
```
Alternatively, you can run the application without packaging it:
```arduino
mvn spring-boot:run
```
The application will be available at http://localhost:8080.

### 5. Verify the application:
Once the application is running, you can test it using Postman or the Swagger UI for API documentation and testing.
RESTful API Endpoints:

#### User Controller:
Create a new user:
`POST /api/users/add`

Update an existing user by userId:
`PATCH /api/users/update/{userId}`

Get details of a user by userId:
`GET /api/users/{userId}`

Delete a user by userId:
`DELETE /api/users/delete/{userId}`

#### Review Controller:
Add a new review for a hotel:
`POST /api/reviews/add`

Update a review by reviewId:
`PATCH /api/reviews/update/{reviewId}`

Delete a review by reviewId:
`DELETE /api/reviews/delete/{reviewId}`

#### Hotel Controller:
Add a new hotel:
`POST /api/hotels/add`

Update an existing hotel by hotelId:
`PATCH /api/hotels/update/{hotelId}`

Get a list of hotels, ordered by rating (ascending):
`GET /api/hotels`

Get a list of hotels in a specific city, ordered by rating (ascending):
`GET /api/hotels/{cityName}`

Delete a hotel by hotelId: 
`DELETE /api/hotels/delete/{hotelId}`

This API provides a solid foundation for hotel booking systems, allowing management of hotel data, user information, and reviews.
