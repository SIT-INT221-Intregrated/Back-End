FROM maven:3.8.1-jdk-11-slim AS build
COPY src /workspace/src
COPY pom.xml /workspace
WORKDIR /workspace
RUN mvn clean install

FROM openjdk:11.0-slim
VOLUME /tmp
EXPOSE 3000
ARG JAR_FILE=target/ShoesWebsite-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]

# COPY --from=build /workspace/target/*.jar app.jar
# ENTRYPOINT ["java","-jar","app.jar"]