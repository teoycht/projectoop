import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fire extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	
	Image fire;
	
	public Fire(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public void update() {
		fire = new ImageIcon("Image/fire.gif").getImage();
	}
	
	public void draw(Graphics2D g2d) {
		g2d.drawImage(fire,x,y,50,50,this);
	}
	
	public Rectangle getTouch() {
		return new Rectangle(x+10, y+10, 30, 20);
	}
}

class ControlFire {
	static LinkedList<Fire> f = new LinkedList<>();
	Fire temp;
	
	public ControlFire() {
		addFire(new Fire(23,233));
		addFire(new Fire(53,263));
		addFire(new Fire(83,293));
		addFire(new Fire(113,323));
		addFire(new Fire(143,353));
		addFire(new Fire(173,383));
		addFire(new Fire(200,23));
		addFire(new Fire(170,23));
		addFire(new Fire(140,23));
		addFire(new Fire(110,23));
		addFire(new Fire(80,23));
		
		
		for(int i = 0,a = 203; i < 10; i++) {
			addFire(new Fire(a,413));
			a += 30;
		}
	}
	
	public void draw(Graphics2D g2d) {
		for(int i = 0; i< f.size(); i++) {
			temp = f.get(i);
			temp.draw(g2d);
		}
	}
	
	public void update() {
		for(int i = 0; i< f.size(); i++) {
			temp = f.get(i);
			temp.update();
		}
	}
	
	public void addFire(Fire fire) {
		f.add(fire);
	}
	
	public void removeFire(Fire fire) {
		f.remove(fire);
	}
	
	public static LinkedList<Fire> getFireTouch() {
		return f;
	}
}
