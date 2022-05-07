# E-Procurement System Setups Service
This service manages the system setups and configurations.

### Run
cd setups-service  
mvn clean spring-boot:run

### Build
cd setups-service  
mvn clean package

### Docker Image
docker build -t e-procure/setups-service .  

### Docker Run
docker run -d -p 8084:8084 -e "SPRING_PROFILES_ACTIVE=prod" e-procure/setups-service:latest  