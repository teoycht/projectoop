import java.awt.Graphics2D;
import java.util.LinkedList;

public class ControlSword3 {
	static LinkedList<Sword> s3 = new LinkedList<>();
	Sword temp;
	
	public ControlSword3() {
		addSword(new Sword(30,160));
		addSword(new Sword(400,383));
	}
	
	public void draw(Graphics2D g2d) {
		for(int i = 0; i< s3.size(); i++) {
			temp = s3.get(i);
			temp.draw(g2d);
		}
	}
	
	public void update() {
		for(int i = 0; i< s3.size(); i++) {
			temp = s3.get(i);
			temp.update();
		}
	}
	
	public void addSword(Sword sword) {
		s3.add(sword);
	}
	
	public void removeSword(Sword sword) {
		s3.remove(sword);
	}
	
	public static LinkedList<Sword> getSwordTouch() {
		return s3;
	}
}
