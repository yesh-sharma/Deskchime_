FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /usr/src/app

# Copy the Selenium project files to the container
COPY . .

# Install Maven
RUN apt-get update && \
    apt-get install -y maven

# Run Maven to install dependencies
RUN mvn clean install

# Command to run your tests
CMD ["mvn", "test"]
