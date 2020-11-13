import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Playy extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Timer timer,timer2,timerclock;
	
	Prince prince;
	
	ControlWolf1 w1;
	ControlWolf2 w2;
	ControlWolf3 w3;
	ControlWolf4 w4;
	ControlWolf5 w5;
	
	ControlTree1 t1;
	ControlTree2 t2;
	ControlTree3 t3;
	ControlTree4 t4;
	ControlTree5 t5;
	
	ControlSword1 s1;
	ControlSword2 s2;
	ControlSword3 s3;
	ControlSword4 s4;
	ControlSword5 s5;
	
	ControlFire f;
	
	ControlClock cl;
	
	ControlItem it;
	
	public static int n = 0;
	public static int tc = 240;
	public static int tcl = 10;
	
	Image backgound;
	
	public Playy() {
		timer = new Timer(10,this);
		timer2 = new Timer(1000,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tc--;
			}
		});
		
		timerclock = new Timer(1000,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tcl--;
			}
		});
		
		timer.start();
		timer2.start();
		
		prince = new Prince(1,83);
		
		w1 = new ControlWolf1();
		w2 = new ControlWolf2();
		w3 = new ControlWolf3();
		w4 = new ControlWolf4();
		w5 = new ControlWolf5();
		
		t1 = new ControlTree1();
		t2 = new ControlTree2();
		t3 = new ControlTree3();
		t4 = new ControlTree4();
		t5 = new ControlTree5();
		
		s1 = new ControlSword1();
		s2 = new ControlSword2();
		s3 = new ControlSword3();
		s4 = new ControlSword4();
		s5 = new ControlSword5();
		
		f = new ControlFire();
		
		cl = new ControlClock();
		
		it = new ControlItem();
		
		backgound = new ImageIcon("Image/Level1_Back.jpg").getImage();
		
		
		
		
		addKeyListener(new Key(prince));
		setFocusable(true);
	}	
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(backgound,0,0,Main.WIDTH,Main.HIGHT,this);
	
		prince.draw(g2d);
		if(Prince.level == 1) {
			s1.draw(g2d);
			w1.draw(g2d);
			t1.draw(g2d);
		}
		if(Prince.level == 2) {
			s2.draw(g2d);
			w2.draw(g2d);
			t2.draw(g2d);
		}
		if(Prince.level == 3) {
			timerclock.start();
			s3.draw(g2d);
			t3.draw(g2d);
			w3.draw(g2d);
			cl.draw(g2d);
		}
		if(Prince.level == 4) {
			it.draw(g2d);
			s4.draw(g2d);
			t4.draw(g2d);
			w4.draw(g2d);
		}
		if(Prince.level == 5) {
			s5.draw(g2d);
			w5.draw(g2d);
			f.draw(g2d);
			t5.draw(g2d);
		}
	
		g2d.setFont(new Font("Tahoma",Font.BOLD,30));
		g2d.drawString("sword : "+Prince.score+"/10",10,530);
		g2d.drawString("Time : "+tc, 370, 530);
		
		if(tcl == 0) {
			timerclock.stop();
			cl.update();
		}
		if (Prince.score == 10){
			timer2.stop();
			g2d.setColor(Color.BLUE);
			g2d.setFont(new Font("Tahoma",Font.BOLD,40));
			g2d.drawString("WIN",220,275);
		}
		if (tc <=0 ){
			Prince.dd = 1;	
		}
		if(Prince.dd == 1) {
			timer2.stop();
			g2d.setColor(Color.RED);
			g2d.setFont(new Font("Tahoma",Font.BOLD,30));
			g2d.drawString("GAME OVER",175,275);	
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		prince.update();
		if(Prince.level == 1) {
			backgound = new ImageIcon("Image/Level1_Back.jpg").getImage();
			s1.update();
			w1.update();
			t1.update();
		}	
		if(Prince.level == 2) {
			backgound = new ImageIcon("Image/Level1_Back.jpg").getImage();
			s2.update();
			w2.update();
			t2.update();
		}
		if(Prince.level == 3) {
			backgound = new ImageIcon("Image/Level1_Back.jpg").getImage();
			s3.update();
			w3.update();
			t3.update();
			cl.update();
		}
		if(Prince.level == 4) {
			backgound = new ImageIcon("Image/Level1_Back.jpg").getImage();
			it.update();
			s4.update();
			w4.update();
			t4.update();
		}
		if(Prince.level == 5) {
			backgound = new ImageIcon("Image/Level1_Back.jpg").getImage();
			s5.update();
			w5.update();
			f.update();
			t5.update();
		}
		
		repaint();
	}
}
