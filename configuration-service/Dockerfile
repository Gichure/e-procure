FROM openjdk:8u111-jdk-alpine
VOLUME /tmp
ADD /target/penkiba-ifsas-1.0.0.jar penkiba.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/penkiba.jar"]