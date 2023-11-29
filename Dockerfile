# Stage 1: Build stage
FROM openjdk:17-jdk AS build

WORKDIR /app

# Install Gradle and copy only necessary files
COPY build.gradle settings.gradle ./
COPY src/ ./src/

# Build the application
RUN chmod +x gradlew && ./gradlew build

# Stage 2: Final stage
FROM openjdk:17-jdk-slim

WORKDIR /app

EXPOSE 8080

# Copy the JAR from the build stage
COPY --from=build /app/build/libs/flightapp-1.jar app.jar

# Define the entry point
ENTRYPOINT ["java", "-jar", "app.jar"]
