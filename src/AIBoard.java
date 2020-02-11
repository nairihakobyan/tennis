import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

public class AIBoard implements Board {
	double y,yVel;
	boolean upAccel ,downAccel,wAccel,sAccel;
	final double SLOWSPEED = 0.94;
	int player,x;
	Ball b1;
	JButton button;
	
	public AIBoard(int players, Ball b) {
		upAccel = false; 
		downAccel = false;
		b1 = b;
		y = 210; yVel = 0;
		if(players == 1) {
			x = 30;
		}
		else {
			x = 650;
		}
		}
	
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, (int) y, 2, 80);
		
	}
	
	public void move() {
		y = b1.getY()-30;
		
		
		if(y<=0) {
			y = 0;
		}
		else if(y >= 420) {
			y = 420;
		}
		
//		if(yVel>=5) {
//			yVel = 5;
//		}
//		else if(yVel <= -5) {
//			yVel = -5;
//		}
		
		
	}
	
	
	
	
	
	public int getY() {
		return (int)y;
	}
	
	
	

	
	public int getX() {
		return 0;
	}
	
	

}
