import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Camera implements GameConstants{
private int x;
private int y;
private int w;
private int h;
BufferedImage image;
JFrame frame ;
private int speed;
public Camera(JFrame jframe){
	this.frame = jframe;
	speed = 4;
	loadImage();
}
public void drawCameraImage(Graphics g){
	BufferedImage subImage = image.getSubimage(x, y, GWIDTH, GHEIGHT);
	g.drawImage(subImage,0,0,GWIDTH,GHEIGHT,null);
}
public void left(){
	if(x>=4){
	x-=speed;
	}
}
public void right(){
	if(x<(MAX_WIDTH_IMAGE- GWIDTH)){
	x+=speed;
	}
}

private void loadImage(){
	try{
	image = ImageIO.read(Camera.class.getResource(CAMERA_BG));
	}
	catch(IOException e){
		JOptionPane.showMessageDialog(frame, "Something went Wrong, No Background Image Found");
		System.out.println(e);
		System.exit(0);
	}
	catch(IllegalArgumentException e){
		JOptionPane.showMessageDialog(frame, "Something went Wrong, No Background Image Found");
		System.out.println(e);
		System.exit(0);
	}
}
}
