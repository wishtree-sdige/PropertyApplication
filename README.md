# PropertyApplication
## Description

This Application provides easy to use and though configurable API Key authentication for your Spring Boot project. 

## General info
>Short step by infromation about backend functionality

>First checking the server in spring tool suite as this is the entry point to Spring Boot application and runs embedded tomcat.
> Creating the rest API (CREATE, UPDATE,READ,DELETE) in controller with the help of repository and service.

* CREATE API- For storing the property information in database.
* UPDATE API- For updating the fields of property class.
* DISPLAY API- Showing all the added property and its specific information.
## Running the Example
Follow the steps below to run the example:

1. Ensure you have a running MYSQL instance at `localhost:3306`.

2. Run the as java application in eclipse.
        
3. Run the following command to send a request to the secure endpoint:

        curl -v --header "API-KEY: propertyInfo123" http://localhost:8080/api/approve?id=1
        
    If successful, you will receive an `HTTP 200 OK` response.
    
4. Run the following command to send a request to the non secure endpoint:

        curl -v http://localhost:8080/api/create
        
    You will receive an `HTTP 401 UnAutorised` response because you have not supplied a valid API key.
    
5. Run the following command to send a request to the secure endpoint with an API key:

       curl --location --request GET 'http://localhost:8080/api/search?searchBy=Rudra' \
--header 'API-KEY: propertyInfo123'
        
    If successful, you will now receive an `HTTP 200 OK` response because you have supplied a valid API key.



### coding style 
Code Formatter - eclipse-java-google-style.xml
Static code analyzer - sonarLint


## Deployment

## Built With

To build maven in dev environment .
mvn clean install -Pdev

To build maven in stagging environment.
mvn clean install -Pstaging

To build maven in production environment.
mvn clean install -Pprod



