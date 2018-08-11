import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Player implements GameConstants {
 private int x;
 private int y;
 private int w;
 private int h;
 private int speed;
 private Image image;
 private int force ;
 private boolean isJumped;
 
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



public int getForce() {
	return force;
}



public void setForce(int force) {
	this.force = force;
}



public boolean isJumped() {
	return isJumped;
}



public void setJumped(boolean isJumped) {
	this.isJumped = isJumped;
}



public void jump(){
	 if(!isJumped){
	 isJumped = true;
	 force = -15;
	 y+=force;
	 }
 }
 
 
 
 public void fall(){
	 if(y>=(FLOOR-h)){
		 isJumped = false;
		 y = (FLOOR - h);
	 }
	 if(y<(FLOOR - h)){
		 force += GRAVITY;
		 y+=force;
	 }
 }
 public void direction(int dir){
	 speed = 5;
	 speed = speed * dir;
 }
 public void move(){
	 x+=speed;
 }
 public Player(){
	 w = h  = 100;
	 y = FLOOR - h;
	 x = 100;
	 image = new ImageIcon(Player.class.getResource(PLAYER_IMAGE)).getImage();
 }
 public void drawPlayer(Graphics g){
	 g.drawImage(image, x, y,w,h ,null);
 }
 

}
