import java.awt.Color;
import java.awt.Graphics;

public class HumanPaddle2 implements Paddle {
	double y,ySpeed;
	boolean upAccel,downAccel ,left,right;
	final double SLOWSPEED = 0.94;
	int player1,x;
	
	public HumanPaddle2(int players) {
		upAccel = false;
		downAccel = false;
		left = false;
		right = false;
		y = 210; ySpeed = 0;
		if(players == 1) {
			x = 650;
		}
		else {
			x = 30;
			}
		}
	
	public void draw(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(x, (int)y, 2,80);
		
	}
	
	public void move() {
		  if(upAccel) { 
			  y -= 2; 
			  }
		  else if(downAccel) {
			  y += 2; 
			  } 
		  else if(!upAccel && !downAccel) {
			  ySpeed *= SLOWSPEED;
			  } 
		  ySpeed += ySpeed;
		  
		  if( y <= 0) { 
			  y = 0; 
			  } 
		  else if(y >= 420) {
			  y = 420;
			  }
		  
		  if(ySpeed >= 5) {
			  ySpeed = 5;
			  } 
		  else if(ySpeed <= -5) {
			  ySpeed = -5;
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
		return(int)x;
	}


	

}
