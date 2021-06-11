package Rover;

import java.util.Random;

public class SecondVisitor implements Visitor{

	@Override
	public void visit(Wheel w) {
		
		System.out.println("\n*** Start Working on Wheel ***\n");

		for(int i=0; i < w.wheels.length; i++) {
			System.out.println("Acting on " + w.each_wheel(i) + " Axle");
			if(w.past_alarm(i) == 1) {
				String act = "Removing Mud/Dust from " + w.each_wheel(i) + " Axle";
				System.out.println("--> Action: " + act);
				BlackboxSingleton.getInstance().record_action(act);
			}else {
				System.out.println("No Action on " + w.each_wheel(i) + " Axle");
			}
		}
		
	}

	@Override
	public void visit(Motor m) {
		
		System.out.println("\n### Start Working on Motor ###\n");

		for(int i=0; i < m.motors.length; i++) {
			System.out.println("Acting on " + m.each_motor(i) + " Motor");
			if(m.past_alarm(i) == 1) {
				String act = "Supply more power to " + m.each_motor(i) + " Motor";
				System.out.println("==> Action: " + act);
				BlackboxSingleton.getInstance().record_action(act);
			}else {
				System.out.println("No Action on " + m.each_motor(i) + " Motor");
			}
		}
		
	}

	@Override
	public void visit(SolarPanel s) {
		
		System.out.println("\n!!! Start Working on Solar Panel !!!\n");
		
		SolarPanelStock stock = new SolarPanelStock();

		for(int i=0; i < s.panels.length; i++) {
			System.out.println("Acting on " + s.each_panel(i));
			if(s.past_alarm(i) == 1) {
				String act = "repairing " + s.each_panel(i);
				System.out.println("==> Action: " + act);
				
				Random rand = new Random();
				int kw = ((rand.nextInt(7) + 20) / 2) * 2;
				
				stock.repairPanel(kw, s.each_panel(i));
			}else {
				System.out.println("No Action on " + s.each_panel(i));
			}
		}
		
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
