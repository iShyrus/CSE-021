package oop;

public class SeasonCounter extends ModNCounter {


	private static String[] names =  {"Spring", "Summer", "Fall", "Winter"};


	public SeasonCounter() {
		super(4);
	}


	@Override
	public String toString() {
		return names[value()];
	}


}