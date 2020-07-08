# DIB Challenge
The assignment was to create REST API for retrieving a few beers from https://punkapi.com/documentation/v2, storing them
 in database and exposing a REST API for a user to manage the stored beers.
 
 ##Motivation
 In order to accomplish assignment main motivation was to write application in spring boot „spirit“.
 
 There are 5 packages:
 
 entities – data entity models, same as table in database
 
 dtos – data models for working data, JSON data model or application API data model
 
 services – transform one data model to other, JSON to entity data model or entity data model to API data model
 
 repositories – implement CRUD to actually work with database tables
 
 controllers – appropriate methods to handle the HTTP calls.
 
 ## API Calls
 ####Fill database up to 10 beers
 http://localhost:8080/api/beers/refill
 
 ####Get all beers:
 http://localhost:8080/api/beers
 
 ####Get beer by id:
 http://localhost:8080/api/beers/1
 
 ####Create beer:
 curl -i -H "Content-Type:application/json" -d '{"name":"The End Of History","description":"The End of History: The name derives from the famous work of philosopher Francis Fukuyama, this is to beer what democracy is to history. Complexity defined. Floral, grapefruit, caramel and cloves are intensified by boozy heat.","mash_temp":[65]}' http://localhost:8080/api/beers
 
 ####Delete beer:
 curl -X DELETE http://localhost:8080/api/beers/1

 
 
 
 
 