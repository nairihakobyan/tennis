import java.awt.Color;
import java.awt.Graphics;

public class HumanPaddle2 implements Paddle {
	double y,yVel;
	boolean wAccel,sAccel;
	final double SLOWSPEED = 0.94;
	int player1,x;
	
	public HumanPaddle2(int players) {
		wAccel = false;
		sAccel = false;
		y = 210; yVel = 0;
		if(players == 1) {
			x = 650;
		}
		else {
			x = 30;
			}
		}
	
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, (int)y, 20,80);
		
	}
	
	public void move() {
		  if(wAccel) { 
			  y -= 2; 
			  }
		  else if(sAccel) {
			  y += 2; 
			  } 
		  else if(!wAccel && !sAccel) {
			  yVel *= SLOWSPEED;
			  } 
		  yVel += yVel;
		  
		  if( y <= 0) { 
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
	
	
	public void setWAccel(boolean input) {
		wAccel = input;
	}
	
	public void setSAccel(boolean input) {
		sAccel = input;
	}
	
	public int getY() {
		return (int)y;
	}


	

}
