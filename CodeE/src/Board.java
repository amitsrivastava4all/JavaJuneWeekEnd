import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements GameConstants {
	private Image bgImage;
	private int score;
	private Player player;
	private Timer timer;
	private Enemy enemy;
	private Enemy enimes[] = new Enemy[MAX_ENEMY];
	private ArrayList<Bullet> bullets = new ArrayList<>();
	private boolean collision(){
		int xDistance = Math.abs(player.getX() - enemy.getX());
		int yDistance = Math.abs(player.getY() - enemy.getY());
		System.out.println(player.getX()+" "+enemy.getX());
		System.out.println("Y "+player.getY()+" "+enemy.getY());
		return (xDistance<=player.getW()-50) && (yDistance<=player.getH()-50);
	}
	private void loadEnemy(){
		int x = 200;
		int speed = 1;
		for(int i = 0 ; i<MAX_ENEMY; i++){
			enimes[i] = new Enemy(x, speed);
			speed+=2;
			x+=GAP;
		}
	}
	
	private void printEnemy(Graphics g){
		for(Enemy enemy: enimes){
			enemy.drawEnemy(g);
			enemy.move();
		}
	}
	
	private void addBullet(){
		int bulletX = (player.getX()+player.getW()/2);
		int bulletY = (player.getY()+player.getH()/2);
		Bullet bullet = new Bullet(bulletX, bulletY);
		bullets.add(bullet);
	}
	
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
				if(e.getKeyCode()==KeyEvent.VK_SPACE){
					player.jump();
				}
				if(e.getKeyCode()==KeyEvent.VK_F){
					addBullet();
				}
				
				//System.out.println(" Press "+e.getKeyChar()+" "+" "+e.getKeyCode());
				
			}
		};
		this.addKeyListener(l);
	}
	private void printBullets(Graphics g){
		if(bullets.size()>0){
		for(Bullet bullet : bullets){
			if(bullet.isVisible()){
				bullet.drawBullet(g);
			}
		}
		}
	}
	
	private void gameLoop(){
		ActionListener l = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				repaint();
				player.move();
				player.fall();
			}
		};
		timer = new Timer(DELAY,l);
		timer.start();
	}
	public Board(){
		setSize(GWIDTH, GHEIGHT);
		 bgImage = new ImageIcon(Board.class.getResource(BACKGROUND)).getImage();
		 loadEnemy();
		 player = new Player();
		 enemy = new Enemy();
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
	private void gameOver(Graphics g){
		g.setFont(new Font("Arial",Font.BOLD, 34));
		g.setColor(Color.RED);
		g.drawString("Game Over", GWIDTH/2, GHEIGHT/2);
	}
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		drawBackGround(g);
		drawScore(g);
		player.drawPlayer(g);
		enemy.drawEnemy(g);
		printEnemy(g);
		printBullets(g);
		if(collision()){
			gameOver(g);
			timer.stop();
		}
		//System.out.println("Painting is Going On....");
	}
	
	

}
