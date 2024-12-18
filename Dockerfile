# Step 1: Use a base image with Java
FROM openjdk:17-jdk-slim

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the built JAR file into the container


# Step 4: Expose the application port (default Spring Boot port is 8080)
EXPOSE 8080

# Step 5: Specify the command to run the application

COPY target/number-service-0.0.1-SNAPSHOT.jar /app/number-service.jar
ENTRYPOINT ["java", "-jar", "number-service.jar"]
