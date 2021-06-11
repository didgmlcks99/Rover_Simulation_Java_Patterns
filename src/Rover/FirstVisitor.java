package Rover;

import java.util.Random;

public class FirstVisitor implements Visitor{
	Random rand = new Random();

	@Override
	public void visit(Wheel w) {
		
		System.out.println();
		System.out.println("*** Start Checking Wheel ***");
		System.out.println();
		
		for(int i=0; i < w.wheels.length; i++) {
			int alarm = rand.nextInt(2);
			System.out.println("Checking " + w.each_wheel(i) + " Axle");
			if(alarm == 1) {
				String warn = "Mud and Dust on Wheel Axle of " + w.each_wheel(i) + " wheel";
				System.out.println(">> Alarm: " + warn);
				BlackboxSingleton.getInstance().record_alarm(warn);
			}else {
				System.out.println("Wheel Axle OK");
			}
			w.add_alarm(alarm);
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
	public void visit(RobotArm r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Camera c) {
		// TODO Auto-generated method stub
		
	}

}
