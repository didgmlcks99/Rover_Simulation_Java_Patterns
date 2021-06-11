# Rover_Simulation_Java_Patterns
## introduction
### This program is a simulation for the mars rover. Rover has deferent part (components) attached in which have its own functions and need some help in different environmental situations.Different functions are implemented through various object oriented patterns.
+ Top Down Structure : Main simply runs the rover simulation. Simulate Rover creates 3 visitors. Uses one black box to record situations.
+ Singleton Pattern : Blackbox object is formed as a singleton pattern. Only one object is made and no other object can be made.
+ Visitor Pattern : Each visitor is visits the parts of the rover. Each parts accepts visitor so that the parts can be checked and given actions to handle the different situations.
+ Flyweight Pattern : Second visitor uses the flyweight pattern to replace troublesome solar panels. If there are no solar panels created for a panel with specific KW, it creates a new panel. However, when there exists a requested panel in the solar panel stock, new object is not created.
+ Prototype Pattern : Second visitor uses the prototype pattern to clone robot arms. Each front and rear arm is registered by the manager. Then when requested, the requested arms are cloned for the rover.
+ Builder Pattern : Third visitor uses the builder pattern to build an html file for running rover. This visitor gives request to the director, then the director sends the request to the HTML builder in which implements the function of a builder. Through these steps, html file is build with differents results in specific cases for each part (components) of the rover.
