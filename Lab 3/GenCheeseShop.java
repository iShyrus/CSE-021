import java.util.*;
import java.util.Random;
import java.text.DecimalFormat;

public class GenCheeseShop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		        Scanner keyboard  = new Scanner(System.in);
		        
		        
		        
		        System.out.print("Enter the number of Cheeses for shop setup: ");
		        
		        
		        int MAXCHEESE = keyboard.nextInt();

		        
		        System.out.println("");
		        
		        double humboldtPrice = 25.0;
		        double redhawkPrice = 40.5;
		        double telemePrice = 17.25;
		        String[] names = new String[MAXCHEESE];
				double[] prices = new double[MAXCHEESE];
				double[] amounts = new double[MAXCHEESE];
		 		Random ranGen = new Random(100);
		 		DecimalFormat df = new DecimalFormat("#.##");

		        System.out.println("We sell " + MAXCHEESE + " kinds of Cheese (in 0.5 lb packages):");
		        
		        if (MAXCHEESE == 0) {
		        System.out.println("Original Sub Total:     $0.00");
		        System.out.println("Specials...");
		        System.out.println("None:                  -$0.00");
		        System.out.println("New Sub Total:          $0.00");
		        System.out.println("Additional 0% Discount: $0.00");
		        System.out.println("Final Total:            $0.00");
		        
		        }
		        
		        																													
		        else {
		        
		         
		        if (MAXCHEESE >= 1) {
		        System.out.println("Humboldt Fog: $25.0 per pound");
		        }
		        if (MAXCHEESE>=2) {
		        System.out.println("Red Hawk: $40.5 per pound");
		        }
		        if (MAXCHEESE>=3) {
		        System.out.println("Teleme: $17.25 per pound");
		       }
		        
		        
		        
		        
		        
		        for (int i = 3; i < MAXCHEESE; i++) {
					names[i] = "Cheese Type " + (char)('A' + i);
					prices[i] = ranGen.nextInt(1000)/100.0;
					amounts[i] = 0;

					System.out.println(names[i] + ": $" + prices[i] + " per pound");
				}
		        System.out.println();
//-----------------------------------------------------------------------------------------------------------------------
		        
		        double humboldtFogQty1 = 0;
		        
		        if(MAXCHEESE >= 1) {
		        System.out.print("Enter the amount of Humboldt Fog in lbs: ");
		        double humboldtFogQty = keyboard.nextDouble();
		        humboldtFogQty1 = humboldtFogQty;
		        

		        while(humboldtFogQty < 0 || humboldtFogQty % 0.5 != 0){
		            if(humboldtFogQty < 0){
		                System.out.print("Invalid input. Enter a value >=0: ");
		            }
		            else {
		                System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
		            }
		            humboldtFogQty = keyboard.nextDouble();
		            
		            humboldtFogQty1 = humboldtFogQty;
		        }
		        }
		        
		       
		    
//-----------------------------------------------------------------------------------------------------------------------     
		        
		        double redHawkQty1 = 0;
		        if (MAXCHEESE >=2 ) {
		        System.out.print("Enter the amount of Red Hawk in lbs: ");
		        double redHawkQty = keyboard.nextDouble();
		        redHawkQty1 = redHawkQty;
		        
		        while(redHawkQty < 0 || redHawkQty % 0.5 != 0){
		            if(redHawkQty < 0){
		                System.out.print("Invalid input. Enter a value >=0: ");
		            }
		            else {
		                System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
		            }
		            redHawkQty = keyboard.nextDouble();
		            redHawkQty1 = redHawkQty;
		        }
		        }
//-----------------------------------------------------------------------------------------------------------------------     
		        double telemeQty1 = 0;
		        
		        if (MAXCHEESE >=3) {
		        System.out.print("Enter the amount of Teleme Fog in lbs: ");
		        double telemeQty = keyboard.nextDouble();
		        telemeQty1 = telemeQty;
		        
		        while(telemeQty< 0 || telemeQty % 0.5 != 0){
		            if(telemeQty < 0){
		                System.out.print("Invalid input. Enter a value >=0: ");
		            }
		            else {
		                System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
		            }
		            telemeQty = keyboard.nextDouble();
		            telemeQty1 = telemeQty;
		        }
		        }
		        
//-------------------------------------------------------------------------------------------------------------------------
		        
		        
		        
		        

				for (int i = 3; i < MAXCHEESE; i++) {
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
				
		        
		        
		        
		        
		        
		        
		 
//-------------------------------------------------------------------------------------------------------------------------
		        
		      double discounthumboldt = 0;
		      double discountredhawk = 0;
		        discounthumboldt=(int)(((humboldtFogQty1/.5)/2)) *.5;
		        discountredhawk=(int)(((redHawkQty1/.5)/3))* .5;
//------------------------------------------------------------------------------------------------------------------------
		        double pp = 0;
		        double subTotal = (humboldtFogQty1 * (humboldtPrice) + (redHawkQty1 * (redhawkPrice)) + (telemeQty1 * (telemePrice)) + pp);

		        

		        double dd = 0;
		       
		        System.out.println();
		        System.out.print("Display the itemized list? (1 for yes) ");
		        int list = keyboard.nextInt();
		        
		        
		       if(subTotal == 0) {
		    	   System.out.println("No items were purchased");
		       }
		        
		       
	             
		       
		       
		        if(list == 1){
		        	if(MAXCHEESE >= 1) {
		            System.out.println((humboldtFogQty1) + " of Humboldt Fog @ $" + humboldtPrice + " = $" + (humboldtFogQty1 * (humboldtPrice)));
		        	}
		        	if (MAXCHEESE >= 2) {		        		
		            System.out.println((redHawkQty1) + " of Red Hawk @ $" + redhawkPrice + " = $" + (redHawkQty1 * (redhawkPrice)));
		        	}
		        	if (MAXCHEESE >=3) {
		            System.out.println(telemeQty1 + " of Teleme @ $" + telemePrice + " = $" + (telemeQty1 * (telemePrice)));
		        	}

					for (int i = 3; i < MAXCHEESE; i++) {
						
						System.out.print(amounts[i] + " lb of Cheese Type " + (char)('A' + i) + " @ " + prices[i] + " = ");

						dd = prices[i] * amounts[i];
						 
				            df.format(dd);
						System.out.println(df.format(dd));
						
						pp = dd + pp;
	
						
					}
				    
					
					
					
		            
		        }
		    System.out.println();
		    
		    
		    
//-----------------------------------------------------------------------------------------------------------------------------	    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		        
		            System.out.println("Original Sub total: \t\t\t$" + (subTotal+pp));
		            System.out.println("Specials...");	            
		            if (humboldtFogQty1 > 0) {
		            System.out.println("Humboldt Fog (Buy 1 Get 1 Free):       -$" + (discounthumboldt * (humboldtPrice)));
		            }   
		            if (redHawkQty1 > 0) {
		            System.out.println("Red Hawk (Buy 2 Get 1 Free):           -$" + (discountredhawk * redhawkPrice));
		            }
		            if (humboldtFogQty1 == 0 && redHawkQty1 == 0 ) {
		            	System.out.println("None\t\t\t\t        $0.00");
		            }
		            
		            
		            double total = (subTotal - (discounthumboldt * (humboldtPrice)) - (discountredhawk * redhawkPrice) + pp );
		            
		            System.out.println("New Sub Total :\t\t\t\t$" + df.format(total));
		            
		            
		            double discount2 = 0;
		           
		            
		            if(total > 150 && total<250) {
		            	discount2 = total * .1;
		            	System.out.println("Additional 10% Discount: \t\t$" + df.format(discount2));
		            }
		            else if (total > 250) {
		            	discount2 = total * .25;
		            	System.out.println("Additional 25% Discount: \t\t$" + df.format(discount2));
		            	
		            }
		            else {
		            	System.out.println("Additional 0% Discount: \t\t$0.00");
		            }
		            
		            
		           
		           
		            
 
		           if(total > 150) {
		        System.out.println("Final Total: \t\t\t\t$" + df.format(total - discount2));
		           }
		           else{
		        System.out.println("Final Total: \t\t\t\t$" + df.format(total)); 
		           }
		          
		        
		        
		        
		        
		        
		        }
		
		        
		
		        
		        
		        
		
		
	}
		
	}

		
		
		
		
		
		
		
		
		
		
		
		
		
	


