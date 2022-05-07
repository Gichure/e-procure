FROM openjdk:8u111-jdk-alpine
VOLUME /tmp
ADD /target/workflow-service-1.0.0.jar workflow-service-1.0.0.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/workflow-service-1.0.0.jar"]