import java.util.Scanner;
class ScannerIssues
{
public static void main(String args[]){
Scanner scanner = new Scanner(System.in);

System.out.println("Enter the Age ");
int age = scanner.nextInt();
System.out.println("Enter the Name ");
scanner.nextLine();
String name = scanner.nextLine();
System.out.println("Name is "+name+" Age is "+age);

Scanner scanner2 = new Scanner(System.in);
System.out.println("Enter the City ");
String city =scanner2.next();
System.out.println("City is "+city);
scanner.close();
scanner2.close();
}
}