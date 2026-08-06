# ============================
# Stage 1 - Build the Application
# ============================
FROM maven:3.9.11-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy pom.xml first
COPY pom.xml .

# Download Maven dependencies
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# ============================
# Stage 2 - Create Runtime Image
# ============================
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copy the JAR from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose application port
EXPOSE 8080

# Start the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]