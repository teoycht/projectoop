import java.awt.Graphics2D;
import java.util.LinkedList;

public class ControlSword2 {
	static LinkedList<Sword> s2 = new LinkedList<>();
	Sword temp;
	
	public ControlSword2() {
		addSword(new Sword(443,70));
		addSword(new Sword(353,400));
	}
	
	public void draw(Graphics2D g2d) {
		for(int i = 0; i< s2.size(); i++) {
			temp = s2.get(i);
			temp.draw(g2d);
		}
	}
	
	public void update() {
		for(int i = 0; i< s2.size(); i++) {
			temp = s2.get(i);
			temp.update();
		}
	}
	
	public void addSword(Sword sword) {
		s2.add(sword);
	}
	
	public void removeSword(Sword sword) {
		s2.remove(sword);
	}
	
	public static LinkedList<Sword> getSwordTouch() {
		return s2;
	}
}
