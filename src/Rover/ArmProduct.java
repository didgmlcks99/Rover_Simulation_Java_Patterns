package Rover;

import java.lang.Cloneable;

public interface ArmProduct extends Cloneable{
	public abstract void repairArm(String s);
	public abstract ArmProduct createClone();
}
