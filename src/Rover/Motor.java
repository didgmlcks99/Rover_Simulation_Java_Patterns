package Rover;

import java.util.ArrayList;

public class Motor implements RoverParts{
	public String[] motors = {"Front Left", "Front Right", "Back Left", "Back Right"};
	private ArrayList<Integer> alarm = new ArrayList<Integer>();
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	public String each_motor(int which_motor) {
		return motors[which_motor];
	}
	
	public void add_alarm(int alarm) {
		this.alarm.add(alarm);
	}
	
	public int past_alarm(int which_motor) {
		return this.alarm.get(which_motor);
	}

}
