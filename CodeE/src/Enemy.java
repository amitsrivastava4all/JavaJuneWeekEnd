import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Enemy extends Sprite implements GameConstants {
	
	private int life =MAX_LIFE;
	
	private int direction;
	
	
	
	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
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
		if(x <=(0 -w) ){
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
