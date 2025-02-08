FROM bellsoft/liberica-openjdk-alpine:17-cds
ARG JAR_FILE=target/spring-ms-client-backend-*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 10600
ENTRYPOINT ["java", "-jar", "/app.jar"]