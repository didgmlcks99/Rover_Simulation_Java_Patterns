package Rover;

import java.util.HashMap;

public class ArmManager {
	private HashMap<String, ArmProduct> showcase = new HashMap<String, ArmProduct>();
	
	public void register(String name, ArmProduct proto) {
		showcase.put(name, proto);
	}
	
	public ArmProduct create(String protoname) {
		ArmProduct p = (ArmProduct)showcase.get(protoname);
		return p.createClone();
	}
}
