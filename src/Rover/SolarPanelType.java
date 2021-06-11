package Rover;

public class SolarPanelType {
	private final int kw;
	
	SolarPanelType(int kw){
		this.kw = kw;
	}
	
	public String toString() {
		return kw + "KW";
	}
}
