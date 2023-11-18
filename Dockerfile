# Stage 1: Build stage
FROM ubuntu:latest AS build

# Install OpenJDK and Gradle
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk && \
    apt-get install -y gradle

# Set the working directory
WORKDIR /app

# Copy the source code into the container
COPY . .

# Give execute permissions to gradlew
RUN chmod +x ./gradlew

# Run the Gradle build
RUN ./gradlew build

# Stage 2: Final stage
FROM openjdk:17-jdk-slim

# Set the working directory in the final image
WORKDIR /app

# Expose the application port
EXPOSE 8080

# Copy the JAR from the build stage to the final image
COPY --from=build /app/build/libs/flightapp-1.jar app.jar

# Define the entry point for the container
ENTRYPOINT ["java", "-jar", "app.jar"]
