import java.awt.Graphics;

public class Snake {
	
	
	private int xlocation;
	private int ylocation;
	private int tracker;
	private int direction;
	public Snake(int xloc, int yloc) {
		xlocation = xloc;
		ylocation = yloc;
	}
	
	public void draw(Graphics g) {
		g.fillRect(xlocation, ylocation, 25, 25);
	}
	
	public int getxlocation() {
		return xlocation;
	}
	
	public int getylocation() {
		return ylocation;
	}
	public void faceleft() {
		//xlocation = tracker;
		direction = 3;
	}
	
	public void faceRight() {
		//xlocation =tracker;
		direction = 1;
	}
	
	public void faceup() {
		direction = 4;
	}
	
	public void facedown() {
		direction = 2;
	}
	
	public void move() {
		
		if(direction == 4) {
			ylocation -= 10;
		}
		if(direction == 1) {
			xlocation += 10;
		}
		if(direction == 2) {
			ylocation += 10;
		}
		if(direction == 3) {
			xlocation -= 10;
		}
	}
	
	
}
