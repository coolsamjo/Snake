import java.awt.Color;
import java.awt.Graphics;

public class Food {
	
	private int xloc = (int)(Math.random()*800);
	private int yloc = (int)(Math.random()*600);
	private Snake s;

	public Food() {
		
	}
	public void draw(Graphics g) {
		g.setColor(new Color(255,0,0));
		g.fillRect(xloc, yloc, 10, 10);
	}
	
	public void newFood() {
		if(s.getxlocation()>= xloc && s.getxlocation()<= xloc+10&& s.getylocation()<= yloc&& s.getylocation()>= yloc+10) {
			xloc = (int)(Math.random()*800);
			yloc = (int)(Math.random()*600);
		}
	}
	//xloc+10
	//yloc+10
}
