# anagram solver

Requirements
 - Java 11 or higher
 - This is a Maven project
 
 To build:  
 ```mvn clean install```  
 (This will also execute the Spock tests.)
 
 To execute:  
 ```java -jar target/anagram-solver-1.0-SNAPSHOT.jar [Path to file]```  
 In resources there's a file that can be used for testing:  
 ```java -jar target/anagram-solver-1.0-SNAPSHOT.jar src/test/resources/ordbok-utf8.txt```
