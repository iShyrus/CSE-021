import java.util.*;

public class CheeseShop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		        Scanner keyboard  = new Scanner(System.in);
		        

		        double humboldtPrice = 25.0;
		        double redhawkPrice = 40.5;
		        double telemePrice = 17.25;
		        
		        System.out.println("We sell 3 kinds of Cheese (in 0.5 lb packages):");
		       
		        System.out.println("Humboldt Fog: $25.0 per pound");
		        System.out.println("Red Hawk: $40.5 per pound");
		        System.out.println("Teleme: $17.25 per pound");
		        System.out.println();
//-----------------------------------------------------------------------------------------------------------------------
		        
		        System.out.print("Enter the amount of Humboldt Fog in lbs: ");
		        double humboldtFogQty = keyboard.nextDouble();

		        while(humboldtFogQty < 0 || humboldtFogQty % 0.5 != 0){
		            if(humboldtFogQty < 0){
		                System.out.print("Invalid input. Enter a value >=0: ");
		            }
		            else {
		                System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
		            }
		            humboldtFogQty = keyboard.nextDouble();
		        }
//-----------------------------------------------------------------------------------------------------------------------     
		        
		        System.out.print("Enter the amount of Red Hawk in lbs: ");
		        double redHawkQty = keyboard.nextDouble();

		        while(redHawkQty < 0 || redHawkQty % 0.5 != 0){
		            if(redHawkQty < 0){
		                System.out.print("Invalid input. Enter a value >=0: ");
		            }
		            else {
		                System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
		            }
		            redHawkQty = keyboard.nextDouble();
		        }
//-----------------------------------------------------------------------------------------------------------------------     

		        System.out.print("Enter the amount of Teleme Fog in lbs: ");
		        double telemeQty = keyboard.nextDouble();

		        while(telemeQty< 0 || telemeQty % 0.5 != 0){
		            if(telemeQty < 0){
		                System.out.print("Invalid input. Enter a value >=0: ");
		            }
		            else {
		                System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
		            }
		            telemeQty = keyboard.nextDouble();
		        }
//-------------------------------------------------------------------------------------------------------------------------
		        
		      double discounthumboldt = 0;
		      double discountredhawk = 0;
		        discounthumboldt=(int)(((humboldtFogQty/.5)/2)) *.5;
		        discountredhawk=(int)(((redHawkQty/.5)/3))* .5;
//------------------------------------------------------------------------------------------------------------------------
		
		        System.out.print("Display the itemized list? (1 for yes) ");
		        int list = keyboard.nextInt();
		        if(list == 1){
		            System.out.println((humboldtFogQty) + " of Humboldt Fog @ $" + humboldtPrice + " = $" + (humboldtFogQty * (humboldtPrice)));
		            System.out.println((redHawkQty) + " of Red Hawk @ $" + redhawkPrice + " = $" + (redHawkQty * (redhawkPrice)));
		            System.out.println(telemeQty + " of Teleme @ $" + telemePrice + " = $" + (telemeQty * (telemePrice)));
		        }
		    System.out.println();
		    
		        double subTotal = (humboldtFogQty * (humboldtPrice) + (redHawkQty * (redhawkPrice)) + (telemeQty * (telemePrice)));
		            System.out.println("Sub total: \t\t\t\t$" + subTotal);
		            System.out.println("Discounts...");	            
		            if (humboldtFogQty > 0) {
		            System.out.println("Humboldt Fog (Buy 1 Get 1 Free): \t-$" + (discounthumboldt * (humboldtPrice)));
		            }   
		            if (redHawkQty > 0) {
		            System.out.println("Red Hawk (Buy 2 Get 1 Free):     \t-$" + (discountredhawk * redhawkPrice));
		            }
		            if (humboldtFogQty == 0 && redHawkQty == 0 ) {
		            	System.out.println("\tNone");
		            }
		            
		            double total = (subTotal - (discounthumboldt * (humboldtPrice)) - (discountredhawk * redhawkPrice) );
		            
		        System.out.println("Final Total: \t\t\t\t$" + total);
		        
		        
		        }
		
		
		
		
		
		
	}

		
		
		
		
		
		
		
		
		
		
		
		
		
	


