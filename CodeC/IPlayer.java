public abstract interface IPlayer{
//public interface IPlayer {
	//public void defaultPower();
	public static final int MAX_JUMP = 10;
	int MAX_POWER = 100;
	//void jump();
	public abstract void jump();
	void punch(int power);
	void run();
	default void roundKick(){
		
	}
	public default void defaultPower(){
		System.out.println("10% Power by Default");
		
	}

}
