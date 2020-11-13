import java.awt.Graphics2D;
import java.util.LinkedList;

public class ControlSword5 {
	static LinkedList<Sword> s5 = new LinkedList<>();
	Sword temp;
	
	public ControlSword5() {
		addSword(new Sword(400,323));
		addSword(new Sword(300,400));
	}

	public void draw(Graphics2D g2d) {
		for(int i = 0; i< s5.size(); i++) {
			temp = s5.get(i);
			temp.draw(g2d);
		}
	}
	
	public void update() {
		for(int i = 0; i< s5.size(); i++) {
			temp = s5.get(i);
			temp.update();
		}
	}
	
	public void addSword(Sword sword) {
		s5.add(sword);
	}
	
	public void removeSword(Sword sword) {
		s5.remove(sword);
	}
	
	public static LinkedList<Sword> getSwordTouch() {
		return s5;
	}
}
