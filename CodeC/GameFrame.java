import javax.swing.JFrame;

public class GameFrame  extends JFrame {
	GameFrame(){
		setLocation(200, 100);
		//setLocationRelativeTo(null);
		setTitle("Game -2018");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameFrame obj = new GameFrame();
		

	}

}
