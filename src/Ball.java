import java.awt.Color;
import java.awt.Graphics; 

public class Ball {
	
	double y,yVel;
	double x,xVel;
	
	
	
	public Ball() {
		x = 350;
		y = 250;
		xVel = randomDirection();
		yVel = randomSpeed() ;
	} 
	
	public double randomSpeed() {
		return (Math.random() * 1 + 1);
	}
	public int randomDirection() {
		int rand =  (int)(Math.random() * 2 );
		if(rand == 1) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillRoundRect((int)x,(int) y, 20, 20, 20, 20);
	}
	
	public void checkPadlleCollision(Board p1,Board p2) {
		if(x <= p1.getX()+1) {
			if(y >= p1.getY() && y <= p1.getY() + 80) {
				xVel = -xVel;
				
			}
		}
		else if(x >= 628) {
			if(y >= p2.getY() && y <= p2.getY() + 80) {
				xVel = -xVel;
			}
			}
	}
	
	
	public void move() {
		x += xVel;
		y += yVel;
		if(y <= 0) {
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
