# E-Procurement System Configurations Service
The configurations server service.

### Run
cd configurations-service  
mvn clean spring-boot:run

### Build
cd configurations-service  
mvn clean package

### Docker Image
docker build -t e-procure/configurations-service .  

### Docker Run
docker run -d -p 8888:8888 e-procure/configurations-service:latest  
