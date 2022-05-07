# E-Procurement System Workflow Service
This service handles the business process automation.

### Run
cd workflow-service  
mvn clean spring-boot:run

### Build
cd workflow-service  
mvn clean package

### Docker Image
docker build -t e-procure/workflow-service .  

### Docker Run
docker run -d -p 8083:8083 -e "SPRING_PROFILES_ACTIVE=prod" e-procure/workflow-service:latest  