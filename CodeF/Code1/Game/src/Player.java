import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Player extends Sprite implements GameConstants, PlayerStates {
private int state;
 private int force ;
 private boolean isJumped;
 BufferedImage image;
 int attackPower;
 int life;
 BufferedImage walk[] = new BufferedImage[4];
 BufferedImage punch[] = new BufferedImage[4];
 private void loadWalk(){
	 walk[0] = image.getSubimage(4,9,43-4,95-9);
	  walk[1] = image.getSubimage(76,11,115-76,95-11);
	  walk[2] = image.getSubimage(143,6,186-143,95-6); 
	  walk[3] = image.getSubimage(212,13,251-212,95-13); 
 }
 private void loadPunch() {
	 punch[0] = image.getSubimage(4,422,48-4,511-422);
	 punch[1] = image.getSubimage(71,422,119-71,509-422);
	 punch[2] = image.getSubimage(136,420,204-136,509-420);
	 punch[3] = image.getSubimage(223,424,273-223,509-424);
	 
 }
 int walkIndex = 0;
 int walkDelay = 0;
public void defaultWalk(Graphics g){
	if(walkIndex>=4) {
		walkIndex=0;
	}
	g.drawImage(walk[walkIndex], x, y, w, h, null);
	if(walkDelay>=3) {
		walkDelay=0;
		walkIndex++;
	}
	walkDelay++;
}
int punchIndex = 0;
int punchDelay = 0;
public void punch(Graphics g){
	if(punchIndex>=4) {
		punchIndex=0;
		state = WALK;
	}
	g.drawImage(punch[punchIndex], x, y, w, h, null);
	if(punchDelay>=3) {
		punchIndex++;
		punchDelay = 0;
	}
	punchDelay++;
	
}
public void kick(){

}

public int getState() {
	return state;
}
public void setState(int state) {
	this.state = state;
}
private void loadPlayerSprite(){
	try{
	image = ImageIO.read(Player.class.getResource("ryu.gif"));
	}
	catch(Exception e){
	System.out.println("Problem in Player Sprite Sheet Loading"+e);
	}
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
	 life = 100;
	 attackPower = 0;
	 state = WALK;
	 w = h  = 100;
	 y = FLOOR - h;
	 x = 100;
	 loadPlayerSprite();
	 loadWalk();
	 loadPunch();
	 //image = new ImageIcon(Player.class.getResource(PLAYER_IMAGE)).getImage();
 }
 public void drawPlayer(Graphics g){
	 if(state == WALK) {
		 //walkIndex=0;
		 defaultWalk(g);
	 }
	 else
	 if(state ==PUNCH) {
		 attackPower = 3;
		// punchIndex = 0;
		 punch(g);
	 }
	// g.drawImage(image, x, y,w,h ,null);
 }
 

}
