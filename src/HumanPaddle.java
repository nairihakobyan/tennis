import java.awt.Color;
import java.awt.Graphics;

public class HumanPaddle implements Paddle {
	double y, yVel;
	boolean upAccel ,downAccel;
	final double SLOWSPEED = 0.94;
	int player,x;
	
	public HumanPaddle(int players) {
		upAccel = false; 
		downAccel = false;
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
		g.fillRect(x, (int) y, 20, 80);
		
	}
	
	public void move() {
		if(upAccel) {
			y -= 2;
		}
		else if(downAccel) {
			y += 2;
		}
		else if(!upAccel && !downAccel) {
			yVel *= SLOWSPEED;
		}
		yVel += yVel;
		
		if(y <= 0) {
			y = 0;
		}
		else if(y >= 450) {
			y = 450;
		}
		
		if(yVel >= 5) {
			yVel = 5;
		}
		else if(yVel <= -5) {
			yVel = -5;
		}
	}
	
	
	
	public void setUpAccel(boolean input) {
		upAccel = input;
	}
	
	public void setDownAccel(boolean input) {
		downAccel = input;
	}
	
	public int getY() {
		return (int)y;
	}
	
	
	
	

}
