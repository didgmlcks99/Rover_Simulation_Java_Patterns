package Rover;

import java.util.HashMap;

public class ArmManager {
	private HashMap<String, ArmProduct> showcase = new HashMap<String, ArmProduct>();
	
	public void register(String name, ArmProduct proto) {
		// register the specific type of arm product
		showcase.put(name, proto);
	}
	
	public ArmProduct create(String protoname) {
		// make a clone of the specific arm product
		ArmProduct p = (ArmProduct)showcase.get(protoname);
		return p.createClone();
	}
}
