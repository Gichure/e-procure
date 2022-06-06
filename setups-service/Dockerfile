FROM eclipse-temurin:17-jdk-focal
MAINTAINER Paul Gichure
VOLUME /tmp
ADD /target/setups-service-1.0.0.jar setups-service-1.0.0.jar
ENV JAVA_OPTS="-XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap  -XX:MaxRAMFraction=1 -XshowSettings:vm "
ENTRYPOINT ["java $JAVA_OPTS","-Djava.security.egd=file:/dev/./urandom","-jar","/setups-service-1.0.0.jar"]
