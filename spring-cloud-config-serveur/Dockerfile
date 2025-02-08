FROM bellsoft/liberica-openjdk-alpine:17-cds
ARG JAR_FILE=target/spring-cloud-config-serveur-*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 10800
ENTRYPOINT ["java", "-Dspring.profiles.active=default", "-jar", "/app.jar"]