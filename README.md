# Rover_Simulation_Java_Patterns
![bigpic](https://cdn.pixabay.com/photo/2012/11/28/09/08/mars-67522_1280.jpg)

<br/><br/>

## Introduction
### This program is a simulation for the mars rover. Rover has deferent part (components) attached in which have its own functions and need some help in different environmental situations.Different functions are implemented through various object oriented patterns.

<br/><br/>

## User's Manual (compile and run)
### /src/Rover/Main.java
#### 1. javac Main.java
#### 2. java Main

<br/><br/>

## Pattern & Structure
+ Top Down Structure
    + Main simply runs the rover simulation. Simulate Rover creates 3 visitors. Uses one black box to record situations.

<br/>

![topdown](https://raw.githubusercontent.com/didgmlcks99/Rover_Simulation_Java_Patterns/main/UML_pics/top_down_structure_UML.JPG)
![simulator](https://raw.githubusercontent.com/didgmlcks99/Rover_Simulation_Java_Patterns/main/UML_pics/Simulator_Rover.JPG)
    
<br/><br/>

+ Singleton Pattern
    + Blackbox object is formed as a singleton pattern. Only one object is made and no other object can be made.

<br/>

![singleton](https://raw.githubusercontent.com/didgmlcks99/Rover_Simulation_Java_Patterns/main/UML_pics/singeleton_pattern.JPG)

<br/><br/>

+ Visitor Pattern
    + Each visitor is visits the parts of the rover. Each parts accepts visitor so that the parts can be checked and given actions to handle the different situations.

<br/>

![visitor](https://raw.githubusercontent.com/didgmlcks99/Rover_Simulation_Java_Patterns/main/UML_pics/visitor_pattern.JPG)

<br/><br/>

+ Flyweight Pattern
    + Second visitor uses the flyweight pattern to replace troublesome solar panels. If there are no solar panels created for a panel with specific KW, it creates a new panel. However, when there exists a requested panel in the solar panel stock, new object is not created.

<br/>

![flyweight](https://raw.githubusercontent.com/didgmlcks99/Rover_Simulation_Java_Patterns/main/UML_pics/flyweight_pattern.JPG)

<br/><br/>

+ Prototype Pattern
    + Second visitor uses the prototype pattern to clone robot arms. Each front and rear arm is registered by the manager. Then when requested, the requested arms are cloned for the rover.

<br/>

![prototype](https://raw.githubusercontent.com/didgmlcks99/Rover_Simulation_Java_Patterns/main/UML_pics/prototype_pattern.JPG)

<br/><br/>

+ Builder Pattern
    + Third visitor uses the builder pattern to build an html file for running rover. This visitor gives request to the director, then the director sends the request to the HTML builder in which implements the function of a builder. Through these steps, html file is build with differents results in specific cases for each part (components) of the rover.

<br/>

![builder](https://raw.githubusercontent.com/didgmlcks99/Rover_Simulation_Java_Patterns/main/UML_pics/builder_pattern.JPG)
