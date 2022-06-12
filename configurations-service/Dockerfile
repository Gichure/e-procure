FROM eclipse-temurin:17-jdk-focal
LABEL maintainer="Paul Gichure"
VOLUME /tmp
ADD /target/configurations-service-1.0.0.jar configurations-service-1.0.0.jar
ENV JAVA_OPTS="-XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap  -XX:MaxRAMFraction=1 -XshowSettings:vm"
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/configurations-service-1.0.0.jar"]
