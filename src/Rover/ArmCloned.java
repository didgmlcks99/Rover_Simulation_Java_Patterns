package Rover;

public class ArmCloned implements ArmProduct{
	private String armType;
	
	public ArmCloned(String armType) {
		this.armType = armType;
	}
	
	@Override
	public void repairArm(String s) {
		String act = s + " Clone Made from Prototype " + armType;
		BlackboxSingleton.getInstance().record_action(act);
		
		System.out.println(act);
	}

	@Override
	public ArmProduct createClone() {
		ArmProduct p = null;
		try {
			p = (ArmProduct)clone();
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return p;
	}
	
}
