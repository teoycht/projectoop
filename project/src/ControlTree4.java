import java.awt.Graphics2D;
import java.util.LinkedList;

public class ControlTree4 {
	static LinkedList<Tree> t4 = new LinkedList<>();
	Tree temp;
	
	public ControlTree4() {
		for(int i = 0, a = -7; i < 18; i++) {
			if(i==7 || i==8 || i==9 || i==10) {
				addTree(new Tree(-7,a));
				addTree(new Tree(a,-7));
				addTree(new Tree(503,a));
				a+=30;
			}
			else if(i>15) {
				a+=30;
			}
			else {
				addTree(new Tree(a,-7));
				addTree(new Tree(-7,a));
				addTree(new Tree(a,443));
				addTree(new Tree(503,a));
				a+=30;
			}
		}
		
		addTree(new Tree(473,-7));
		addTree(new Tree(473,443));
		
		for(int i = 0, b = 113; i < 8; i++) {
			for(int j = 0,a = 23; j < 16; j++) {
				if(j!=7 && j!=8) {
					addTree(new Tree(a,b));
				}
				a+=30;
			}
			b+=30;
		}
	}
	
	public void draw(Graphics2D g2d) {
		for(int i = 0; i< t4.size(); i++) {
			temp = t4.get(i);
			temp.draw(g2d);
		}
	}
	
	public void update() {
		for(int i = 0; i< t4.size(); i++) {
			temp = t4.get(i);
			temp.update();
		}
	}
	
	public void addTree(Tree tree) {
		t4.add(tree);
	}
	
	public void removeTree(Tree tree) {
		t4.remove(tree);
	}
	
	public static LinkedList<Tree> getTreeTouch() {
		return t4;
	}
} 
