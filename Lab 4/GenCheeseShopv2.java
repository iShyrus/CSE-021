import java.util.*;
import java.text.DecimalFormat;


public class GenCheeseShopv2 {

	/*
	 * Displays the intro message informing the user of various cheeses sold 
	 * while populating the names and prices arrays, and initializing the
	 * amounts array.
	 */
	public static void intro(String[] names, double[] prices, double[] amounts) {
		
		
		Random ranGen = new Random(100);
		System.out.println("");
		 System.out.println("We sell " + names.length + " kinds of Cheese (in 0.5 lb packages):");
	
		
		if (names.length >= 1) {
	        System.out.println("Humboldt Fog: $25.0 per pound");
	        prices[0] = 25.0;
	        names[0]="Humboldt Fog";
	        }
	        if (names.length>=2) {
	        System.out.println("Red Hawk: $40.5 per pound");
	        prices[1]= 40.5;
	        names[1]="Red Hawk";
	        }
	        if (names.length>=3) {
	        System.out.println("Teleme: $17.25 per pound");
	        prices[2] = 17.5;
	        names[2]="Teleme";
	       }		
		
		
		
		
		for (int i = 3; i < names.length; i++) {
			
			
			
			names[i] = "Cheese Type " + (char)('A' + i);
			prices[i] = ranGen.nextInt(1000)/100.0;
			

			System.out.println(names[i] + ": $" + prices[i] + " per pound");
		}
        System.out.println();
		  
	
	}
	
	/*
	 * Gets the amount of each cheese the user would like to purchase and populates
	 * the amounts array with the user inputs. Performs with input validation 
	 * (amount >= 0 and multiple of 0.5).
	 */
	public static void getAmount(Scanner sc, String[] names, double[] amounts) {
		
        Scanner keyboard  = new Scanner(System.in);

        if(names.length >= 1) {
        System.out.print("Enter the amount of Humboldt Fog in lbs: ");
        amounts[0] = (double) keyboard.nextDouble();
        

        while(amounts[0] < 0 || amounts[0] % 0.5 != 0){
            if(amounts[0] < 0){
                System.out.print("Invalid input. Enter a value >=0: ");
            }
            else {
                System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
            }
            amounts[0] = keyboard.nextDouble();
            
            
        }
        }
//-----------------------------------------------------------------------------------------------------
        if (names.length >=2 ) {
        System.out.print("Enter the amount of Red Hawk in lbs: ");
        amounts[1] = keyboard.nextDouble();
        
        while(amounts[1] < 0 || amounts[1] % 0.5 != 0){
            if(amounts[1] < 0){
                System.out.print("Invalid input. Enter a value >=0: ");
            }
            else {
                System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
            }
            amounts[1] = keyboard.nextDouble();
        }
        }
//----------------------------------------------------------------------------------------------------------
        if (names.length >=3) {
	        System.out.print("Enter the amount of Teleme Fog in lbs: ");
	        double telemeQty = keyboard.nextDouble();
	        amounts[2] = telemeQty;
	        
	        while(amounts[2]< 0 || amounts[2] % 0.5 != 0){
	            if(amounts[2] < 0){
	                System.out.print("Invalid input. Enter a value >=0: ");
	            }
	            else {
	                System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
	            }
	            amounts[2] = keyboard.nextDouble();
	            
	        }
	        }
        
        
        for (int i = 3; i < names.length; i++) {
			System.out.print("Enter the amount of Cheese Type " +(char)('A' + i) + " in lb: ");
			amounts[i]= keyboard.nextDouble();
			 
			while(amounts[i]< 0 || amounts[i] % 0.5 != 0){
	            if(amounts[i] < 0){
	                System.out.print("Invalid input. Enter a value >=0: ");
	            }
	            else {
	                System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
	            }
	            amounts[i] = keyboard.nextDouble();
        
        
        
        
        
			}
        
        }
        
        
        
		}
		
		
        
	      
	
	

