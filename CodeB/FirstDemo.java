import java.util.Scanner;

public class FirstDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("Enter the First Number");
		
		int a = scanner.nextInt() ;  // Local Var 100 \n
		System.out.println("Enter the Second Number");
		int b = scanner.nextInt() ; //200\n
		
		System.out.println("Enter the Full Name");
		scanner.nextLine();// \n eat
		String fullName = scanner.nextLine();
		System.out.println("Your Full Name is "+fullName);
		int c = a + b;
		System.out.println("Sum is  "+c);
		
		Scanner scanner2 =new Scanner(System.in);
		System.out.println("Enter the Name");
		String name = scanner2.nextLine();
		System.out.println("Name is "+name);
		scanner.close();
		scanner2.close();
		

	}

}
