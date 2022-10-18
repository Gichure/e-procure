# E-Procurement System Notifications Service
The notifications management service.

### Run
cd notifications-service  
mvn clean spring-boot:run

### Build
cd notifications-service  
mvn clean package

### Docker Image
docker build -t e-procure/notifications-service .  

### Docker Run
docker run -d -p 8085:8085 e-procure/notifications-service:latest  
