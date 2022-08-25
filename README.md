# AloreHotelBooking-Api
It is a Hotel booking application created using Java SpringBoot.  
Features​ ​expected:
• Search hotels by city and date (to check availability), number of rooms required/number of travelers, search criteria might include number of stars  that a hotel has, facilities like WIFI, restaurant available, air conditioning, meals included etc. 
Show sorted hotels based on the rating score, relevance  or the cost of stay. • Show rating (out of 10) for a hotel and user comments/reviews. 
There might be filters like gender, residential city of the traveler or if not just the  overall rating.  
• Service to add/update hotel information in the system.  
• Service to add/update user information in the system.  
• Service for a user to add reviews for a hotel. A review will include rating and comments.  
• Delete information of a hotel, user or delete a review. You might have to think of the data associated with each hotel and user. 
All this information will be stored in an RDBMS like MySQL.

Demo Application was Deployed in Heroku server for Testing purpose and Swagger3 is implemeted for API Documentation.

Link: https://alore-hotelbooking.herokuapp.com/swagger-ui/index.html

Use the below credentials for DB verification:

Database Host : sql6.freesqldatabase.com
Database Name : sql6514878
Username : sql6514878
Password : jLged4IW2y

Steps to Setup:
1. Clone the application
https://github.com/JegaMax/AloreHotelBooking-Api.git

2. Create Mysql database
create database database_name

3. Change mysql host, username, password and database as per your mysql DB confiqurations

open src/main/resources/application.properties

change following details
spring.datasource.url
spring.datasource.username
spring.datasource.password

4. Build and run the app using maven

mvn package
java -jar target/hotelbooking-0.0.1-SNAPSHOT.jar
Alternatively, you can run the app without packaging it using -

mvn spring-boot:run
The app will start running at http://localhost:8080.

java -jar target/hotelbooking-0.0.1-SNAPSHOT.jar The procedure above will create a runnable JAR. You can also opt to build a classic WAR file instead. Logging output is displayed. The service should be up and running within a few seconds.

Test the application:

Now that the application is running, you can test it.
Either use postman tool or use sawgger ui for testing purpose.

Explore Rest APIs
This springboot app defines following CRUD APIs.
user-controller:
• POST
/api/users/add
 -Create a new User

• PATCH
/api/users/update/{userId}
 -Update a user by userId

• GET
/api/users/{userId}
 -Get user details by userId

• DELETE
/api/users/delete/{userId}
 -Delete a User by userId

review-controller:

• POST
/api/reviews/add
 -Create a new review for Hotel

• PATCH
/api/reviews/update/{reviewId}
 -Update a review by reviewId

• DELETE
/api/reviews/delete/{reviewId}
- Delete a review by reviewId

hotel-controller:

• POST
/api/hotels/add
Create a new Hotel

• PATCH
/api/hotels/update/{hotelId}
 -Update a hotel by it's id

• GET
/api/hotels
 -Get list of hotels (Ordered by rating in ascending order)

• GET
/api/hotels/{cityName}
 -Get list of hotels (Ordered by rating in ascending order)

• DELETE
/api/hotels/delete/{hotelId}
 -Delete a Hotel by its id
