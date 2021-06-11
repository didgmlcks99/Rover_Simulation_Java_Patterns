package Rover;

import java.util.ArrayList;

public class SolarPanel implements RoverParts{
	public String[] panels = {"Solar Panel 1", "Solar Panel 2", 
								"Solar Panel 3", "Solar Panel 4",
								"Solar Panel 5", "Solar Panel 6"};
	private ArrayList<Integer> alarm = new ArrayList<Integer>();
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	public String each_panel(int which_panel) {
		return panels[which_panel];
	}
	
	public void add_alarm(int alarm) {
		this.alarm.add(alarm);
	}
	
	public int past_alarm(int which_panel) {
		return this.alarm.get(which_panel);
	}

}
