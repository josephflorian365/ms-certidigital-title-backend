FROM openjdk:11-jre-slim-buster
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} Title.jar
ENTRYPOINT ["java","-jar","/Title.jar"]
EXPOSE 8080
