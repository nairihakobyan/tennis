import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Tennis extends Applet  implements Runnable,KeyListener {
	private static final long serialVersionUID = 1L;
	final int HEIGHT = 500, WIDTH = 700;
	Thread thread;
	HumanPaddle p1;
	HumanPaddle2 p2;
	Ball b1;
	
	
	public void init() {
		this.resize(WIDTH, HEIGHT);
		this.addKeyListener(this);
		
		p1 = new HumanPaddle(1);
		p2 = new HumanPaddle2(1);
		b1 = new Ball();
		thread = new Thread(this);
		thread.start();
		
		 
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		if(b1.getX()< 0 || b1.getX()>= 700 ) {
			g.setColor(Color.RED);
			g.drawString("Game Over", 350, 250);
		}
		else {
			p1.draw(g);
			p2.draw(g);
			b1.draw(g);
		}
		
	}
	
	public void update(Graphics g) {
		paint(g);
	}
	
	public void run() {
		for(;;) {
			p1.move();
			p2.move();
			b1.move();
			b1.checkPadlleCollision(p1, p2);
			repaint();
//			setFocusable(true);
//			requestFocusInWindow();
			try 
			{
				Thread.sleep(10); 
			} 
			catch (InterruptedException e) {
			  e.printStackTrace(); }
			
			}
		
	}

	
	public void keyPressed(KeyEvent ev) {
		if(ev.getKeyCode()== KeyEvent.VK_UP) {
			p1.setUpAccel(true);
		}
		else if(ev.getKeyCode()== KeyEvent.VK_DOWN) {
			p1.setDownAccel(true);	
		}
		
		if(ev.getKeyCode() == KeyEvent.VK_W) {
			p2.setWAccel(true);
		}
		else if(ev.getKeyCode() == KeyEvent.VK_S) {
			p2.setSAccel(true);
		}
		
	}

	
	public void keyReleased(KeyEvent ev) {
		
		if(ev.getKeyCode()== KeyEvent.VK_UP) {
			p1.setUpAccel(false);
		}
		else if(ev.getKeyCode()== KeyEvent.VK_DOWN) {
			p1.setDownAccel(false);
		}
		
		if(ev.getKeyCode() == KeyEvent.VK_W) {
			p2.setWAccel(false);
		}
		else if(ev.getKeyCode() == KeyEvent.VK_S) {
			p2.setSAccel(false);
		}
		
	}

	
	public void keyTyped(KeyEvent ev) {
		if(ev.getKeyCode()== KeyEvent.VK_UP) {

			
		}
		else if(ev.getKeyCode()== KeyEvent.VK_DOWN) {
			
		}
		
	}

}
