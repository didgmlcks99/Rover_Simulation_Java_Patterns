package Rover;

public class SecondVisitor implements Visitor{

	@Override
	public void visit(Wheel w) {
		
		System.out.println();
		System.out.println("*** Start Working Wheel ***");
		System.out.println();

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
		
		System.out.println();
		System.out.println("*** Start Working Motor ***");
		System.out.println();

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
