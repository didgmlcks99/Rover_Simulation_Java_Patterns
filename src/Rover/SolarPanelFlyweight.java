package Rover;

import java.util.HashMap;
import java.util.Map;

public class SolarPanelFlyweight {
	private Map<Integer , SolarPanelType> types = new HashMap<Integer, SolarPanelType>();
	
	SolarPanelType lookup(Integer kw, String panel) {
		if(!types.containsKey(kw)) {
			types.put(kw, new SolarPanelType(kw));
			System.out.println("Making a New Solar Panel : " + types.get(kw).toString() + " Panel");
		}
		return types.get(kw);
	}
	
	int totalSolarPanelTypesMade() {
		return types.size();
	}
}
