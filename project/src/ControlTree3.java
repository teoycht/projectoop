import java.awt.Graphics2D;
import java.util.LinkedList;

public class ControlTree3 {
	static LinkedList<Tree> t3 = new LinkedList<>();
	Tree temp;
	
	public ControlTree3() {
		int n = 1;
		addTree(new Tree(293,263));
		for(int i = 0, b = 293; i < 5; i++) {
			for(int j = 0,a = 293; j < n; j++) {
				addTree(new Tree(a,b));
				a-=30;
				addTree(new Tree(a,b));
			}	
			n++;
			b+=30;
		}
		for(int i = 0, a = -7; i < 18; i++) {
			if(i==2 || i==3 || i==4) {
				addTree(new Tree(-7,a));
				addTree(new Tree(a,-7));
				a+=30;
			}
			else if(i==7 || i==8 || i==9 || i==10) {
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
		
		for(int i = 0, a = 23; i < 3; i++) {
			addTree(new Tree(23,a));
			a+=30;
		}
		
		addTree(new Tree(23,263));
		addTree(new Tree(23,293));
		
		addTree(new Tree(53,233));
		addTree(new Tree(53,263));
		
		addTree(new Tree(83,203));
		addTree(new Tree(83,233));
		
		addTree(new Tree(113,173));
		addTree(new Tree(113,203));
		
		addTree(new Tree(53,23));
		addTree(new Tree(53,53));
		
		addTree(new Tree(83,23));
		
		//addTree(new Tree(413,173));
		addTree(new Tree(443,173));
		addTree(new Tree(473,173));
		
		
	}
	
	public void draw(Graphics2D g2d) {
		for(int i = 0; i< t3.size(); i++) {
			temp = t3.get(i);
			temp.draw(g2d);
		}
	}
	
	public void update() {
		for(int i = 0; i< t3.size(); i++) {
			temp = t3.get(i);
			temp.update();
		}
	}
	
	public void addTree(Tree tree) {
		t3.add(tree);
	}
	
	public void removeTree(Tree tree) {
		t3.remove(tree);
	}
	
	public static LinkedList<Tree> getTreeTouch() {
		return t3;
	}
}
