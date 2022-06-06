FROM eclipse-temurin:17-jdk-focal
VOLUME /tmp
ADD /target/employees-service-1.0.0.jar employees-service-1.0.0.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/employees-service-1.0.0.jar"]
