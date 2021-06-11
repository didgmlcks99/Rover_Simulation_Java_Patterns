package Rover;

import java.util.ArrayList;
import java.util.Random;

public class ThirdVisitor implements Visitor{
	HTMLBuilder htmlbuilder = new HTMLBuilder();
	Director director = new Director(htmlbuilder);
	
	public void begin() {
		System.out.println("\nOperation History Being Recorded in HTML file");
		director.constructTitle("Rover Running");
	}
	
	public void end() {
		director.endTest();
		director.result();
	}

	@Override
	public void visit(Wheel w) {
		String run = "Each Wheel Turns Adapting to Terrain State";
		director.running(run);
		
		for(int i=0; i < w.wheels.length; i++) {
			ArrayList<String> turning = new ArrayList<String>();
			turning.add("Turning " + w.each_wheel(i) + " wheel");
			
			int state = generate_rand(3);
			if(state == 0) {
				turning.add("Pebble Ground --> Enlarge " + w.each_wheel(i) + " Wheel Thread");
			}else if(state == 1) {
				turning.add("Mushy Ground --> Widen " + w.each_wheel(i) + " Wheel Width");
			}else if(state == 2) {
				turning.add("Slipper Ground --> Extrude Spike from " + w.each_wheel(i) + " Wheel Shoe");
			}
			director.acting(turning);
		}
	}

	@Override
	public void visit(Motor m) {
		String run = "Each Motor Controls Power Consumption";
		director.running(run);
		
		for(int i=0; i < m.motors.length; i++) {
			ArrayList<String> control = new ArrayList<String>();
			control.add("Control of " + m.each_motor(i) + " Motor");
			
			int state = generate_rand(3);
			if(state == 0) {
				control.add("RMP Increased --> Decrease Power to " + m.each_motor(i) + " Motor");
			}else if(state == 1) {
				control.add("Constant RMP --> Keep the Same Power to " + m.each_motor(i) + " Motor");
			}else if(state == 2) {
				control.add("RMP Decreased --> Increase Power to " + m.each_motor(i) + " Motor");
			}
			director.acting(control);
		}
		
	}

	@Override
	public void visit(SolarPanel s) {
		String run = "Solar Panel Generating Electricity";
		director.running(run);
		
		for(int i=0; i < s.panels.length; i++) {
			ArrayList<String> generate = new ArrayList<String>();
			generate.add(s.each_panel(i) + " Generating Electricity...");
			int kw = generate_rand(10) + 10;
			generate.add("Charging " + kw + "KW");
			
			director.acting(generate);
		}
	}

	@Override
	public void visit(RobotArm a) {
		String run = "Robot Arm in Operation";
		director.running(run);
		
		ArrayList<String> operation = new ArrayList<String>();
		int cases = generate_rand(3);
		if(cases == 0) {
			operation.add(a.each_arm(0) + " in Fine Calibration");
		}else if(cases == 1) {
			operation.add(a.each_arm(1) + " in Fine Calibration");
		}else if(cases == 2) {
			operation.add("Both Front and Rear Robot Arms in Fine Calibration");
		}
		director.acting(operation);
	}

	@Override
	public void visit(Camera c) {
		String run = "Camera in Operation";
		director.running(run);
		
		ArrayList<String> operation = new ArrayList<String>();
		int cases = generate_rand(3);
		if(cases == 0) {
			operation.add("Camera Taking Pictures of 180 degrees View");
		}else if(cases == 1) {
			operation.add("Camera Taking Pictures of 270 degrees View");
		}else if(cases == 2) {
			operation.add("Camera Taking Pictures of 360 degrees View");
		}
		director.acting(operation);
	}
	
	public int generate_rand(int cases) {
		Random rand = new Random();
		int gen = rand.nextInt(cases);
		return gen;
	}

}
