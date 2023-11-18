# Use the official OpenJDK base image with Alpine Linux
FROM ubuntu:latest AS build

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file into the container at /app
COPY build/libs/flightapp-1.jar /app/app.jar

# Expose the port that the application will run on
EXPOSE 8080

# Specify the command to run the application
CMD ["java", "-jar", "app.jar"]
