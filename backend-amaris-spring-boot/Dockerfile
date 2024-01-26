# Use an official Maven image as the base image
FROM maven:3.8.4-openjdk-11-slim AS build
# Set the working directory in the container
WORKDIR /app
# Copy the pom.xml and the project files to the container
COPY backend-amaris-spring-boot/pom.xml .
COPY backend-amaris-spring-boot/src ./src

FROM build AS publish
# Build the application using Maven
RUN mvn clean package -DskipTests
# Use an official OpenJDK image as the base image
FROM openjdk:11-jre-slim AS final
# Set the working directory in the container
WORKDIR /app
# Copy the built JAR file from the previous stage to the container
COPY --from=publish /app/target/spring-boot-amaris-1.0.1-SNAPSHOT.jar .
# Set the command to run the application
CMD ["java", "-jar", "spring-boot-amaris-1.0.1-SNAPSHOT.jar"]