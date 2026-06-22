FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY target/*.jar app.jar
RUN addgroup -S spring && adduser -S spring -G spring
USER spring
ENTRYPOINT ["java", "-jar", "app.jar"]
