import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Clock extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	Image clock;
	
	public Clock(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public void update() {
		clock = new ImageIcon("Image/clock.png").getImage();
	}
	
	public void draw(Graphics2D g2d) {
			g2d.drawImage(clock,x,y,50,50,this);
	}
	
	public Rectangle getTouch() {
		return new Rectangle(x+5, y+5, 40, 40);
	}
}

class ControlClock {
	static LinkedList<Clock> cl = new LinkedList<>();
	Clock temp;
	
	public ControlClock() {
		addClock(new Clock(263,113));
	}
	
	public void draw(Graphics2D g2d) {
		for(int i = 0; i < cl.size(); i++) {
			temp = cl.get(i);
			temp.draw(g2d);
		}
	}
	
	public void update() {
		for(int i = 0; i < cl.size(); i++) {
			if (Playy.tcl <= 0){
				cl.remove(temp);
			}else{
				temp = cl.get(i);
			}
			temp.update();
		}
	}
	
	public void addClock(Clock clock) {
		cl.add(clock);
	}
	
	public void removeClock(Clock clock) {
		cl.remove(clock);
	}
	
	public static LinkedList<Clock> getClockTouch() {
		return cl;
	}
}
