FROM bellsoft/liberica-openjdk-alpine:17-cds
ARG JAR_FILE=target/spring-boot-admin-*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 10100
ENTRYPOINT ["java", "-jar", "/app.jar"]