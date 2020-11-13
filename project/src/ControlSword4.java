import java.awt.Graphics2D;
import java.util.LinkedList;

public class ControlSword4 {
	static LinkedList<Sword> s4 = new LinkedList<>();
	Sword temp;
	
	public ControlSword4() {
		addSword(new Sword(50,55));
		addSword(new Sword(450,55));
	}

	public void draw(Graphics2D g2d) {
		for(int i = 0; i< s4.size(); i++) {
			temp = s4.get(i);
			temp.draw(g2d);
		}
	}
	
	public void update() {
		for(int i = 0; i< s4.size(); i++) {
			temp = s4.get(i);
			temp.update();
		}
	}
	
	public void addSword(Sword sword) {
		s4.add(sword);
	}
	
	public void removeSword(Sword sword) {
		s4.remove(sword);
	}
	
	public static LinkedList<Sword> getSwordTouch() {
		return s4;
	}
}
