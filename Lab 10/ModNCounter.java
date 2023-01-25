package oop;


/**
 * A counter class that cycles its internal value back to 0 when it
 * reaches a maximum value. 
 * 
 * e.g., A (new) ModNCounter with a cycleLength (maximum) of 5 will,
 * when increment() is called 7 times, have an internal value of 2
 */
public class ModNCounter  extends Counter { 


	private int cycle; 

	public ModNCounter (int n) { 
		cycle = n; 
	}  

	@Override
	public void increment() { 
		if (value() < (cycle-1)) 
			super.increment();
		else
			reset();
	}
} 