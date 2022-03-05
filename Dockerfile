#FROM openjdk:11-jre-slim-buster
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} Title.jar
#ENTRYPOINT ["java","-jar","/Title.jar"]
#EXPOSE 8080
docker pull sonarqube:lts
docker run --name sonarqube -d -p 9000:9000 -p 9092:9092 -v sonarqube_home:/opt/sonarqube/data sonarqube:lts
docker start sonarqube
