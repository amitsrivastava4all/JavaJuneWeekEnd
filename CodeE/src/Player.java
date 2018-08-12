import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Player extends Sprite implements GameConstants {

 private int force ;
 private boolean isJumped;
 
 

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
