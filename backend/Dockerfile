# Use a minimal base image with Java 17
FROM eclipse-temurin:17-jdk-alpine

# Create a directory for the app
WORKDIR /app

# Copy the jar file from the Maven build into the container
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 (Spring Boot's default)
EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
