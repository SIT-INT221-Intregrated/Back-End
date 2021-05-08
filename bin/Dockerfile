FROM maven:3.8.1-jdk-11-slim AS build
COPY src /backend/src
COPY pom.xml /backend
WORKDIR /backend
RUN mvn clean install

FROM openjdk:11.0-slim
COPY --from=build /backend/target/integrated-backend-0.0.1-SNAPSHOT.jar integrated-backend-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","integrated-backend-0.0.1-SNAPSHOT.jar"]