COPY . .

# Give execute permissions to gradlew
RUN chmod +x gradlew

# Run the Gradle build
RUN ./gradlew build

FROM openjdk:17-jdk-slim

WORKDIR /app

EXPOSE 8080

# Correct the path in the COPY command
COPY --from=build /build/libs/flightapp-1.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
