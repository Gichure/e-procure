# E-Procurement System Discovery Service
The services discover and registry service

### Run
cd discovery-service  
mvn clean spring-boot:run

### Build
cd discovery-service  
mvn clean package

### Docker Image
docker build -t e-procure/discovery-service .  

### Docker Run
docker run -d -p 8761:8761 -e "SPRING_PROFILES_ACTIVE=prod" e-procure/discovery-service:latest  