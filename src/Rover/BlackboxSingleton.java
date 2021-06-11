package Rover;

import java.util.ArrayList;

public class BlackboxSingleton {
	private static BlackboxSingleton blackbox = new BlackboxSingleton();
	private ArrayList<String> alarm = new ArrayList<String>();
	private ArrayList<String> action = new ArrayList<String>();
	
	private BlackboxSingleton() {
	}
	
	public static BlackboxSingleton getInstance() {
		if(blackbox == null) {
			blackbox = new BlackboxSingleton();
		}
		return blackbox;
	}
	
	public void print_results() {
		System.out.println();
		System.out.println("+++ Major Checking and Action from Blackbox +++");
		print_alarm();
		print_action();
		System.out.println("+++ Blackbox Displayed Finished +++");
	}
	
	public void record_alarm(String s) {
		alarm.add(s);
	}
	
	public void record_action(String s) {
		action.add(s);
	}
	
	public void print_alarm() {
		for(int i=0; i < alarm.size(); i++) {
			System.out.println(i + ": Alarm: " + alarm.get(i));
		}
	}
	
	public void print_action() {
		for(int i=0; i < action.size(); i++) {
			System.out.println(i + ": Action: " + action.get(i));
		}
	}
}
