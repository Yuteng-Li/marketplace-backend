

# Build using maven
FROM maven:3.8.6-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean -DskipTests package

# Package actual jar
FROM openjdk:11-jre-slim
ENV ARTIFACT_NAME=marketplace-backend.jar
COPY --from=build /home/app/target/*.jar ./
EXPOSE 8080
ENTRYPOINT  [java -jar ${ARTIFACT_NAME} ]

