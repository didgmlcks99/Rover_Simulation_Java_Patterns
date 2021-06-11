package Rover;

public class SimulateRover {
	
	// attach each parts to the rover
	public static RoverParts[] parts = {new Wheel(), new Motor(), new SolarPanel(), new RobotArm(), new Camera()};
	
	public static void start() {
		
		// create three visitors
		FirstVisitor check_rover = new FirstVisitor();
		SecondVisitor action_rover = new SecondVisitor();
		ThirdVisitor html_rover = new ThirdVisitor();
		
		// first visitor checking the rover
		System.out.println("The First Visitor for Checking Components");
		for(int i=0; i < parts.length; i++) {
			parts[i].accept(check_rover);
		}
		
		// second visitor responding to check results
		System.out.println("\nThe Second Visitor for Maintaing Components");
		for(int i=0; i < parts.length; i++) {
			parts[i].accept(action_rover);
		}
		
		// third visitor building HTML for simulation
		System.out.println("\nThe Third Visitor for Rover Movement");
		html_rover.begin();
		for(int i=0; i < parts.length; i++) {
			parts[i].accept(html_rover);
		}
		html_rover.end();
			
		// singleton pattern : start blackbox
		BlackboxSingleton.getInstance().print_results();;
	}
}
