FROM openjdk:21
COPY /target/*.jar app.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "/app.jar"]