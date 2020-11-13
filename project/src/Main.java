import javax.swing.JFrame;

public class Main extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	public static final int WIDTH = 550;
	public static final int HIGHT = 570;
	static Main frame;
	Start start;
	Playy playy;
	
	
	public Main() {
		frame = this;
		setSize(WIDTH,HIGHT);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		start = new Start();
	    add(start);
		setVisible(true);
		setTitle("Prince And Princess");
	}
		
	public static void main(String[] args){
		new Main();
	}

}
