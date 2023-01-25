import java.util.Scanner;

public class RemainderFunc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maxnumber, divisor;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Please enter the max number: ");
		maxnumber = keyboard.nextInt();
		
		if (maxnumber < 0)
			while (maxnumber < 0) {
				System.out.print("Invalid input. Please enter a  valid max number (>= 0): ");
			maxnumber = keyboard.nextInt();
			
			}
		
		// while makes sure no negative numbers

		System.out.print("Please enter the Divisor: ");
		divisor = keyboard.nextInt();
			
			if (divisor < 0)
				while (divisor < 0) {
					System.out.print("Invalid input. Please enter a valid divisor (>=0): ");
					divisor = keyboard.nextInt();
				}
		
			//while makes sure no negative numbers
			
			
		System.out.println("Multiples of " + divisor + " between 1 and " + maxnumber +" (inclusive) are:");
		
		for (int i=1; i<= maxnumber; i++) {
		
			if (i % divisor == 0) {
				System.out.println(i);
			}
			else if (divisor > maxnumber) {
				System.out.println("No numbers were found");
				break;
			}
				
		}
	}

}
