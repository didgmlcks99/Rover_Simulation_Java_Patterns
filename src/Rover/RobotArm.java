package Rover;

import java.util.ArrayList;

public class RobotArm implements RoverParts{
	public String[] arms = {"Front Robot Arm", "Rear Robot Arm"};
	private ArrayList<Integer> alarm = new ArrayList<Integer>();
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	public String each_arm(int which_arm) {
		return arms[which_arm];
	}
	
	public void add_alarm(int alarm) {
		this.alarm.add(alarm);
	}
	
	public int past_alarm(int which_arm) {
		return this.alarm.get(which_arm);
	}

}
