FROM openjdk:17-jdk-alpine

EXPOSE 8080

ENV TZ Asia/Tokyo

#HEALTHCHECKでCurlする用
RUN apt-get update \
 && apt-get install -y --no-install-recommends curl jq \
 && rm -rf /var/lib/apt/lists/*

ARG JAR_FILE=presentation/build/libs/presentation.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]

HEALTHCHECK --interval=5s --timeout=3s CMD curl --request GET http://localhost:8080/health_check || exit 1