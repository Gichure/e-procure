FROM openjdk:8u111-jdk-alpine
VOLUME /tmp
ADD /target/discovery-service-1.0.0.jar discovery-service-1.0.0.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/discovery-service-1.0.0.jar"]