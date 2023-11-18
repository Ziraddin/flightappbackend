FROM ubuntu:latest AS build

RUN apt-get update && \
    apt-get install -y openjdk-17-jdk && \
    apt-get install -y gradle

WORKDIR /app

COPY . .

# Give execute permissions to gradlew
RUN chmod +x ./gradlew

# Run the Gradle build
RUN ./gradlew build

FROM openjdk:17-jdk-slim

WORKDIR /app

EXPOSE 8080

# Copy the JAR from the build stage to the final image
COPY --from=build /build/libs/flightapp-1.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
