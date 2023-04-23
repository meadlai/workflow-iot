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
    
Get today weather information: http://localhost:9090/weather/today

Set Sunny: http://localhost:9090/weather/set/1

Set Rain: http://localhost:9090/weather/set/0
    
    
## Deploy the workflow

Download the modeler: https://camunda.com/platform/modeler/

Open the BPMN diagram: IoT_Control.bpmn

Deploy it

## Assemble the BoM

Delay: +5V, GND, Signal

The Signal should connect to GPIO-13

![ESP32](/repository/assets/employee.png?raw=true "ESP32 GPIO")

Connect the pump power.

## Deploy the ESP32

    cd esp32
    copy the python files
    
    - IoT_Main.py
    - switch_on.py
    - switch_off.py



