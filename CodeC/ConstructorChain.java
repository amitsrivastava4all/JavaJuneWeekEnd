abstract class A{
	int x = 100;
	A(){
		System.out.println("A Default Cons");
	}
	A(int x){
		System.out.println("A PAram cons Call");
	}
}
class B extends A{
	int x = 200;
	B(){
		//super();
		System.out.println("B Default Cons");
	}
	B(int x){
		// super();
		super(100);
		int z = x + this.x + super.x ;
		System.out.println("B Param Cons");
	}
}
public class ConstructorChain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B b = new B(100);

	}

}
