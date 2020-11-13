import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Item extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	
	Image item;
	
	public Item(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public void update() {
		item = new ImageIcon("Image/boot.png").getImage();
	}
	
	public void draw(Graphics2D g2d) {
		g2d.drawImage(item,x,y,50,50,this);
	}
	
	public Rectangle getTouch() {
		return new Rectangle(x+10, y+10, 20, 35);
	}
}

class ControlItem {
	static LinkedList<Item> it = new LinkedList<>();
	Item temp;
	
	public ControlItem() {
		addItem(new Item(253,323));
	}
	
	public void draw(Graphics2D g2d) {
		for(int i = 0; i< it.size(); i++) {
			temp = it.get(i);
			temp.draw(g2d);
		}
	}
	
	public void update() {
		for(int i = 0; i< it.size(); i++) {
			temp = it.get(i);
			temp.update();
		}
	}
	
	public void addItem(Item item) {
		it.add(item);
	}
	
	public void removeItem(Item item) {
		it.remove(item);
	}
	
	public static LinkedList<Item> getItemTouch() {
		return it;
	}
}
