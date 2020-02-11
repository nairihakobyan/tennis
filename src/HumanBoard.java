import java.awt.Color;
import java.awt.Graphics;

public class HumanBoard implements Board {
	double y, yVel;
	boolean up  ,down , left,right;
	final double SLOWSPEED = 0.94;
	int player,x;
	
	public HumanBoard(int players) {
		up = false; 
		down = false;
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
		if(up) {
			y -= 3;
		}
		else if(down) {
			y += 3;
		}
		else if(!up && !down) {
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
		up = input;
	}
	
	public void setDownAccel(boolean input) {
		down = input;
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