	/*
	 * Displays the itemized list of all cheeses bought or a special message if none 
	 * were purchased.
	 */
	public static void itemizedList(String[] names, double[] prices, double[] amounts) {
		double pp=0;
		
		for(int i=0; i<names.length;i++) {
			pp = amounts[i] +pp;
					
					
		}
		if(pp>0) {
		for(int i=0; i<names.length;i++) {
			if (names.length>0){
				System.out.println(names[i] +" " + amounts[i]+ " " + "lbs @" + prices[i] + " = $" + prices[i]*amounts[i]);
			}
			
		}
		}
		
		else {
			System.out.println("No items were purchased.");
		}
	}
		
		
	
	
	
	
	
	
	
	
	
	
	/*
	 * Calculates the Original Sub Total, which is the price*amount of each 
	 * cheese added together. Returns the Original Sub Total.
	 */
	public static double calcSubTotal(double[] prices, double[] amounts) {
		double total = 0;
		double subTotal = 0;
		
		
		for (int i = 0; i < amounts.length; i++) {
			total =amounts[i]*prices[i];
			subTotal = subTotal + total;
			
		}
		
		
		return subTotal;
		
	}

	/*
	 *  Calculates discounts based on special offers on Humboldt Fog and Red Hawk, 
	 *  stores them in disSpecials[0] and disSpecials[1], and returns the array. 
	 */
	public static double[] discountSpecials(double[] amounts, double[] prices){
		
		
		
		
		double[] disSpecials = new double[5];
		
		if(amounts.length >=1) {
		disSpecials[1]=(int)(((amounts[0]/.5)/2)) *.5 * prices[0];
		}
		if (amounts.length >=2)
        disSpecials[2]=(int)(((amounts[1]/.5)/3))* .5 * prices[1];
		
		return disSpecials;		
	}

	/*
	 * Displays the Original Sub Total, discounts based on specials, and the New Sub 
	 * Total. Returns the New Sub Total.
	 */
	public static double printSubTotals(double subTotal, double[] disSpecials) {
 		DecimalFormat ff = new DecimalFormat("#.##");
if (subTotal>=0) {
		System.out.println();
        System.out.println("Original Sub total: \t\t\t$" + ff.format(subTotal));
        System.out.println("Specials... ");
        System.out.println("Humboldt Fog (Buy 1 Get 1 Free):       -$" + disSpecials[1]);
        System.out.println("Red Hawk (Buy 2 Get 1 Free):   \t       -$" + disSpecials[2]);

		
		
}
double newSubTotal = subTotal - disSpecials[1] - disSpecials[2];

		return newSubTotal;
	}

	/*
	 * Calculates the additional discount based on the New Sub Total and displays 
	 * the Final Total.
	 */
	public static void printFinalTotal(double newSubTotal) {

 		DecimalFormat df = new DecimalFormat("#.##");

 		
 		if (newSubTotal>=0) {

 		
		System.out.println("New Sub Total:\t\t\t\t$" + df.format(newSubTotal));
		
		  double discount2 = 0;
          
          
          if(newSubTotal > 150 && newSubTotal<250) {
          	discount2 = newSubTotal * .1;
          	System.out.println("Additional 10% Discount:\t       -$" + df.format(discount2));
          }
          else if (newSubTotal > 250) {
          	discount2 = newSubTotal * .25;
          	System.out.println("Additional 25% Discount:\t       -$" + df.format(discount2));
          	
          }
          else {
          	System.out.println("Additional 0% Discount:\t\t       -$0.00");
          }
          
          
         
         
          

         if(newSubTotal > 150) {
      System.out.println("Final Total: \t\t\t\t$" + df.format(newSubTotal - discount2));
         }
         else{
      System.out.println("Final Total: \t\t\t\t$" + df.format(newSubTotal)); 
         }
		
		
 		}
		
	}
	
	/*
	 * Program starts here
	 */
	public static void main(String[] args) {

		final int MAXCHEESE;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of Cheeses for shop setup: ");
		MAXCHEESE = sc.nextInt();

		// DO NOT CHANGE ANYTHING BELOW
		String[] names = new String[MAXCHEESE]; 
		double[] prices = new double[MAXCHEESE]; 
		double[] amounts = new double[MAXCHEESE];

		intro(names, prices, amounts);

		getAmount(sc, names, amounts);

		double subTotal = calcSubTotal(prices, amounts);
		
		
		if (MAXCHEESE != 0 ) {
			System.out.print("\nDisplay the itemized list? (1 for yes) ");
			int display = sc.nextInt();
			
			if (display == 1) {
				itemizedList(names, prices, amounts);
			}
		}

		double newSubTotal = printSubTotals(subTotal, discountSpecials(amounts, prices));
		
		printFinalTotal(newSubTotal);
		
		sc.close();
	}
}