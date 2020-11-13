import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Prince extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Timer timeritem;
	
	private int x;
	private int y;
	
	int ti = 20;
	int xtemp;
	int ytemp;
	int speeditem = 0;
	
	private int speedx = 0;
	private int speedy = 0;
	
	private LinkedList<Wolf> w1 = ControlWolf1.getWolfTouch();
	private LinkedList<Wolf> w2 = ControlWolf2.getWolfTouch();
	private LinkedList<Wolf> w3 = ControlWolf3.getWolfTouch();
	private LinkedList<Wolf> w4 = ControlWolf4.getWolfTouch();
	private LinkedList<Wolf> w5 = ControlWolf5.getWolfTouch();
	
	private LinkedList<Tree> t1 = ControlTree1.getTreeTouch();
	private LinkedList<Tree> t2 = ControlTree2.getTreeTouch();
	private LinkedList<Tree> t3 = ControlTree3.getTreeTouch();
	private LinkedList<Tree> t4 = ControlTree4.getTreeTouch();
	private LinkedList<Tree> t5 = ControlTree5.getTreeTouch();
	
	private LinkedList<Sword> s1 = ControlSword1.getSwordTouch();
	private LinkedList<Sword> s2 = ControlSword2.getSwordTouch();
	private LinkedList<Sword> s3 = ControlSword3.getSwordTouch();
	private LinkedList<Sword> s4 = ControlSword4.getSwordTouch();
	private LinkedList<Sword> s5 = ControlSword5.getSwordTouch();
	
	private LinkedList<Fire> f = ControlFire.getFireTouch();
	
	private LinkedList<Clock> cl = ControlClock.getClockTouch();
	
	private LinkedList<Item> it = ControlItem.getItemTouch();
	
	public static int score = 0;
	public static int dd = 0;
	public static int level = 1;
	
	Image prince_stand;
	Image prince_up;
	Image prince_left;
	Image prince_right;
	Image prince_down;
	Image prince_over;
	Image prince_win;
	
	public Prince(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	public void update() {
		prince_stand = new ImageIcon("Image/prince_stand.png").getImage();
		prince_left = new ImageIcon("Image/prince_left.gif").getImage();
		prince_right = new ImageIcon("Image/prince_right.gif").getImage();
		prince_down = new ImageIcon("Image/prince_down.gif").getImage();
		prince_up = new ImageIcon("Image/prince_up.gif").getImage();
		prince_win = new ImageIcon("Image/prince_win.gif").getImage();
		
		timeritem= new Timer(1000,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ti--;
			}
		});
		
		if(ti <= 0) {
			speeditem = 0;
			timeritem.stop();
		}
		
		x += speedx;
		y += speedy;
		
		if(x <= 0) {
			if(level == 1) {
				x = 0;
			}else if(level == 5){
				x = 495;
				level-=2;
			}else {
				x = 495;
				level--;
			}
		}else if(x >= 495) {
			if(level == 5) {
				x = 495;
			}else if(level == 3) {
				x = 0;
				level+=2;
			}else {
				x = 0;
				level++;
			}
		}
		
		if(y <= 0) {
			if(level == 1) {
				y = 0;
			}else if(level == 3 || level == 2) {
				y = 473;
				level++;
			}else {
				y = 473;
				level--;
			}
		}else if(y >= 473) {
			if(level == 5) {
				y = 495;
			}else if(level == 4 || level == 3){
				y = 0;
				level--;
			}else {
				level++;
			}
		}
		
		Touch();
	}
	
	public void draw(Graphics2D g2d) {
		if(dd == 1) {
			g2d.drawImage(prince_over,x,y,50,50,this);
		}else if(Prince.score == 10) {
			g2d.drawImage(prince_win,x,y,50,50,this);
		}else {
			if(Playy.n == 0) {
				g2d.drawImage(prince_stand,x,y,50,50,this);
			}
			if(Playy.n == 1) {
				g2d.drawImage(prince_right,x,y,50,50,this);
			}
			if(Playy.n == 2) {
				g2d.drawImage(prince_left,x,y,50,50,this);
			}
			if(Playy.n == 3) {
				g2d.drawImage(prince_down,x,y,50,50,this);
			}
			if(Playy.n == 4) {
				g2d.drawImage(prince_up,x,y,50,50,this);
			}
		}
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(Prince.dd == 1 || Prince.score == 10) {
			speedx = 0;
			speedy = 0;
		}
		else {
			if(key == KeyEvent.VK_RIGHT) {
				if(speeditem == 1) {
					speedx = 4;
				}else {
					speedx = 2;
				}
				Playy.n = 1;
			}
			if(key == KeyEvent.VK_LEFT) {
				if(speeditem == 1) {
					speedx = -4;
				}else {
					speedx = -2;
				}
				Playy.n = 2;
			}
			if(key == KeyEvent.VK_DOWN) {
				if(speeditem == 1) {
					speedy = 4;
				}else {
					speedy = 2;
				}
				Playy.n = 3;
			}
			if(key == KeyEvent.VK_UP) {
				if(speeditem == 1) {
					speedy = -4;
				}else {
					speedy = -2;
				}
				Playy.n = 4;
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_RIGHT) {
			speedx = 0;
		}
		if(key == KeyEvent.VK_LEFT) {
			speedx = 0;
		}
		if(key == KeyEvent.VK_DOWN) {
			speedy = 0;
		}
		if(key == KeyEvent.VK_UP) {
			speedy = 0;
		}
	}
	
	public Rectangle getTouch() {
		return new Rectangle(x+10, y+10, 30, 30);
	}
	
	public void Touch() {
		if(Prince.level == 1) {
			for(int i = 0; i < w1.size(); i++) {
				if(getTouch().intersects(w1.get(i).getTouch())) {
					Prince.dd = 1;
				}
			}
			for(int i = 0; i < t1.size(); i++) {
				if(getTouch().intersects(t1.get(i).getTouch())) {
					speedx = 0;
					speedy = 0;
					
					if (Playy.n == 1) {
						x--;
					}
					if (Playy.n == 2) {
						x++;
					}
					if (Playy.n == 3) {
						y--;
					}
					if (Playy.n == 4) {
						y++;
					}
				}	
			}
			for(int i = 0; i < s1.size(); i++) {
				if(getTouch().intersects(s1.get(i).getTouch())) {
					s1.remove(i);
					score++;
				}
			}
		}
		
		if(Prince.level == 2){
			for(int i = 0; i < t2.size(); i++) {
				if(getTouch().intersects(t2.get(i).getTouch())) {
					speedx = 0;
					speedy = 0;
					
					if (Playy.n == 1) {
						x--;
					}
					if (Playy.n == 2) {
						x++;
					}
					if (Playy.n == 3) {
						y--;
					}
					if (Playy.n == 4) {
						y++;
					}
				}
			}
			for(int i = 0; i < w2.size(); i++) {
				if(getTouch().intersects(w2.get(i).getTouch())) {
					Prince.dd = 1;
				}
			}
			for(int i = 0; i < s2.size(); i++) {
				if(getTouch().intersects(s2.get(i).getTouch())) {
					s2.remove(i);
					score++;
				}
			}	
		}
		
		if(Prince.level == 3){
			for(int i = 0; i < t3.size(); i++) {
				if(getTouch().intersects(t3.get(i).getTouch())) {
					speedx = 0;
					speedy = 0;
					
					if (Playy.n == 1) {
						x--;
					}
					if (Playy.n == 2) {
						x++;
					}
					if (Playy.n == 3) {
						y--;
					}
					if (Playy.n == 4) {
						y++;
					}
				}
			}
			for(int i = 0; i < w3.size(); i++) {
				if(getTouch().intersects(w3.get(i).getTouch())) {
					Prince.dd = 1;
				}
			}
			for(int i = 0; i < s3.size(); i++) {
				if(getTouch().intersects(s3.get(i).getTouch())) {
					s3.remove(i);
					score++;
				}
			}	
			for(int i = 0; i < cl.size(); i++) {
				if(getTouch().intersects(cl.get(i).getTouch())) {
					cl.remove(i);
					Playy.tc += 50;
				}
			}	
		}
		
		if(Prince.level == 4){
			for(int i = 0; i < t4.size(); i++) {
				if(getTouch().intersects(t4.get(i).getTouch())) {
					speedx = 0;
					speedy = 0;
					
					if (Playy.n == 1) {
						x--;
					}
					if (Playy.n == 2) {
						x++;
					}
					if (Playy.n == 3) {
						y--;
					}
					if (Playy.n == 4) {
						y++;
					}
				}
			}
			for(int i = 0; i < w4.size(); i++) {
				if(getTouch().intersects(w4.get(i).getTouch())) {
					Prince.dd = 1;
				}
			}
			for(int i = 0; i < s4.size(); i++) {
				if(getTouch().intersects(s4.get(i).getTouch())) {
					s4.remove(i);
					score++;
				}
			}	
			for(int i = 0; i < it.size(); i++) {
				if(getTouch().intersects(it.get(i).getTouch())) {
					it.remove(i);
					timeritem.start();
					speeditem = 1;
				}
			}	
		}
		
		if(Prince.level == 5){
			for(int i = 0; i < t5.size(); i++) {
				if(getTouch().intersects(t5.get(i).getTouch())) {
					speedx = 0;
					speedy = 0;
					
					if (Playy.n == 1) {
						x--;
					}
					if (Playy.n == 2) {
						x++;
					}
					if (Playy.n == 3) {
						y--;
					}
					if (Playy.n == 4) {
						y++;
					}
				}
			}
			
			for(int i = 0; i < w5.size(); i++) {
				if(getTouch().intersects(w5.get(i).getTouch())) {
					Prince.dd = 1;
				}
			}
			
			for(int i = 0; i < s5.size(); i++) {
				if(getTouch().intersects(s5.get(i).getTouch())) {
					s5.remove(i);
					score++;
				}
			}
			
			for(int i = 0; i < f.size(); i++) {
				if(getTouch().intersects(f.get(i).getTouch())) {
					f.remove(i);
					Prince.dd = 1;
				}
			}
		}
	}
}
