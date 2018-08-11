import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Enemy implements GameConstants {
	private int x;
	private int y;
	private int w;
	private int h;
	private int speed;
	private Image image;
	private int direction;
	
	
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public Enemy(int x, int speed) {
		this.x = x;
		this.y  = 50;
		this.w = this.h= 100;
		this.direction = Y_DIRECTION;
		this.speed = speed;
		image = new ImageIcon(Enemy.class.getResource(FIRE_IMAGE)).getImage();
		// TODO Auto-generated constructor stub
	}
	
	Enemy(){
		this.direction = X_DIRECTION;
		x = GWIDTH - 100;
		w = h = 100;
		y = FLOOR - h;
		speed = -5;
		image = new ImageIcon(Enemy.class.getResource(ENEMY_IMAGE)).getImage();
	}
	
	private void changeDirection(){
		if(y>=FLOOR-h){
			speed = speed * -1;
		}
		else
		if(y<50){
			speed = speed * -1;
		}
	}
	
	public void move(){
		if(direction==X_DIRECTION){
		if((x) <=0 -w ){
			x = GWIDTH;
		}
		x+=speed;
		}
		else
		if(direction ==Y_DIRECTION){	
			changeDirection();
			y+=speed;
		}
	}
	public void drawEnemy(Graphics g){
		g.drawImage(image,x ,y, w, h , null);
		move();
	}

}
