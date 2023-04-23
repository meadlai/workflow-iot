# workflow-iot

this is a demostration repo for workflow and IoT, it chooses Camunda7 and ESP32 to build a mini-water-fountain.

## Build

    git clone https://github.com/meadlai/workflow-iot.git 
    
    ## start camunda workflow engine
    cd camunda
    mvn clean install
    mvn spring-boot:run

Open http://localhost:8080/

Login with user: demo

Password: demo

    ## start weather service
    cd weather
    mvn clean install
    mvn spring-boot:run

