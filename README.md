# paulnevilleChallenge2
Software Engineering Process and Tools COSC 2299 /2428  Process &amp; Tools Challenge 2

## Microservices – Git – Docker-CI
Scenario and requirements: 
Assume we have an online Fund Management Service, and the main business 
function is “account management”. Therefore, we want to create two 
Microservices that can create, update, delete, and read persons and their accounts. 
We also want to keep our code on Github and use Dev branch for implementation 
and release our final version through Main branch. For implementing each 
feature, we can use a feature branch that will be merged into Dev branch when 
the feature is ready. 
Later we want to dockerise both services and dockerise our local database. So we 
can run them locally on different ports and being able to test by postman.  
Writing three unit-tests per services for controllers.  
Finally, we want to build, run and test our product through Github action CI ( with 
db) 

Important: Database must be local, (not on cloud), and it is strictly MySQL for
marking purpose.

Your application, for each service should have these packages under main package:
- controller 
- dao ( you may add separate package as services) 
- exception 
- model

You need to have two services and therefore two apps that includes two end-points:

## Person ##
http://localhost:8080/person **POST** - **Create Person**

{
  "id": 01,
  "name": "John Smith",
  "address": "10 Albert St, Melbourne",
  "postcode": "3000",
  "age": "25",
  "job": "Engineer",
  "email": "js@email.com",
  "phoneNumber": "03234654"
}

http://localhost:8080/persons **GET**, - **Get All Persons**

http://localhost:8080/persons/{id} **GET**, - **Get Person By Id**

http://localhost:8080/persons/{id} **PUT**, - **Update Person By Id**

http://localhost:8080/persons/{id} **DELETE**, - **Delete Person By Id**


## Account ##
http://localhost:8080/account **POST** - **Create Account**

{
  "id": 01,
  "accountType": "Term Investment",
  "accountNumber": "23456789",
  "accountName": "J Smith",
  "balance": "300",
  "date": "2022-10-10"
}

http://localhost:8080/accounts **GET**, - **Get All Account**

http://localhost:8080/accounts/{id} **GET**, - **Get Account By Id**

http://localhost:8080/accounts/{id} **PUT**, - **Update Account By Id**

http://localhost:8080/accounts/{id} **DELETE**, - **Delete Account By Id**
