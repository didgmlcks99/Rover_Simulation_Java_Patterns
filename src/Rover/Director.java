package Rover;

import java.util.ArrayList;

public class Director {
	private Builder builder;
	
	public Director(Builder builder) {
		this.builder = builder;
	}
	
	public void constructTitle(String title) {
		builder.makeTitle(title);
	}
	
	public void running(String part) {
		builder.makeString(part);
	}
	
	public void acting(ArrayList<String> actions) {
		builder.makeItems(actions);
	}
	
	public void endTest() {
		builder.close();
	}
	
	public void result() {
		System.out.println("\n" + builder.getResult() + " is made.");
	}
}
