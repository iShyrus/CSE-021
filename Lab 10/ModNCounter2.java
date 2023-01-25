  
package oop;

public class ModNCounter2 extends Counter{

	private int cycle;

	public ModNCounter2(int n) {
		cycle = n;
	}

	@Override
	public int value() {

		if (super.value() != cycle)
			return super.value();
		else
			reset();
			return 0;
	}
}