import java.awt.Graphics2D;
import java.util.LinkedList;

public class ControlTree5 {
	static LinkedList<Tree> t5 = new LinkedList<>();
	Tree temp;
	
	public ControlTree5() {
		int n = 1;
		addTree(new Tree(23,263));
		for(int i = 0, b = 293; i < 5; i++) {
			for(int j = 0,a = 23; j < n; j++) {
				addTree(new Tree(a,b));
				a+=30;
				addTree(new Tree(a,b));
			}	
			n++;
			b+=30;
		}
		for(int i = 0, a = -7; i < 18; i++) {
			if(i==2 || i==3 || i==4) {
				//addTree(new Tree(-7,a));
				addTree(new Tree(a,-7));
				addTree(new Tree(503,a));
				addTree(new Tree(a,443));
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
		
		for(int i = 0, b = 23; i < 8; i++) {
			for(int j = 0,a = 293; j < 5; j++) {
				if(j!=2) {
					addTree(new Tree(a,b));
				}
				a+=30;
			}
			b+=30;
		}
		
		
	}
	
	public void draw(Graphics2D g2d) {
		for(int i = 0; i< t5.size(); i++) {
			temp = t5.get(i);
			temp.draw(g2d);
		}
	}
	
	public void update() {
		for(int i = 0; i< t5.size(); i++) {
			temp = t5.get(i);
			temp.update();
		}
	}
	
	public void addTree(Tree tree) {
		t5.add(tree);
	}
	
	public void removeTree(Tree tree) {
		t5.remove(tree);
	}
	
	public static LinkedList<Tree> getTreeTouch() {
		return t5;
	}
} 
