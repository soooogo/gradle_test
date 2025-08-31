# Use the official OpenJDK 17 image as the base image
FROM eclipse-temurin:17-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the Gradle wrapper files
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

# Make the gradlew script executable
RUN chmod +x gradlew

RUN ./gradlew dependencies

# Copy the source code
COPY src src

# Build the application
RUN ./gradlew build

# Create a new stage for the runtime
FROM eclipse-temurin:17-jre

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=0 /app/build/libs/*.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Set environment variables
ENV JAVA_OPTS="-Xmx512m -Xms256m"

# Run the application
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
