import java.awt.Color;
import java.awt.Graphics;

public class AIPaddle implements Paddle {
	double y,y1, yVel,y1Vel;
	boolean upAccel ,downAccel,wAccel,sAccel;
	final double SLOWSPEED = 0.94;
	int player,player1,x,x1;
	
	public AIPaddle(int players) {
		upAccel = false; 
		downAccel = false;
		wAccel = false;
		sAccel = false;
		y = 210; yVel = 0;
		y1 = 210; y1Vel = 0;
		if(players == 1) {
			x = 30;
			x1 = 650;
		}
		else {
			x = 650;
			x1 = 30;
		}
		}
	
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, (int) y, 20, 80);
		g.fillRect(x1, (int)y1, 20,80);
		
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
		
		if(y<=0) {
			y = 0;
		}
		else if(y >= 450) {
			y = 450;
		}
		
		if(yVel>=5) {
			yVel = 5;
		}
		else if(yVel <= -5) {
			yVel = -5;
		}
		
		if(wAccel) {
			y1 -= 2;
		}
		else if(sAccel) {
			y1 += 2;
		}
		else if(!wAccel && !sAccel) {
			y1Vel *= SLOWSPEED;
		}
		y1Vel += y1Vel;
		if(y1<=0) {
			y1 = 0;
		}
		else if(y1 >= 450) {
			y1 = 450;
		}
		
		if(y1Vel>=5) {
			y1Vel = 5;
		}
		else if(y1Vel <= -5) {
			y1Vel = -5;
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
	
	public void setWAccel(boolean input) {
		wAccel = input;
	}
	
	public void setSAccel(boolean input) {
		sAccel = input;
	}
	
	public int getY1() {
		return (int)y1;
	}
	
	

}
