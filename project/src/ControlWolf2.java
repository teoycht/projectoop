import java.awt.Graphics2D;
import java.util.LinkedList;

public class ControlWolf2 {
	static LinkedList<Wolf> w2 = new LinkedList<>();
	Wolf temp;
	
	public ControlWolf2() {
		addWolf(new Wolf(353,23));
		addWolf(new Wolf(293,233));
	}
	
	public void draw(Graphics2D g2d) {
		for(int i = 0; i< w2.size(); i++) {
			temp = w2.get(i);
			temp.draw(g2d);
		}
	}
	
	public void update() {
		for(int i = 0; i< w2.size(); i++) {
			temp = w2.get(i);
			temp.update();
		}
	}
	
	public void addWolf(Wolf wolf) {
		w2.add(wolf);
	}
	
	public void removeWolf(Wolf wolf) {
		w2.remove(wolf);
	}
	
	public static LinkedList<Wolf> getWolfTouch() {
		return w2;
		
	}
}
