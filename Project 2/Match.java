import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Match {

	public static void main(String[] args) {
		Student[] arr = new Student[100];
		Scanner input = new Scanner(System.in);
		System.out.print("File Name: ");
		String file = input.next();
		System.out.println();
		
		
		
		
		
		
		
		
		
		
		try {
			Scanner fileInput = new Scanner(new FileReader(file));
			int i = 0;

			while (fileInput.hasNextLine()) {
				Scanner line = new Scanner(fileInput.nextLine());
				line.useDelimiter("[\t\r]");
				String name = line.next();
				String gender = line.next();
				String date = line.next();


				Scanner birth= new Scanner(date);
				birth.useDelimiter("-");
				int day = birth.nextInt();
				int month = birth.nextInt();
				int year = birth.nextInt();
				int quietTime = line.nextInt();
				int music = line.nextInt();
				int reading = line.nextInt();
				int chatting = line.nextInt();
				
				
	


				
				Date birthdate = new Date(month, day, year);
				Preference pref = new Preference(quietTime, music, reading, chatting);
				Student student = new Student(name, gender.charAt(0), birthdate, pref);
				
				
				
				arr[i++] = student;
				
				
				
			}

			int max = i;
			for (i = 0; i < max; i++) {
			if (!arr[i].getMatch()) {
				int matches = 0;
				int high = 0;
				
				
				
				
				
					for (int j = i + 1; j < max; j++) {
						if (!arr[j].getMatch()) {
							int tmp = arr[i].compare(arr[j]);
							
								if (tmp > high) {
									high = tmp;
									matches = j;
							}
							
						}
					}

					
					
					
					
					
					
					
					if (high != 0) {
						arr[i].setMatch(true);
						arr[matches].setMatch(true);
						System.out.println(arr[i].getName() + " matches with " + arr[matches].getName()
								+ " with the score " + high);
					} else if (!arr[i].getMatch())
						System.out.println(arr[i].getName() + " has no matches.");
					
					
					
					
					
					
					
					
				} // bracket if for-loop
			
			} // bracket for for-loop
			
			
			
			
			input.close();
		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
	}
}