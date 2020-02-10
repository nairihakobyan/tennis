import java.awt.Color;
import java.awt.Graphics;

public class HumanPaddle implements Paddle {
	double y, yVel;
	boolean upAccel ,downAccel, left,right;
	final double SLOWSPEED = 0.94;
	int player,x;
	
	public HumanPaddle(int players) {
		upAccel = false; 
		downAccel = false;
		left = false;
		right = false;
		y = 210; yVel = 0;
		if(players == 1) {
			x = 30;
		}
		else {
			x = 650;
		}
		}
	
	public void draw(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect((int)x,(int) y,2, 80);
		
	}
	
	public void move() {
		if(upAccel) {
			y -= 5;
		}
		else if(downAccel) {
			y += 5;
		}
		else if(!upAccel && !downAccel) {
			yVel *= SLOWSPEED;
		}
		yVel += yVel;
		
		if(y <= 0) {
			y = 0;
		}
		else if(y >= 420) {
			y = 420;
		}
		
		if(yVel >= 5) {
			yVel = 5;
		}
		else if(yVel <= -5) {
			yVel = -5;
		}
		
		if(right) {
			x += 4;
		}
		else if(left) {
			x -= 4;
		}
		
		else if(!left && !right) {
			yVel *= SLOWSPEED;
		}
	}
	
	
	
	public void setUpAccel(boolean input) {
		upAccel = input;
	}
	
	public void setDownAccel(boolean input) {
		downAccel = input;
	}
	
	public void setLeft(boolean input) {
		left = input;
	}
	
	public void setRight(boolean input) {
		right = input;
	}
	
	public int getY() {
		return (int)y;
	}
	
	
	public int getX() {
		return (int)x;
	}
	
	
	
	
	

}
