//import java.lang.*;
import java.util.Scanner;
class InputDemo{
public static void main(String args[])
{
Scanner scanner =  new Scanner(System.in);
System.out.println("Enter the Name ");
//String name = scanner.next();
String name = scanner.nextLine();
System.out.println("Name is "+name);
System.out.println("Enter the Age ");
int age = scanner.nextInt();
System.out.println("Age is "+age);
System.out.println("Enter the Salary ");
double salary = scanner.nextDouble();
System.out.println("Salary is "+salary);
scanner.close();
//String name = System.in.read();

}

}