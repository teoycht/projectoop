import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Start extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JLabel p = new JLabel (new ImageIcon("Image/start.png"));
	
	
	Image backgound;
	Image logo;
	Image princeandprincess;
	
	public Start() {
		backgound = new ImageIcon("Image/page_start.jpg").getImage();
		logo = new ImageIcon("Image/logo_princeandpincess.png").getImage();
		princeandprincess = new ImageIcon("Image/princeandprincess2.png").getImage();
		
		p.setBounds(350,430,200,100);
		add(p);
		Main.frame.repaint();
		
		p.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				Main.frame.remove(Main.frame.start);
				if(Main.frame.playy == null){
					Main.frame.playy = new Playy();
				}
				Main.frame.add(Main.frame.playy);
				Main.frame.playy.setSize(Main.WIDTH,Main.HIGHT);
				Main.frame.playy.requestFocusInWindow();
				Main.frame.repaint();
			}
		});
		
    }

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgound,0,-40,540,750,this);
		g.drawImage(logo,20,5,500,71,this);
		g.drawImage(princeandprincess,20,0,500,80,this);
	}
}