# microservices-testing

@Author Krzysztof Ziomek

Implementation is based on Spring Boot 1.3.2

## Purpose of this application is to exemplify:

1. How to test microservice API with Spring
2. How to stub external endpoint dependencies in integration tests.

This is extremely useful approach because we can create reliable end to end API test independent from external endpoints' availability.

## Run

1.Start microservice

    gradle bootRun
    
2.Test that service response is one book.
   
   curl -H "Content-Type:application/json" http://localhost:4000/central/api/v1/books
   
### What just happened?
BookService class aggregates books from two sources: internal BookRepository and external BranchLibrary endpoint.
Endpoint defined in BranchLibraryClient doesn't exists soexceptions comes from external service invocation.
Exception is catched in BookService and response of CentralLibrary API is list of internal books (Only one book in the list: Frank Herbert's book). 

### Test
1.Run tests in class CentralLibraryControllerIT

    gradle -Dtest.single=CentralLibraryControllerIT --info
    
### What just happened?
End to end API test is performed. 
Stub BranchLibraryMockController is invoked by BranchLibraryClient instead of external BranchLibrary endpoint.
 
In CentralLibraryControllerIT test application is started up and CentralLibraryController API is exposed on port 4000.
BranchLibraryMockController defines stub fo BranchLibrary API.
CentralLibraryClient defines client to CentralLibraryController API.
Configuration in test.properties overrides remote.api.branchlibrary.base-url to point BranchLibraryMockController instead of real external endpoint.
