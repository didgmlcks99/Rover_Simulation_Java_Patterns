package Rover;

public class SimulateRover {
	
	// attach each parts to the rover
	public static RoverParts[] parts = {new Wheel(), new Motor(), new RobotArm(), new Camera(), new SolarPanel()};
	
	public static void start() {
		
		// create three visitors
		FirstVisitor check_rover = new FirstVisitor();
		SecondVisitor action_rover = new SecondVisitor();
		ThirdVisitor html_rover = new ThirdVisitor();
		
//		// first visitor checking the rover
//		for(int i=0; i < parts.length; i++) {
//			parts[i].accept(check_rover);
//		}
//		
//		// second visitor responding to check results
//		for(int i=0; i < parts.length; i++) {
//			parts[i].accept(action_rover);
//		}
//		
//		// third visitor building HTML for simulation
//		for(int i=0; i < parts.length; i++) {
//			parts[i].accept(html_rover);
//		}
		
		System.out.println("The First Visitor for Checking Components");
		parts[0].accept(check_rover);
		System.out.println();
		
		System.out.println("The Second Visitor for Maintaing Components");
		parts[0].accept(action_rover);
		
		// singleton pattern : start blackbox
		BlackboxSingleton.getInstance().print_results();;
	}
}
