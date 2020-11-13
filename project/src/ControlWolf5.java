import java.awt.Graphics2D;
import java.util.LinkedList;

public class ControlWolf5 {
	static LinkedList<Wolf> w5 = new LinkedList<>();
	Wolf temp;
	
	public ControlWolf5() {
		addWolf(new Wolf(250,20));
		addWolf(new Wolf(353,443));
		addWolf(new Wolf(450,20));
	}
	
	public void draw(Graphics2D g2d) {
		for(int i = 0; i< w5.size(); i++) {
			temp = w5.get(i);
			temp.draw(g2d);
		}
	}
	
	public void update() {
		for(int i = 0; i< w5.size(); i++) {
			temp = w5.get(i);
			temp.update();
		}
	}
	
	public void addWolf(Wolf wolf) {
		w5.add(wolf);
	}
	
	public void removeWolf(Wolf wolf) {
		w5.remove(wolf);
	}
	
	public static LinkedList<Wolf> getWolfTouch() {
		return w5;
		
	}
}
