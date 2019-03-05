# EmployeePortalRestService
Rest Service using Spring 5.x, Hibernate 5.x, Java 8 and Hsqldb

## Setup 

To setup the project for review do the following:
1. Download the project.
2. Download <a href="https://maven.apache.org/download.cgi">apache maven</a>. 
3. Install  <a href="https://maven.apache.org/download.cgi">apache maven</a> 
4. Run command __mvn package__ to install the project dependencies.
5. Run command __mvn tomcat7:run-war__ in the root directory.

## REST API 
__ENDPOINTS__
1. Add Employee : http://localhost:8080/portal/employee/save
2. Get All Employees : http://localhost:8080/portal/employee/getAll
3. Find Employee by ID:http://localhost:8080/portal/employee/get/1
4. Sort API call :http://localhost:8080/portal/employee/filter?sortBy="filterWord"&sort="sortOrderKeyWord"

__filterWords__: name,date,salary

__sortOrderKeyWord__: asc,desc


### Post API call for Employee Details http://localhost:8080/portal/employee/save
__Input__ 
```
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
### Get API call to retrive all Employees http://localhost:8080/portal/employee/getAll

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

### Get API call for Employee by ID:http://localhost:8080/portal/employee/get/1

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

### Get API call to Sort Empployee List ID:http://localhost:8080/portal/employee/filter?sortBy=salary&sort=desc

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