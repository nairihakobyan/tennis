import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	
	double y,yVel;
	double x,xVel;
	
	
	public Ball() {
		x = 350;
		y = 250;
		xVel = 2;
		yVel = 1;
	} 
	
	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillOval((int)x-10, (int)y-10, 20, 20);
	}
	
	public void checkPadlleCollision(Paddle p1,Paddle p2) {
		if(x <= 50 ) {
			if(y >= p1.getY() && y <= p1.getY()+70) {
				xVel = -xVel;
			}
		}
		else if(x >= 650) {
			if(y >= p2.getY() && y <= p2.getY()+70) {
				xVel = -xVel;
				}
			}
	}
	
	
	public void move() {
		x += xVel;
		y += yVel;
		if(y <= 10) {
			yVel = -yVel;
			
		}
		else if(y >= 480) {
			yVel = -yVel;
		}
	}
	
	public int getX() {
		return (int)x;
	}
	
	public int getY() {
		return (int)y;
	}
	
	
}
