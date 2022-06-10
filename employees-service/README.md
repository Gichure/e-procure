# E-Procurement System Employees Service
The staff management service.

### Run
cd employees-service  
mvn clean spring-boot:run

### Build
cd employees-service  
mvn clean package

### Docker Image
docker build -t e-procure/employees-service .  

### Docker Run
docker run -d -p 8085:8085 e-procure/employees-service:latest  
