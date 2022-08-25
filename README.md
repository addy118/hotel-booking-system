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

Running the application locally:
There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the com.hotelbooking.HotelBookingApplication class from your IDE.

Alternatively you can use the Spring Boot Maven plugin like so:

mvn spring-boot:run

Build an executable JAR:

You can run the application from the command line with Maven. Or you can build a single executable JAR file that contains all the necessary dependencies, classes, and resources, and run that. This makes it easy to ship, version, and deploy the service as an application throughout the development lifecycle, across different environments, and so forth.

If you are using Maven, you can run the application using ./mvnw spring-boot:run. Or you can build the JAR file with ./mvnw clean package. Then you can run the JAR file:

java -jar target/hotelbooking-0.0.1-SNAPSHOT.jar The procedure above will create a runnable JAR. You can also opt to build a classic WAR file instead. Logging output is displayed. The service should be up and running within a few seconds.

Test the application:

Now that the application is running, you can test it.
Either use postman tool or use sawgger ui for testing purpose.
