import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;


public class ShopProgram {
	static double discount = 0;
	static double discount1 = 0;
	private static double[] qualify;

	public static String numSuffix(int i) {
		int rem = i % 10;
		switch (rem) {
		case 0:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
		return (i + "th");
		case 1:
		if (i % 100 != 11)
		return (i + "st");
		else
		return (i + "th");
		case 2:
		if (i % 100 != 12)
		return (i + "nd");
		else
		return (i + "th");
		case 3:
		if (i % 100 != 13)
		return (i + "rd");
		else
		return (i + "th");
		default:
		break;
		}
		return "";
		}
	
	
	
	public static int SetShop (Scanner input,String [] names, double [] prices, int [] discount, double[]dollaramount, double[] qualify) {
		
		

	    System.out.print("Please enter the number of items: "); 
	    int items = input.nextInt();
	    
	    
	    for (int i = 0; i < items; i++) {
	    	System.out.print("Enter name of product "   + numSuffix(i+1) + ": " ); 
	    	names[i] = input.next();
	    	System.out.print("Enter price of product " +  numSuffix(i+1) + ": ");
	    	prices[i] = input.nextDouble(); 
	    	System.out.print("Enter the number of packages ('x') to qualify for Special Discount (buy 'x' get 1 free) for " + names[i]+ ", or 0 if no Special Discount offered: ");
	    	discount[i] = input.nextInt();
		   
		    
		    
	    }
	    
	    
	    
	    System.out.println();
	    System.out.print("Enter the dollar amount to qualify for Additional Discount (or 0 if none offered): ");
	    dollaramount[1] = input.nextDouble();
	    if(dollaramount[1] > 0) {
	    	
	    System.out.print("Enter the Additional Discount rate (e.g., 0.1 for 10%):  ");
	    qualify[1]= input.nextDouble();
	    System.out.println();
	    while(qualify[1] < 0 || qualify[1] >= 0.5) {
	    	
	         System.out.print("Invalid input. Enter a value >0 and <= 0.5: ");
	            
	            
	            qualify[1] = input.nextDouble();
	        
		    }
	    }
	    
	    
	 	return items;
	 	
		}
		
	
	
	
	public static void Buy (Scanner input, String [] names, double [] prices, int [] amounts, int items){
		for (int i = 0; i < items; i++) {
			System.out.print("Enter the amount of " + names[i] + ": ");
			amounts[i] = input.nextInt(); 
			
			while(amounts[i] < 0 ) {
		    	
		         System.out.print("Invalid input. Enter a value >0: ");
		            
		            
		         amounts[i] = input.nextInt();
			    }
			
			
		}
	
	}
	
	
	
	public static void List (String [] names, double [] prices, int [] amounts, int items) {
		for (int i = 0; i < items; i++) {
		  if ( amounts[i] > 0 ) {
		System.out.println(amounts[i] + " packages of " + names[i] + " @  $" + prices[i] + " = $"  + (amounts[i] * prices[i]) );
		
		
		
		
		}
		  
		  
		  
		  
		  
		  
										}
		
	}
	
	
public static void Checkout (double [] prices, int [] amounts, double[] qualify, int[] discount,double[] dollaramount, int items) {
		DecimalFormat ff = new DecimalFormat("#.##");

		double total = 0;
		double finaldiscount = 0;
		double f2 = 0;
		double extra = 0;
		
		for (int i = 0; i < items; i++) {
		total = prices[i] * amounts[i] + total;
		
		if (amounts[i]> 0)
	finaldiscount += (int)(amounts[i] /(discount[i] +1)) * prices[i];

		

		}

		
		 
		 
		 System.out.println("Original Sub Total:                         $" + ff.format(total));
	     System.out.println("Special Discounts:                         -$" + ff.format(finaldiscount));
	     System.out.println("New Sub Total:                              $" + ff.format(total - (finaldiscount)));
	    
	     if(dollaramount[1] ==0) {	 
	     System.out.println("You did not qualify for an Additional Discount.");
	     }
	     else {
	    	 System.out.println("Additional " + qualify[1]*100 +"% Discount:                  $" + ff.format(qualify[1]*(total-finaldiscount)) );
		     extra = qualify[1]*(total-finaldiscount);
		     }
	     
	     System.out.print("Final Sub Total:                            $" + ff.format(total - finaldiscount - extra));
	     System.out.println();
	     System.out.println("");

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		
		final int qq = 1000;
		int items = 0;
		int isSetUp = 0;
		int buySetUp = 0;
		int buycheck=0;
		String [] names = new String [qq];
		double [] prices = new double [qq];
		int [] amounts = new int [qq];
		Scanner input = new Scanner (System.in);
	    int [] discount = new int [qq];
	    double [] qualify = new double [qq];
	    double[] dollaramount = new double[qq];
	    int run = 1;
	    while(run == 1) {
		do {
			
		System.out.println("This Program supports 4 functions:");
		System.out.println("1. Setup Shop ");
		System.out.println("2. Buy ");
		System.out.println("3. List Items ");
		System.out.println("4. Checkout");
		System.out.print("Please choose the function you want: ");
		int choice = input.nextInt();
		System.out.println();
		
	
		
		if (choice == 1) {
		
items = SetShop(input,names,prices, discount, dollaramount ,qualify);	
					
		isSetUp = 1;
		}
		
		
		
		
		
		
		
		
		
		if (choice == 2) {
			if (isSetUp==1) {
				System.out.println();
				Buy(input, names, prices, amounts, items);		
				System.out.println();
				
				isSetUp = 1;
				buySetUp =1;
			
		}
			else {
				System.out.println();
				System.out.println("Shop is not setup Yet!");
				System.out.println();
				continue;
			}
		}
		
		
		
		for(int i = 0; i<= items; i++) {
			buycheck+= amounts[i];
		}
		
		
		
		if (choice == 3) {
			if (isSetUp==1 && buycheck > 0) {
				System.out.println();
				List(names, prices, amounts,items);
				System.out.println();
				continue;
			}
			if (buycheck == 0 && isSetUp ==1) {
				System.out.println();
				System.out.println("No items were purchased");
				System.out.println();
				continue;
			}
				
		
			else {
				System.out.println();
				System.out.println("Shop is not setup Yet!");
				System.out.println();
				continue;		
				
			}
			
		}
		
		
		
		
		if (choice == 4) {
			if (isSetUp==1 && buySetUp==1) {
				System.out.println();
				Checkout(prices, amounts, qualify, discount, dollaramount, items);
				System.out.println();
				break;
			}
			
			else {
				System.out.println();
				System.out.println("Shop is not setup Yet!");
				System.out.println();
				continue;
			}
				
			
			
			
			
			
			
			
			
	
		
		}
		}
	while(true);
		System.out.print("Would you like to re-run (1 for yes, 0 for no)? ");
		run = input.nextInt();
		
		if (run == 1) {
			 items = 0;
			 isSetUp = 0;
			 buySetUp = 0;
			 buycheck=0;
				 
				for (int k = 0; k <= items; k++) {
					 names[k] = "";
					 prices[k] = 0;
					 amounts[k] = 0;
					 discount [k]=0;
					 qualify[k] = 0;
					 dollaramount[k] =0;
					 
					 

				}
				

			 
	    }
		
	
	}
	    
	}
	}
	


