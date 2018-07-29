import java.awt.event.WindowListener;

//abstract class Player implements IPlayer{
//	public void defaultPower(){
//		System.out.println("10% Power by Default");
//		
//	}
//	@Override
//	public void roundKick() {}
//}
interface ExtraPowerPlayer{
	void hide();
}
interface HybridPlayer extends IPlayer, ExtraPowerPlayer{
	
}
class Ken implements IPlayer, ExtraPowerPlayer{

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void punch(int power) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		System.out.println("Hide for 2 Sec");
	}
	
}

public class Ryu implements IPlayer{
	@Override
	public void jump(){
		System.out.println("JUMP High");
	}
	@Override
	public void punch(int attack){
		System.out.println("Punch "+attack);
	}
	@Override
	public void run(){
		System.out.println("Run ...");
	}
	public static void main(String[] args) {
		//WindowListener w ;
		//WindowAdapter w1;
		
		Ryu ryu = new Ryu();
		ryu.jump();
		ryu.punch(20);
		ryu.run();
	}
	
}
