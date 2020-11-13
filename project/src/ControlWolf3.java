import java.awt.Graphics2D;
import java.util.LinkedList;

public class ControlWolf3 {
	static LinkedList<Wolf> w3 = new LinkedList<>();
	Wolf temp;
	
	public ControlWolf3() {
		addWolf(new Wolf(443,203));
		addWolf(new Wolf(143,53));
	}
	
	public void draw(Graphics2D g2d) {
		for(int i = 0; i< w3.size(); i++) {
			temp = w3.get(i);
			temp.draw(g2d);
		}
	}
	
	public void update() {
		for(int i = 0; i< w3.size(); i++) {
			temp = w3.get(i);
			temp.update();
		}
	}
	
	public void addWolf(Wolf wolf) {
		w3.add(wolf);
	}
	
	public void removeWolf(Wolf wolf) {
		w3.remove(wolf);
	}
	
	public static LinkedList<Wolf> getWolfTouch() {
		return w3;
		
	}
}
