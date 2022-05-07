FROM openjdk:8u111-jdk-alpine
VOLUME /tmp
ADD /target/setups-service-1.0.0.jar setups-service-1.0.0.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/setups-service-1.0.0.jar"]