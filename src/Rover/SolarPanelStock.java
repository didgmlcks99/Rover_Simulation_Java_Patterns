package Rover;

public class SolarPanelStock {
	private final SolarPanelFlyweight flyweight = new SolarPanelFlyweight();
	
	void repairPanel(int kw, String panel) {
		// bring the panel type
		SolarPanelType type = flyweight.lookup(kw, panel);
		
		String act = "Replacing " + panel;
		BlackboxSingleton.getInstance().record_action(act);
		
		System.out.println("A Troublesome Panel Replaced by " + type.toString() + " Panel");
	}

	String report() {
		return "total Solar Panel Types made: " + flyweight.totalSolarPanelTypesMade();
	}
}
