FROM maven:3.8.5-openjdk-21
WORKDIR /target/
COPY ./target/QuizMinds-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD ["java", "-jar", "QuizMinds-0.0.1-SNAPSHOT.jar"]