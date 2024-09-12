#### Project structure 

    Mobile         
    ├── src
    │   ├── main  
    │   │  ├── utils   
    │   │  │   ├── android 
    │   │  │   ├── common 
    │   │  │   └── ios
    │   │  ├── drivers  
    │   │  │   ├── android 
    │   │  │   └── ios
    │   │  └── pages   
    │   │      ├── android 
    │   │      └── ios
    │   └── test 
    │       ├── android 
    │       └── ios
    └── pom.xml - Configuration and dependencies

## run iOS tests
 mvn clean test -Dtest=RunIOSTest  

 ## run Android tests
 mvn clean test -Dtest=RunAndroidTest  

 ## run all tests
  mvn clean test