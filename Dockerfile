FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .

RUN apt-get update && apt-get install -y dos2unix && dos2unix gradlew
RUN find ./ -name "*.java" | xargs dos2unix
RUN ./gradlew --version
RUN ./gradlew build --stacktrace

FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=build /build/libs/flightapp-1.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
