package Rover;

import java.util.ArrayList;

public class Wheel implements RoverParts{
	public String[] wheels = {"Front Left", "Front Right", "Back Left", "Back Right"};
	private ArrayList<Integer> alarm = new ArrayList<Integer>();
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	public String each_wheel(int which_wheel) {
		return wheels[which_wheel];
	}
	
	public void add_alarm(int alarm) {
		this.alarm.add(alarm);
	}
	
	public int past_alarm(int which_wheel) {
		return this.alarm.get(which_wheel);
	}
}
