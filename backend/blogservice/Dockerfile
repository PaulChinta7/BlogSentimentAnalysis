FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/blogservice-1.0-SNAPSHOT.jar myapp.jar

ENTRYPOINT ["java", "-jar", "myapp.jar"]