FROM openjdk:11-jre-slim

COPY target/*.jar /usr/local/lib/usermgmt-service.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/usr/local/lib/usermgmt-service.jar"]
