package Rover;

import java.util.ArrayList;

public abstract class Builder {
	public abstract void makeTitle(String title);
	public abstract void makeString(String str);
	public abstract void makeItems(ArrayList<String> items);
	public abstract void close();
	public abstract String getResult();
}
