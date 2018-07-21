import com.brainmentors.cms.students.views.Student;

public class TestStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ff;
		int marks [] = {100,90,70};
		Student ram =new Student(1001,"ram",marks);
		
		ram.print();
		ram.setName(ram.getName()+" Kumar");
		System.out.println("Ram Updated Name is "+ram.getName());
		System.out.println("*********************************");
		
//		ram.takeInput(1001, "Ram", marks);
//		ram.print();
//		ram.rollno = -1001;
//		int marks [] = {-100,-200,-300};
//		ram.marks  = marks;
//		System.out.println(ram.rollno);
//		for(int mark : marks){
//			System.out.println(mark);
//		}
	

	}

}
