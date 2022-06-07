FROM eclipse-temurin:17-jdk-focal
MAINTAINER Paul Gichure
VOLUME /tmp
ADD /target/gateway-service-1.0.0.jar gateway-service-1.0.0.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/gateway-service-1.0.0.jar"]
