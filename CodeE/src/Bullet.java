import java.awt.Color;
import java.awt.Graphics;

public class Bullet extends Sprite implements GameConstants{
	private boolean isVisible;
	public Bullet(int x, int y){
		this.x = x ;
		this.y = y;
		this.h = this.w = 12;
		this.speed = 12;
		this.isVisible = true;
	}
	public void move(){
		if(x>=GWIDTH){
			this.isVisible = false;
		}
		x+=speed;
	}
	
	public boolean isVisible() {
		return isVisible;
	}
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	public void drawBullet(Graphics g){
		g.setColor(Color.BLACK);
		g.fillOval(x,y,w,h);
		move();
	}
}
