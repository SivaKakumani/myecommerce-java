# Use official OpenJDK image as base image
FROM openjdk:22

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container at /app
COPY target/demo-0.0.1-SNAPSHOT.jar /app/demo.jar

# Command to run the JAR file
CMD ["java", "-jar", "demo.jar"]
