# Stage 1: Build Stage
FROM ubuntu:latest AS build

# Update package lists and install OpenJDK
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y

# Set the working directory
WORKDIR /app

# Copy the entire project to the working directory
COPY . .

# Build the Spring Boot application
RUN ./gradlew build

# Stage 2: Production Stage
FROM openjdk:17-jdk-slim

# Set the working directory in the production stage
WORKDIR /app

# Expose the port that the application will run on
EXPOSE 8080

# Copy the built JAR file from the build stage
COPY --from=build /app/build/libs/flightapp-1.jar app.jar

# Specify the command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
