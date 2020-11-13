import java.awt.Graphics2D;
import java.util.LinkedList;

public class ControlSword1 {
	static LinkedList<Sword> s1 = new LinkedList<>();
	Sword temp;
	
	public ControlSword1() {
		addSword(new Sword(120,40));
		addSword(new Sword(53,290));
	}
	
	public void draw(Graphics2D g2d) {
		for(int i = 0; i< s1.size(); i++) {
			temp = s1.get(i);
			temp.draw(g2d);
		}
	}
	
	public void update() {
		for(int i = 0; i< s1.size(); i++) {
			temp = s1.get(i);
			temp.update();
		}
	}
	
	public void addSword(Sword sword) {
		s1.add(sword);
	}
	
	public void removeSword(Sword sword) {
		s1.remove(sword);
	}
	
	public static LinkedList<Sword> getSwordTouch() {
		return s1;
	}
}
