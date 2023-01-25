

public class Student {

	private String name; 
	private char gender; 
	private Date birthDate; 
	private Preference pref; 
	private boolean matched; 
	private int month;
	private int day;
	private int year;
	public int comScore; 
	
	public Student (){ //default constructor
		name = "Annaliza";
		gender = 'F';
		matched = false;
		birthDate = new Date (month, day, year);
	}
	
	public Student(String name, char gender, Date birthDate, Preference pref) {
		this.name = name;
		this.gender = gender; 
		this.birthDate = birthDate; 
		this.pref = pref;  
	}

	public void setName(String name){
		this.name = name;
	}
	
	public void setGender(char gender){
		this.gender = gender;
	}
	
	public void setbirthDay(Date birthDate){
		this.birthDate = birthDate;
	}
	
	public void setPreference(Preference pref){
		this.pref = pref;
	}
	
	public void setMatch(boolean matched){
	this.matched = matched;
	}
	
	public String getName() {
		return name;
	}
	
	public char getGender(){
		return gender;
	}
	
	public Date getbirthDate(){
		return birthDate;
	}
	
	public Preference getPref(){
		return pref;
	}
	
	public boolean getMatch(){
		return matched;
	}
	
	public int compare(Student st){
		if(gender != st.gender){
		return 0;
		}
		
		comScore = (40 - pref.compare(st.pref)) + (60-birthDate.compare(st.birthDate)); 
		
		if (comScore < 0){
			return 0; 
			}
			else if (comScore > 100){
			return 100;
			}
		
		return comScore; 
	}
	
}