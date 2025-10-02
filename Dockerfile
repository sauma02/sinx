FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/snixtennis-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} snixtennis.jar
ENV SPRING_PROFILES_ACTIVE=docker
EXPOSe 9500
ENTRYPOINT ["java", "-jar", "snixtennis.jar"]
