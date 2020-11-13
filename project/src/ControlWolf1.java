import java.awt.Graphics2D;
import java.util.LinkedList;

public class ControlWolf1 {
	static LinkedList<Wolf> w1 = new LinkedList<>();
	Wolf temp;
	
	public ControlWolf1() {
		addWolf(new Wolf(53,143));
		addWolf(new Wolf(443,413));
	}
	
	public void draw(Graphics2D g2d) {
		for(int i = 0; i< w1.size(); i++) {
			temp = w1.get(i);
			temp.draw(g2d);
		}
	}
	
	public void update() {
		for(int i = 0; i< w1.size(); i++) {
			temp = w1.get(i);
			temp.update();
		}
	}
	
	public void addWolf(Wolf wolf) {
		w1.add(wolf);
	}
	
	public void removeWolf(Wolf wolf) {
		w1.remove(wolf);
	}
	
	public static LinkedList<Wolf> getWolfTouch() {
		return w1;
		
	}
}
