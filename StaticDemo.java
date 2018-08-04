import java.util.Scanner;
import static java.lang.System.out;
import static java.lang.Math.pow;
// Utility Class
//final class Validation{
// Utility Interface
interface Validation{
//	private Validation(){
//		
//	}
	static boolean isBlank(String str){
		if(str==null){
			return true;
		}
		if(str!=null && str.trim().length()==0){
			return true;
		}
		return false;
	}
}
class D{
	static{
		System.out.println("D Static Block Call");
	}
}
class Customer{
int id;  // Instance Variables
String name;
double balance;
static String offers;  // Class Variable
Customer(){
	System.out.println("I Wil call every time when object is created...");
}
static{
	//name = "Ram";
	offers = "50% Off";
	System.out.println("I am a Static Block and I call when class is loaded "+offers);
}
}
public class StaticDemo {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		pow(2, 3);
		String name = "Amit";
		//Validation v = new Validation();
		if(Validation.isBlank(name)){
			out.println("Name Can't Be Blank");
		}
		else{
			out.println("Correct Name "+name);
		}
		out.println("Enter the CLass Name to Load");
		String className = new Scanner(System.in).next();
		Class.forName(className); // Dynamically Loading a Class
		//System.out.println(Customer.offers);
		//Customer ram = new Customer();
		//Customer shyam = new Customer();
		

	}

}
