import java.awt.Graphics2D;
import java.util.LinkedList;

public class ControlTree1 {
	static LinkedList<Tree> t1 = new LinkedList<>();
	Tree temp;
	
	public ControlTree1() {
			for(int i = 0, a = -7; i < 18; i++) {
				if(i==2 || i==3 || i==4) {
					addTree(new Tree(a,-7));
					addTree(new Tree(a,443));
					addTree(new Tree(503,a));
					a+=30;
				}
				else if(i==11 || i==12 || i==13) {
					addTree(new Tree(a,-7));
					addTree(new Tree(-7,a));
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
			
			addTree(new Tree(23,23));
			addTree(new Tree(53,23));
			addTree(new Tree(83,23));
			
			addTree(new Tree(83,53));

			addTree(new Tree(83,83));
			addTree(new Tree(113,83));
			addTree(new Tree(143,83));
			addTree(new Tree(173,83));
			addTree(new Tree(203,83));
			addTree(new Tree(233,83));
			addTree(new Tree(263,83));
			addTree(new Tree(413,83));
			addTree(new Tree(443,83));
			addTree(new Tree(473,83));
			
			addTree(new Tree(23,203));
			addTree(new Tree(53,203));
			addTree(new Tree(83,203));
			addTree(new Tree(293,203));
			addTree(new Tree(323,203));
			addTree(new Tree(353,203));
			addTree(new Tree(383,203));
			
			addTree(new Tree(23,233));
			addTree(new Tree(53,233));
			addTree(new Tree(83,233));
			addTree(new Tree(113,233));
			addTree(new Tree(263,233));
			addTree(new Tree(293,233));
			addTree(new Tree(323,233));
			addTree(new Tree(353,233));
			addTree(new Tree(383,233));
			
			addTree(new Tree(113,263));
			addTree(new Tree(263,263));
			addTree(new Tree(293,263));
			addTree(new Tree(323,263));
			addTree(new Tree(353,263));
			addTree(new Tree(383,263));
			
			addTree(new Tree(113,293));
			addTree(new Tree(113,323));
			addTree(new Tree(113,353));
			addTree(new Tree(143,293));
			addTree(new Tree(143,323));
			addTree(new Tree(143,353));
	}
	
	public void draw(Graphics2D g2d) {
		for(int i = 0; i< t1.size(); i++) {
			temp = t1.get(i);
			temp.draw(g2d);
		}
	}
	
	public void update() {
		for(int i = 0; i< t1.size(); i++) {
			temp = t1.get(i);
			temp.update();
		}
	}
	
	public void addTree(Tree tree) {
		t1.add(tree);
	}
	
	public void removeTree(Tree tree) {
		t1.remove(tree);
	}
	
	public static LinkedList<Tree> getTreeTouch() {
		return t1;
	}
}
