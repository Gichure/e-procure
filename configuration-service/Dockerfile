FROM openjdk:8u111-jdk-alpine
MAINTAINER Paul Gichure
VOLUME /tmp
ADD /target/configurations-service-1.0.0.jar configurations-service-1.0.0.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/configurations-service-1.0.0.jar"]
