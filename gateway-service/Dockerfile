FROM openjdk:8u111-jdk-alpine
VOLUME /tmp
ADD /target/gateway-service-1.0.0.jar gateway-service-1.0.0.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/gateway-service-1.0.0.jar"]