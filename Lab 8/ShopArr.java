import java.util.*;

public class ShopArr {

	// Instance Variables
	private Cheese[] cheese;

	// Initialize method
	private void init(int max) {

		// Create max number of Cheese pointers
		cheese = new Cheese[max];

		if (max > 0) {
			cheese[0] = new Cheese();
			cheese[0].setName("Humboldt Fog");
			cheese[0].setPrice(25.00);

			if (max > 1) {
				cheese[1] = new Cheese("Red Hawk");
				cheese[1].setPrice(40.50);

				if (max > 2) {
					cheese[2] = new Cheese("Teleme", 17.25);
					// cheese[2].setName("Wrong Name");
				}
			}
		}

		Random ranGen = new Random(100);

		for (int i = 3; i < max; i++) {
			cheese[i] = new Cheese();
			cheese[i].setName("Cheese Type " + (char) ('A' + i));
			cheese[i].setPrice(ranGen.nextInt(1000) / 100.0);
		}

	}

	public ShopArr() {
		init(10);
	}

	public ShopArr(int max) {
		init(max);
	}

	/*
	 * Displays the intro message informing the user of various cheeses sold and
	 * Gets the amount of each cheese the user would like to purchase.
	 */
	private void intro(Scanner input) {
		System.out.println("We sell " + cheese.length + " kinds of Cheese (in 0.5 lb packages)");
		if (cheese.length > 0) {
			System.out.println(cheese[0].getName() + ": $" + cheese[0].getPrice() + " per pound");
		}
		if (cheese.length > 1) {
			System.out.println(cheese[1].getName() + ": $" + cheese[1].getPrice() + " per pound");
		}
		if (cheese.length > 2) {
			System.out.println(cheese[2].getName() + ": $" + cheese[2].getPrice() + " per pound");
		}

		for (int i = 3; i < cheese.length; i++) {
			System.out.println(cheese[i].getName() + ": $ " + cheese[i].getPrice() + " per pound");
		}
		System.out.println();

		for (int i = 0; i < cheese.length; i++) {
			System.out.print("Enter the amount of " + cheese[i].getName() + " : ");
			cheese[i].setAmount(input);
			while (((cheese[i].getAmount() % 0.5) != 0) || (cheese[i].getAmount() < 0)) {
				System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
				cheese[i].setAmount(input);
			}
		}
	}

	/*
	 * Displays the itemized list of all cheeses bought or a special message if
	 * none were purchased.
	 */
	private void itemizedList() {
		double amount = 0;
		for (int i = 0; i < cheese.length; i++) {
			amount += cheese[i].getAmount();
		}
		if (amount == 0) {
			System.out.println("No items were purchased.");
		} else {
			for (int i = 0; i < cheese.length; i++) {
				System.out.println(cheese[i].getAmount() + " lbs of " + cheese[i].getName() + " @ "
						+ cheese[i].getPrice() + " =  $" + (cheese[i].getAmount() * cheese[i].getPrice()));
			}
		}
	}

	/*
	 * Calculates the Original Sub Total, which is the price*amount of each
	 * cheese added together. Returns the Original Sub Total.
	 */
	private double calcSubTotal() {
		double subTotal = 0;
		for (int i = 0; i < cheese.length; i++) {
			subTotal += cheese[i].getAmount() * cheese[i].getPrice();
		}
		return subTotal;
	}

	/*
	 * Calculates discounts based on special offers on Humboldt Fog and Red
	 * Hawk, stores them in disSpecials[0] and disSpecials[1], and returns the
	 * array. Minor changes from Lab 07 (identical logic).
	 */
	private double[] discountSpecials() {
		double[] disSpecials = { 0, 0 };
		double hfAmt = 0;
		double rhAmt = 0;
		if(cheese.length > 0) {
		hfAmt = cheese[0].getAmount();
		}
		if(cheese.length > 1) {
		rhAmt = cheese[1].getAmount();
		}
		double rpkg = rhAmt * 2;
		double hpkg = hfAmt * 2;
		
			if (hpkg >= 2) {
				disSpecials[0] = ((int)hpkg / 2) * (cheese[0].getPrice() / 2);
			}

			if (rpkg >= 4) {
				disSpecials[1] = ((int)rpkg / 3) * (cheese[1].getPrice() / 2);
			}
		return disSpecials;
	}

	/*
	 * Displays the Original Sub Total, discounts based on specials, and the New
	 * Sub Total. Returns the New Sub Total. Identical to Lab 07.
	 */
	private double printSubTotals(double subTotal, double[] disSpecials) {
		System.out.printf("\nOriginal Sub Total: \t\t  $%.2f\n", subTotal);
		System.out.println("Specials...");

		if (disSpecials[0] > 0) {
			System.out.printf("Humboldt Fog (Buy 1 Get 1 Free): -$%.2f\n", disSpecials[0]);
		}
		if (disSpecials[1] > 0) {
			System.out.printf("Red Hawk (Buy 2 Get 1 Free):     -$%.2f\n", disSpecials[1]);
		}
		if (disSpecials[0] == 0 && disSpecials[1] == 0) {
			System.out.println("None \t\t\t\t  -$0.0");
		}
		double newSub = (subTotal - disSpecials[0] - disSpecials[1]);
		System.out.printf("New Sub Total: \t\t\t  $%.2f\n", newSub);
		return newSub;
	}

	/*
	 * Calculates the additional discount based on the New Sub Total and
	 * displays the Final Total. Identical to Lab 07.
	 */
	private void printFinalTotal(double newSubTotal) {
		double disc = 0;
		if (newSubTotal > 250) {
			disc = newSubTotal * .25;
			System.out.printf("Additional 25%% discount: \t  -$%.2f\n", disc);
		} else if (newSubTotal > 100) {
			disc = newSubTotal * .10;
			System.out.printf("Additional 10%% discount: \t  -$%.2f\n", disc);
		} else {
			System.out.printf("Additional 0%% discount: \t  -$%.2f\n", disc);
		}
		// Prints final total
		System.out.printf("Final Total: \t\t\t  $%.2f\n", newSubTotal - disc);

	}

	private void printFree() {
		double amount;
		System.out.println();
		System.out.println("Today is your lucky day!");
		for (int i = 0; i < cheese.length; i++)
			if ((amount = cheese[i].getAmount()) > 0)
				System.out.println(amount + " lb of " + cheese[i].getName() + " @ $0 = $" + 0);
		System.out.println("Total Price: FREE!!!\n");
	}

	public void run() {

		Scanner input = new Scanner(System.in);
		intro(input);
		double subTotal = calcSubTotal();

		System.out.println();
		System.out.print("Display the itemized list? (1 for yes): ");
		int list = input.nextInt();
		if (list == 1)
			itemizedList();

		int free = (new Random()).nextInt(100);
		// System.out.println("Random num is " + free);
		if (free != 0) {
			double newSubTotal = printSubTotals(subTotal, discountSpecials());
			printFinalTotal(newSubTotal);
		} else {
			printFree();
			return;
		}

		System.out.println();
		System.out.print("Do you wish to redo your whole order? (1 for yes): ");
		int redo = input.nextInt();

		System.out.println();

		if (redo == 1)
			run();
		else
			System.out.println("Thanks for coming!");
	}
}
