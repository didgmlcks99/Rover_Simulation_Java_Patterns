package Rover;

public class Camera implements RoverParts{

	private int alarm = 0;
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	public void add_alarm(int alarm) {
		this.alarm = alarm;
	}
	
	public int past_alarm() {
		return this.alarm;
	}
}
