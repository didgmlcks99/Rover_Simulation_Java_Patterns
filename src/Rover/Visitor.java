package Rover;

public interface Visitor {
	public void visit(Wheel w);
	public void visit(Motor m);
	public void visit(SolarPanel s);
	public void visit(RobotArm r);
	public void visit(Camera c);
}
