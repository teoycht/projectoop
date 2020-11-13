import java.awt.Graphics2D;
import java.util.LinkedList;

public class ControlTree2 {
	static LinkedList<Tree> t2 = new LinkedList<>();
	Tree temp;
	
	public ControlTree2() {	
		addTree(new Tree(383,353));
		addTree(new Tree(353,353));
		addTree(new Tree(323,353));
		addTree(new Tree(323,383));
		addTree(new Tree(323,413));
		
		for(int i = 0, a = -7; i < 18; i++) {
			if(i==11 || i==12 || i==13) {
				addTree(new Tree(a,-7));
				addTree(new Tree(503,a));
				addTree(new Tree(a,443));
				a+=30;
			}
			else if(i==2 || i==3 || i==4) {
				addTree(new Tree(-7,a));
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
		
		addTree(new Tree(473,143));
		addTree(new Tree(473,173));
		
		addTree(new Tree(383,173));
		addTree(new Tree(413,173));
		addTree(new Tree(443,173));
		
		addTree(new Tree(23,23));
		addTree(new Tree(23,53));
		addTree(new Tree(23,83));
		addTree(new Tree(23,113));
		addTree(new Tree(23,143));
		
		addTree(new Tree(143,23));
		addTree(new Tree(143,53));
		addTree(new Tree(143,83));
		addTree(new Tree(143,113));
		addTree(new Tree(143,143));
		
		addTree(new Tree(173,23));
		addTree(new Tree(173,53));
		addTree(new Tree(173,83));
		addTree(new Tree(173,113));
		addTree(new Tree(173,143));
		
		
		for(int i = 0, a = 23; i < 14; i++) {
			addTree(new Tree(a,263));
			a+=30;
		}
	}
	
	public void draw(Graphics2D g2d) {
		temp.remove(temp);
		for(int i = 0; i< t2.size(); i++) {
			temp = t2.get(i);
			temp.draw(g2d);
		}
	}
	
	public void update() {
		for(int i = 0; i< t2.size(); i++) {
			temp = t2.get(i);
			temp.update();
		}
	}
	
	public void addTree(Tree tree) {
		t2.add(tree);
	}
	
	public void removeTree(Tree tree) {
		t2.remove(tree);
	}
	
	public static LinkedList<Tree> getTreeTouch() {
		return t2;
	}
	
}
