# Use the official OpenJDK base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /usr/src/app

# Copy the pom.xml and source code into the container
COPY pom.xml ./
COPY src ./src


# Install Maven
RUN apt-get update && apt-get install -y maven

# Build the project and run tests
RUN mvn clean install

# Command to run the tests
CMD ["mvn", "test"]