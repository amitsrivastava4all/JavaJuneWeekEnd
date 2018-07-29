interface X
{
	int Q = 100;
	void show();
	default void print(){
		System.out.println("X Print ");
	}
}
interface Y{
	int Q = 200;
	void show();
	default void print(){
		System.out.println("Y Print..");
	}
}
interface Z extends X, Y{
	@Override
	default void print(){
		X.super.print();
		Y.super.print();
	}
}
class Z1 implements Z{
	public void show(){
		System.out.println("Z1 show...");
	}
}
public class InterfaceMulti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Z1 obj = new Z1();
		obj.print();
		

	}

}
