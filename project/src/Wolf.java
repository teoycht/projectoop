import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Wolf extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private int speedx = 1;
	private int speedy = 1;
	
	int n = 0;
	
	Image wolf_left;
	Image wolf_right;
	Image wolf_down;
	Image wolf_up;
	Image wolf_over;
	
	public Wolf(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public void update() {
		wolf_left = new ImageIcon("Image/wolf_left.gif").getImage();
		wolf_right = new ImageIcon("Image/wolf_right.gif").getImage();
		wolf_down = new ImageIcon("Image/wolf_down.gif").getImage();
		wolf_up = new ImageIcon("Image/wolf_up.gif").getImage();
		wolf_over = new ImageIcon("Image/wolf_over.gif").getImage();
		
		if(Prince.dd == 1 || Prince.score == 10) {
			speedx = 0;
			speedy = 0;
		}
		
		if(Prince.level == 1 || Prince.level == 4) {
			x += speedx;
			if(x < 45) {
				speedx = 1;
				n = 1;
			}
			if(x > 445) {
				speedx = -1;
				n = 3;
			}
		}
		
		if(Prince.level == 2) {
			y += speedy;
			if(y < 53) {
				speedy = 1;
				n = 2;
			}
			if(y > 233) {
				speedy = -1;
				n = 4;
			}
		}
		
		if(Prince.level == 3) {
			x += speedx;
			if(x < 145) {
				speedx = 1;
				n = 1;
			}
			if(x > 445) {
				speedx = -1;
				n = 3;
			}
		}
		
		if(Prince.level == 5) {
			y += speedy;
			if(y < 23) {
				speedy = 1;
				n = 2;
				}
			if(y > 383) {
				speedy = -1;
				n = 4;
			}
		}
	}
	
	public void draw(Graphics2D g2d) {
		if(Prince.dd == 1 || Prince.score == 10) {
			g2d.drawImage(wolf_over,x,y,50,50,this);
		}else {
			if(n == 0) {
				g2d.drawImage(wolf_right,x,y,50,50,this);
			}
			if(n == 1) {
				g2d.drawImage(wolf_right,x,y,50,50,this);
			}
			if(n == 2) {
				g2d.drawImage(wolf_down,x,y,50,50,this);
			}
			if(n == 3) {
				g2d.drawImage(wolf_left,x,y,50,50,this);
			}
			if(n == 4) {
				g2d.drawImage(wolf_up,x,y,50,50,this);
			}
		}	
	}
	
	public Rectangle getTouch() {
		return new Rectangle(x, y, 40, 40);
	}
}
