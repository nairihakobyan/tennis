import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image; 
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
 

public class Tennis extends Applet  implements Runnable,KeyListener {
	
	private static final long serialVersionUID = 1L;
	
	
	final int HEIGHT = 500, WIDTH = 700;
	Thread thread;
	HumanBoard p1;
	AIBoard p2;
	Ball b1;  
	boolean gameStart;
	Graphics gf;
	Image img;
	 
	
	
	  
	
	
	public void init() {
		this.resize(WIDTH, HEIGHT);
		this.addKeyListener(this);
		 
		gameStart = false;
		
		p1 = new HumanBoard(1);
		b1 = new Ball();
		p2 = new AIBoard(2,b1);
		
		img = createImage(WIDTH,HEIGHT);
		gf = img.getGraphics();
		
		thread = new Thread(this);
		thread.start();
		
		
		 
	}
	
	public void paint(Graphics g) {
		
		gf.setColor(Color.black);
		gf.fillRect(0, 0, WIDTH, HEIGHT);
		
		
		if(b1.getX()< 0 || b1.getX()>= 700 ) {
			gf.setColor(Color.RED);
			gf.drawString("Game Over", 350, 250);
		}
		else {
			p1.draw(gf);
			p2.draw(gf);
			b1.draw(gf);
		}
		
		if(!gameStart) {
			gf.setColor(Color.WHITE);
			gf.drawString("Tennis", 340, 100);
			gf.drawString("Press Enter to start",310,120);
		}
		g.drawImage(img, 0, 0, this);
	}
	
	public void update(Graphics g) {
		paint(g);
	}
	
	public void run() {
		for(;;) {
			if(gameStart) {
			p1.move();
			p2.move();
			b1.move();
			}
			
			
			b1.checkPadlleCollision(p1, p2);
			repaint();
			try 
			{
				Thread.sleep(10); 
			} 
			catch (InterruptedException e) {
			  e.printStackTrace(); }
			
			}
		
	}

	
	public void keyPressed(KeyEvent ev) {
		
		
		if(ev.getKeyCode() == KeyEvent.VK_W) {
			p1.setUpAccel(true);
		}
		else if(ev.getKeyCode() == KeyEvent.VK_S) {
			p1.setDownAccel(true);
		}
		
		if(ev.getKeyCode() == KeyEvent.VK_D) {
			 p1.setRight(true);
		}
		else if(ev.getKeyCode() == KeyEvent.VK_A) {
			p1.setLeft(true);
		}
		else if(ev.getKeyCode()== KeyEvent.VK_ENTER) {
			gameStart = true;
		}
		
		
	}
	

	
	public void keyReleased(KeyEvent ev) {
		 
		if(ev.getKeyCode() == KeyEvent.VK_W) {
			p1.setUpAccel(false);
		}
		else if(ev.getKeyCode() == KeyEvent.VK_S) {
			p1.setDownAccel(false);
		}
		
		if(ev.getKeyCode() == KeyEvent.VK_D) {
			p1.setRight(false);
		}
		else if(ev.getKeyCode() == KeyEvent.VK_A) {
			p1.setLeft(false);
		}
		
	}

	
	public void keyTyped(KeyEvent ev) {
	 }

	 
	 
}


 
