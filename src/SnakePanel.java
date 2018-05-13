import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.UIManager;

public class SnakePanel extends JPanel {


	private int xloc = 200;
	private int yloc = 200;
	private List<Snake> list = new ArrayList();
	private Snake s = new Snake(xloc,yloc);
	private Food food = new Food();
	
	
	Timer timer = new Timer(500,null);
	public static void main(String[] args) {
		try {
			// Set System L&F
			UIManager.setLookAndFeel(
					UIManager.getSystemLookAndFeelClassName());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		JFrame frame = new JFrame("Snake!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		SnakePanel sp = new SnakePanel();
		frame.add(sp);
		sp.setPreferredSize(new Dimension(800,600));
		frame.pack();
		frame.setVisible(true);
		sp.setUpKeyMappings();
		sp.startGame();
		sp.setBackground(new Color(153,255,153));
		
	}
	private void setUpKeyMappings() {

		this.getInputMap().put(KeyStroke.getKeyStroke("LEFT"),"left");
		this.getActionMap().put("left",new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// what do you want to do when the left arrow is pressed?
				s.faceleft();
				System.out.println("Hit left arrow!!");
			}
		});
		
		this.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"),"right");
		this.getActionMap().put("right",new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e) {
				s.faceRight();
				System.out.println("Hit right arrow!!");
			}
		});
		
		this.getInputMap().put(KeyStroke.getKeyStroke("UP"),"up");
		this.getActionMap().put("up",new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e) {
				s.faceup();
				System.out.println("Hit up arrow!!");
			}
		});
		
		this.getInputMap().put(KeyStroke.getKeyStroke("DOWN"),"down");
		this.getActionMap().put("down",new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e) {
				s.facedown();
				System.out.println("Hit down arrow!!");
			}
		});
		this.requestFocusInWindow();
		
		
		
	}
	private void startGame() {
		timer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				tick();
				repaint();
				
			}
			
		});
		list.add(s);
		timer.start();
	}
	protected void tick() {
		s.move();
		food.newFood();
		System.out.println("Timer went off!");
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		s.draw(g);
		food.draw(g);
	}
}