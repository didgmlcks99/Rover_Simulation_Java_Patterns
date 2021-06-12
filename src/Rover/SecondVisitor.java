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
				
				// flyweight pattern : request to repair panel 
				stock.repairPanel(kw, s.each_panel(i));
			}else {
				System.out.println("No Action on " + s.each_panel(i));
			}
		}
		
	}

	@Override
	public void visit(RobotArm a) {
		
		System.out.println("\n... Start Working on Robot Arm ...");
		
		ArmManager manager = new ArmManager();
		ArmCloned frontArm = new ArmCloned("Front Arm Clone");
		ArmCloned rearArm = new ArmCloned("Rear Arm Clone");
		
		// prototype patter : register each arm through manager
		manager.register(a.each_arm(0), frontArm);
		manager.register(a.each_arm(1), rearArm);
		
		// clone and repair arm according to results
		if(a.past_alarm(0) == 1 && a.past_alarm(1) == 1) {
			System.out.println("Action on Robot Arm");
			System.out.println("==> Action: Front and Rear Robot Arms Replaced by Prototype Arm Clones");
			ArmProduct f_arm = manager.create(a.each_arm(0));
			f_arm.repairArm(a.each_arm(0));
			ArmProduct r_arm = manager.create(a.each_arm(1));
			r_arm.repairArm(a.each_arm(1));
		}else if(a.past_alarm(0) == 1 && a.past_alarm(1) == 0) {
			System.out.println("Action on Robot Arm");
			System.out.println("==> Action: " + a.each_arm(0) + " Replaced by Prototype Front Arm Clone");
			ArmProduct f_arm = manager.create(a.each_arm(0));
			f_arm.repairArm(a.each_arm(0));
		}else if(a.past_alarm(0) == 0 && a.past_alarm(1) == 1) {
			System.out.println("Action on Robot Arm");
			System.out.println("==> Action: " + a.each_arm(1) + " Replaced by Prototype Rear Arm Clone");
			ArmProduct r_arm = manager.create(a.each_arm(1));
			r_arm.repairArm(a.each_arm(1));
		}else {
			System.out.println("No Action on Robot Arm");
		}
	}

	@Override
	public void visit(Camera c) {
		
		System.out.println("\n... Start Working on Camera ...");
		
		if(c.past_alarm() == 1) {
			String act = "Repair Camera";
			System.out.println("==> Action: " + act);
			BlackboxSingleton.getInstance().record_action(act);
		}else {
			System.out.println("No Action on Camera");
		}
		
	}

}
