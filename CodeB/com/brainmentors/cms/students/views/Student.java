package com.brainmentors.cms.students.views;

public class Student {
	private int rollno;  // Member Var
	private String name;
	private final int TOTAL_SUBJECTS= 3;
	private int marks [] = new int[TOTAL_SUBJECTS];
	String collegeName;
	
	public int percentage(){
		return totalMarks()/TOTAL_SUBJECTS;
	}
	public String grade(){
		return percentage()>=90?"A Grade ":" B Grade";
	}
	
	public int totalMarks(){
		int sum = 0;
		for(int mark:marks){
			sum+=mark;
		}
		return sum;
	}
	
	private int getRollNoFromDB(){
		return 1000;
	}
	
//	{
//		rollno = getRollNoFromDB();
//		System.out.println("Rollno "+rollno);
//		System.out.println("Name "+name);
//		System.out.println(" I am Init Block Pre Constructor");
//	}
	// Param Constructor
	public Student(int rollno , String name , int marks[]){
		this();
		if(rollno<=0){
			System.out.println("Invalid Rollno");
			return;
			}
			
			for(int mark:marks){
				if(mark<0){
					System.out.println("Invalid Marks");
					return ;
				}
			}
		this.rollno = rollno + collegeName.length();
		this.name =  name;
		this.marks = marks;
	}
	
	
	
	public int getRollno() {
		return rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getMarks() {
		return marks;
	}

	public void setMarks(int[] marks) {
		this.marks = marks;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	// Default Constructor
	Student(){
		collegeName = "SRCC";
//		rollno =getRollNoFromDB();
//		//rollno = 1001;
//		name  = "Ram";
//		int newMarks[] = {90,88,66};
//		marks = newMarks;
//		System.out.println("Rollno "+rollno);
//		System.out.println("Name "+name);
//		System.out.println("Default Constructor Call....");
	}
	
	// Local Var
	/*public void takeInput(int rollno, String name, int marks[]){
		if(rollno<=0){
		System.out.println("Invalid Rollno");
		return;
		}
		
		for(int mark:marks){
			if(mark<0){
				System.out.println("Invalid Marks");
				return ;
			}
		}
		this.rollno = rollno;
		this.name = name;
		this.marks = marks;
	}*/
	
	public void print(){
		System.out.println("College Name "+collegeName);
		System.out.println("Rollno "+rollno);
		System.out.println("Name "+name);
		System.out.println("Marks ");
		for(int mark : marks){
			System.out.println(mark);
		}
		System.out.println("Total Marks "+totalMarks());
		System.out.println("Percentage "+percentage());
		System.out.println("Grade "+grade());
	}
	
	
	
}
