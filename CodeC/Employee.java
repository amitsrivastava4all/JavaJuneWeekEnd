interface MathOpr{
	
	static int add(int x, int y){
		return x + y;
	}
	static int mul(int x, int y){
		return x * y;
	}
	
}
public class Employee {
	int id;
	String name;
	static int empCounter;
	Employee(int id , String name){
		this.id =id;
		this.name = name;
		empCounter++;
		System.out.println("Constructor call "+empCounter);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MathOpr.add(100, 200);
		//MathOpr w = new MathOpr();
		Employee ram = new Employee(1001, "Ram");
		Employee ramesh = new Employee(1002, "Ramesh");
		Employee shyam= new Employee(1003, "Shyam");
		Employee sohan = new Employee(1004, "Sohan");
		Employee mohan = new Employee(1005, "Mohan");
		Employee tim = new Employee(1006, "Tim");
		

	}

}
