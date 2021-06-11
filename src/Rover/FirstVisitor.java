package Rover;

import java.util.Random;

public class FirstVisitor implements Visitor{

	@Override
	public void visit(Wheel w) {
		
		System.out.println("\n*** Start Checking Wheel ***\n");
		
		for(int i=0; i < w.wheels.length; i++) {
			int alarm = generate_rand();
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

		System.out.println("\n### Start Checking Motor ###\n");
		
		for(int i=0; i < m.motors.length; i++) {
			int alarm = generate_rand();
			System.out.println("Checking " + m.each_motor(i) + " Motor");
			if(alarm == 1) {
				String warn = "Weak Power to " + m.each_motor(i) + " Motor";
				System.out.println(">>>> Alarm: " + warn);
				BlackboxSingleton.getInstance().record_alarm(warn);
			}else {
				System.out.println("Power is OK");
			}
			m.add_alarm(alarm);
		}
		
	}

	@Override
	public void visit(SolarPanel s) {
		
		System.out.println("\n!!! Start Checking Solar Panel !!!\n");
		
		for(int i=0; i < s.panels.length; i++) {
			int alarm = generate_rand();
			System.out.println("Checking " + s.each_panel(i));
			if(alarm == 1) {
				String warn = "Low Electricity Generated to  " + s.each_panel(i);
				System.out.println(">>>> Alarm: " + warn);
				BlackboxSingleton.getInstance().record_alarm(warn);
			}else {
				System.out.println("Solar Panel is OK");
			}
			s.add_alarm(alarm);
		}
		
	}

	@Override
	public void visit(RobotArm a) {
		
		System.out.println("\n... Start Checking Robot Arm ...");
		System.out.println("Checking Robot Arm");
		
		for(int i=0; i < a.arms.length; i++) {
			int alarm = generate_rand();
			a.add_alarm(alarm);
		}
		
		int flag = -1;
		String warn = "";
		
		if(a.past_alarm(0) == 1 && a.past_alarm(1) == 1) {
			warn = "Both Front and Rear Arms Not Working Properly";
			flag = 0;
		}else if(a.past_alarm(0) == 1 && a.past_alarm(1) == 0) {
			warn = "Front Robot Arm Not Working Properly";
			flag = 1;
		}else if(a.past_alarm(0) == 0 && a.past_alarm(1) == 1) {
			warn = "Rear Robot Arm Not Working Properly";
			flag = 3;
		}
		
		if(flag == -1) {
			System.out.println("Robot Arm is OK");
		}else {
			System.out.println(".. Alarm: " + warn);
			BlackboxSingleton.getInstance().record_alarm(warn);
		}
		
	}

	@Override
	public void visit(Camera c) {
		// TODO Auto-generated method stub
		
	}
	
	public int generate_rand() {
		Random rand = new Random();
		int gen = rand.nextInt(2);
		return gen;
	}

}
