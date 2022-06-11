[![CI](https://circleci.com/gh/Gichure/e-procure/tree/main.svg?style=svg)](https://circleci.com/gh/Gichure/e-procure/tree/main)
[![Code Analysis](https://github.com/Gichure/e-procure/actions/workflows/codeql-analysis.yml/badge.svg?branch=main)](https://github.com/Gichure/e-procure/actions/workflows/codeql-analysis.yml)
[![Publishing Package](https://github.com/Gichure/e-procure/actions/workflows/maven-publish.yml/badge.svg?branch=main)](https://github.com/Gichure/e-procure/actions/workflows/maven-publish.yml)

# e-procure
E-Procurement System to meet the needs of automation in the internal procurement process of a company.  
## Overview
1.  The application has been developed using microservice approach.  
2.  We use git monorepo where all microservices are the modules in a single respository.
3.  Each microservice product-service and review-service can be built and run independently using Maven.
4.  Each microservice can build, test, run, dockerize, deploy & run independently using Docker, CircleCI and Kubernetes.

## Tools & Techologies
-  Spring Boot for Business Services
-  Microservices Architecture
-  Spring Cloud for MSA
-  MySQL for RDBMS
-  Camunda for BPMN
-  Mockito for Testing
-  Docker for Packaging and Deployment
-  Flyway for Database Versioning
-  Apache Kafka for Messaging
-  Keycloack for Authentication and Authorization
-  CircleCI for CI/CD
-  Swagger for API Documentation


## Modules
1.  Settings, Parameters and General Setups
2.  Employees/Staff Management
3.  Items/Inventory Management
4.  Purchase Requistion
5.  Purchase Order
6.  Vendor Management
7.  Bid Management
8.  Invoice Management
9.  Payment Processing
10.  Business Process Management(Workflow)

## Services
1.  [configurations-service](configurations-service/README.md)
2.  [discovery-service](discovery-service/README.md)
3.  [gateway-service](gateway-service/README.md)
4.  [setups-service](setups-service/README.md)
5.  [employees-service](employees-service/README.md)
6.  [workflow-service](workflow-service/README.md)
7.  [notifications-service](notifications-service/README.md)
8.  [inventory-service](inventory-service/README.md)
9.  [suppliers-service](suppliers-service/README.md)
10. [orders-service](orders-service/README.md)
11. [invoices-service](invoices-service/README.md)
12. [payments-service](payments-service/README.md)
13. [authentication-service](authentication-service/README.md)
14. [frontend-service](ui-service/README.md)

## Starting Up
Clone this repository.  
From the root folder, run mvn clean package  
Run docker compose up

## Postman Collection
You can access the postman collection [here]()  
### Process Flow
![E-Procure Process Flow](resources/images/process_flow.jpg)

#### Contributions
-  [Paul Gichure](https://linkedin.com/in/gichure). You can reach out at e-procure@gichure.me.ke

#### License
[MIT](LICENSE.md)

#### Issues Reporting
Issues are to be reported in [this format](.github/ISSUE_TEMPLATE/bug_report.md)

#### Disclaimer
This project is purely for learning purposes and thus it is subject to change without notice.  
Should you need a stable version,reach out at e-procure@gichure.me.ke or fork this repository. 
 I also do not offer support services as well.  
