import java.awt.Graphics;

public interface Board {
	public void draw(Graphics g);
	public void move();
	public int getY();
	public int getX();

}
