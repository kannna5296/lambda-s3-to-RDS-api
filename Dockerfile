FROM openjdk:17-jdk-alpine

EXPOSE 8080

ARG JAR_FILE=presentation/build/libs/presentation.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]