# EmployeePortalRestService
Rest Service using Spring 5.x, Hibernate 5.x, Java 8 and Hsqldb

## Setup 

To setup the project for review do the following:
1. Download the project.
2. Install  <a href="https://www.mkyong.com/maven/how-to-install-maven-in-windows/">apache maven</a> 
3. Run command __mvn package__ to install the project dependencies.
4. Run command __mvn tomcat7:run-war__ .
5. Project <a href="https://github.com/girishkathireddy/EmployeePortalRestService/tree/master/src/main/resources">Sequence diagram and UML diagrams </a> 

## REST API 
__ENDPOINTS__
1. Add Employee : http://localhost:8080/portal/employee/save
2. Get All Employees : http://localhost:8080/portal/employee/getAll
3. Find Employee by ID:http://localhost:8080/portal/employee/get/1
4. Sort API call :http://localhost:8080/portal/employee/filter?sortBy="filterWord"&sort="sortOrderKeyWord"

__filterWords__: name,date,salary

__sortOrderKeyWord__: asc,desc


### Post API call for Employee Details 
__Input__ 
```
URL: http://localhost:8080/portal/employee/save
 {
    "firstName":"Albert",
    "lastName":"Einstein",
    "email":"emc2@gmail.com",
    "hireDate":"2000-01-10",
    "salary":1000,
    "address":"1049 W 49th Street",
    "zipcode":"23508",
    "phoneNumber":"757-123-2356",
    "title":"Scientist"
 }
```
__Response__
```
{"Data saved"}
```
### Get API call to retrive all Employees 
__Input__ 
```
POSTMAN API get Call :http://localhost:8080/portal/employee/getAll
```
__Response__
```
[
    {
        "firstName": "Albert",
        "lastName": "Einstein",
        "email": "emc2@gmail.com",
        "salary": 1000,
        "hireDate": 947462400000,
        "id": 1,
        "address": "1049 W 49th Street",
        "zipcode": "23508",
        "phoneNumber": "757-123-2356",
        "title": "Scientist"
    },
    {
        "firstName": "Blaise",
        "lastName": "Pascal",
        "email": "pascal@gmail.com",
        "salary": 100,
        "hireDate": 979084800000,
        "id": 2,
        "address": "1048 W 49th Street",
        "zipcode": "23508",
        "phoneNumber": "757-123-2356",
        "title": "Scientist"
    }
]
```

### Get API call for Employee by ID
__Input__ 
```
POSTMAN API get Call :http://localhost:8080/portal/employee/get/1
```
__Response__
```
 {	
    "firstName":"Blaise",
    "lastName":"Pascal",
    "email":"pascal@gmail.com",
    "hireDate":"2001-01-10",
    "salary":100,
    "address":"1048 W 49th Street",
    "zipcode":"23508",
    "phoneNumber":"757-123-2356",
    "title":"Scientist"
 }
```

### Get API call to Sort Employee List
__Input__ 
```
POSTMAN API get Call :http://localhost:8080/portal/employee/filter?sortBy=salary&sort=desc
```
__Response__
```
[
    {
        "firstName": "Albert",
        "lastName": "Einstein",
        "email": "emc2@gmail.com",
        "salary": 1000,
        "hireDate": 947462400000,
        "id": 1,
        "address": "1049 W 49th Street",
        "zipcode": "23508",
        "phoneNumber": "757-123-2356",
        "title": "Scientist"
    },
    {
        "firstName": "Blaise",
        "lastName": "Pascal",
        "email": "pascal@gmail.com",
        "salary": 100,
        "hireDate": 979084800000,
        "id": 2,
        "address": "1048 W 49th Street",
        "zipcode": "23508",
        "phoneNumber": "757-123-2356",
        "title": "Scientist"
    }
]
```
