
public class TestCricketer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cricketer sachin = new Cricketer();
//		System.out.println("Name is "+sachin.name);
//		System.out.println("Strike Rate is "+sachin.strikeRate);
//		System.out.println("No of Hundreds is "+sachin.numberOfHundred);
//		System.out.println("NO of Ducks is "+sachin.noOfDucks);
//		sachin.name = "Sachin";
//		sachin.noOfDucks = 10;
//		sachin.numberOfHundred=100;
//		sachin.strikeRate=110;
		sachin.takeInput(100, "Sachin", 100, 10);
		sachin.print();
		System.out.println("***************************************");
		Cricketer dhoni = new Cricketer();
//		dhoni.name="M.S";
//		dhoni.noOfDucks = 5;
//		dhoni.numberOfHundred = 70;
//		dhoni.strikeRate=130;
		dhoni.takeInput(70, "M.S", 130, 5);
		dhoni.print();
//		System.out.println("Name is "+sachin.name);
//		System.out.println("Strike Rate is "+sachin.strikeRate);
//		System.out.println("No of Hundreds is "+sachin.numberOfHundred);
//		System.out.println("NO of Ducks is "+sachin.noOfDucks);
//		
		int x = 100;

	}

}
