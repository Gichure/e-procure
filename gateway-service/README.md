# E-Procurement System Gateway Service
The API Gateway

### Run
cd gateway-service  
mvn clean spring-boot:run

### Build
cd gateway-service  
mvn clean package

### Docker Image
docker build -t e-procure/gateway-service .  

### Docker Run
docker run -d -p 8081:8081 -e "SPRING_PROFILES_ACTIVE=prod" e-procure/gateway-service:latest  