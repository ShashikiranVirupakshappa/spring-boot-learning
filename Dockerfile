FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY  target/spring-boot-learning-0.0.1-SNAPSHOT.jar spring-boot-learning-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "spring-boot-learning-0.0.1-SNAPSHOT.jar"]
