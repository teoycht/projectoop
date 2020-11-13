import java.awt.Graphics2D;
import java.util.LinkedList;

public class ControlWolf4 {
	static LinkedList<Wolf> w4 = new LinkedList<>();
	Wolf temp;
	
	public ControlWolf4() {
		addWolf(new Wolf(53,353));
		addWolf(new Wolf(473,383));
	}
	
	public void draw(Graphics2D g2d) {
		for(int i = 0; i< w4.size(); i++) {
			temp = w4.get(i);
			temp.draw(g2d);
		}
	}
	
	public void update() {
		for(int i = 0; i< w4.size(); i++) {
			temp = w4.get(i);
			temp.update();
		}
	}
	
	public void addWolf(Wolf wolf) {
		w4.add(wolf);
	}
	
	public void removeWolf(Wolf wolf) {
		w4.remove(wolf);
	}
	
	public static LinkedList<Wolf> getWolfTouch() {
		return w4;
		
	}
}
