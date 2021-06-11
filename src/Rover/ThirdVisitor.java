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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(SolarPanel s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(RobotArm a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Camera c) {
		// TODO Auto-generated method stub
		
	}
	
	public int generate_rand(int cases) {
		Random rand = new Random();
		int gen = rand.nextInt(cases);
		return gen;
	}

}
