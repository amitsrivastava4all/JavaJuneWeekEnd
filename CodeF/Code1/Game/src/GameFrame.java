import javax.swing.JFrame;

public class GameFrame  extends JFrame implements GameConstants {
	GameFrame(){
		//setLocation(200, 100);
		
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle(TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(GWIDTH,GHEIGHT);
		Board board = new Board(this);
		this.add(board);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameFrame obj = new GameFrame();
		

	}

}
