import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Sword extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private int speedy = 1;
	
	Image sword;
	
	
	public Sword(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public void update() {
		sword = new ImageIcon("Image/sword.png").getImage();
		
		
		if(Prince.dd == 1) {
			speedy = 0;
		}
		
		if(Prince.level == 5) {
			y += speedy;
			if(y < 293) {
				speedy = 1;
			}
			if(y > 383) {
				speedy = -1;
			}
		}
	}
	
	public void draw(Graphics2D g2d) {
		
			g2d.drawImage(sword,x,y,50,50,this);
		}
	
	
	public Rectangle getTouch() {
		return new Rectangle(x, y, 50, 50);
	}
}
