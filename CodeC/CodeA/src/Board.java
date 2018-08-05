import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements GameConstants {
	private Image bgImage;
	private int score;
	private Player player;
	private Timer timer;
	
	private void bindEvents(){
		KeyListener l = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(" Type "+e.getKeyChar()+" "+" "+e.getKeyCode());
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				player.direction(0);
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_LEFT){
					player.direction(-1);
				}
				if(e.getKeyCode()==KeyEvent.VK_RIGHT){
					player.direction(1);
				}
				
				//System.out.println(" Press "+e.getKeyChar()+" "+" "+e.getKeyCode());
				
			}
		};
		this.addKeyListener(l);
	}
	
	private void gameLoop(){
		ActionListener l = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				repaint();
				player.move();
			}
		};
		timer = new Timer(DELAY,l);
		timer.start();
	}
	public Board(){
		setSize(GWIDTH, GHEIGHT);
		 bgImage = new ImageIcon(Board.class.getResource(BACKGROUND)).getImage();
		 player = new Player();
		 setFocusable(true);
		 bindEvents();
		 gameLoop();
		//setBackground(Color.BLACK);
		
	}
	private void drawScore(Graphics g){
		g.setColor(Color.RED);
		g.setFont(new Font("Arial",Font.BOLD,26));
		g.drawString("Score is "+score,GWIDTH-200,50);
	}
	private void drawBackGround(Graphics g){
		g.drawImage(bgImage, 0, 0, GWIDTH, GHEIGHT, null);
	}
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		drawBackGround(g);
		drawScore(g);
		player.drawPlayer(g);
		//System.out.println("Painting is Going On....");
	}
	
	

}
