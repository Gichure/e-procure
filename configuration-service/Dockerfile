FROM eclipse-temurin:17-jdk-focal
MAINTAINER Paul Gichure
VOLUME /tmp
ADD /target/configurations-service-1.0.0.jar configurations-service-1.0.0.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/configurations-service-1.0.0.jar"]
