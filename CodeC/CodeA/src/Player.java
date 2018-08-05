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
 public void direction(int dir){
	 speed = 3;
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
