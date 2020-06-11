# eMart

## FrontEnd ：Angular 9；
## Mid Tier：SpringCloud；
- Eureka
- Zuul
- Feign
- OAuth2
- Security
- Config


## Environment
- node-10
- jdk1.8
- MySQL Server 5.7.19
- maven3.X
- IntelliJ IDEA 
- VScode

```
FrontEnd Source code
    eMart/emart-frontend

BackEnd Source code
    eMart/emart-backend

Mid Tier Source code of all Microservices
    8000    emart-service
    8001    emart-buyer-service
    8002    emart-seller-service

    9001    emart-eureka-server
    9002    emart-zuul-service

Use Post Man tool to test each End Point of all Microservices
```

## Deploy

FrontEnd :

```
npm install
cd emart-frontend
npm install
npm start
```

Jenkinsfile:

    emart-backend/Jenkinsfile

URL :
```
    http://localhost:4200/
```
Local :
```
    docker run --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 -d mysql/mysql:5.7.19
```
