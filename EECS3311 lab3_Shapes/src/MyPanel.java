
import java.awt.Color;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics2D;
import java.awt.Graphics;


public class MyPanel extends JPanel {
	
	public ArrayList<Integer> shapes = new ArrayList<Integer>();
	public ArrayList<Shape> shapesArr = new ArrayList<Shape>();
	static int counter = 0;
	
	
	@Override
	public void paintComponent(Graphics g) {
		
		if(counter == 0) {
		shapesArr.clear();
		
		int ShapesCount = 0;
		int position = 0;
		while(ShapesCount < 6) {
		
		int shapeChooser = (int) Math.floor(Math.random() * (3) + 1);
		
		int RandRed = (int) Math.floor(Math.random() * (255 + 1));
		int RandGreen = (int) Math.floor(Math.random() * (255 + 1));
		int RandBlue = (int) Math.floor(Math.random() * (255 + 1));
		Color randColor = new Color(RandRed,RandGreen,RandBlue);
		
		int RandWidth = (int) Math.floor(Math.random() * (55) + 20);
		int RandLength = (int) Math.floor(Math.random() * (55) + 20);
		
		if(shapeChooser == 1) {
			
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(randColor);//
			g2d.fillRect(475 - position , 400 - position, RandWidth, RandLength);//
			
			shapesArr.add(new Shape(shapeChooser, 475 - position, 400 - position, RandWidth, RandLength, randColor));
		}
		
		if(shapeChooser == 2) {
			
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(randColor);//
			g2d.fillRect(475 - position , 400 - position , RandWidth, RandWidth);//
			
			
			shapesArr.add(new Shape(shapeChooser, 475 - position, 400 - position, RandWidth, RandLength, randColor));
			
		}
		
		if(shapeChooser == 3) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(randColor);//
			g2d.fillOval(475 -position , 400 - position , RandWidth, RandWidth);//
			
		
			shapesArr.add(new Shape(shapeChooser, 475 - position, 400 - position, RandWidth, RandLength, randColor));
		
		}
		ShapesCount++;
		position  += 75;
		
		}
		}
		
		else {
			int areaList = 0;
			int[] shapeareas = new int[7];
			int counter = 0;
			int location = 0;
			
			while(areaList < 6) {
				
				shapeareas[areaList] = shapesArr.get(areaList).getarea();
				areaList++;
			}
			
			Sort sort = new Sort(shapeareas);
			shapeareas = sort.getSort();
			
			while(counter<7) {
				
				int index = 0;
				int shapeChooser = 0;
				int RandWidth = 0;
				int RandLength = 0;
				Color RandColor = new Color(0,0,0);
				
				while(index<6) {
					
					if(shapesArr.get(index).getarea() == shapeareas[counter] ) {
						shapeChooser = shapesArr.get(index).gettype();
						RandWidth = shapesArr.get(index).getwidth();
						RandLength = shapesArr.get(index).getlength();
						RandColor = shapesArr.get(index).getColor();
						break;
					}
					index++;
				}
				
				counter++;
		
				if(shapeChooser == 1) {
					
					Graphics2D g2d = (Graphics2D) g;
					g2d.setColor(RandColor);
					g2d.fillRect(500 - location , 500 - location , RandWidth, RandLength);//
				}
				
				if(shapeChooser == 2) {
					
					Graphics2D g2d = (Graphics2D) g;
					g2d.setColor(RandColor);
					g2d.fillRect(500 - location , 500 - location , RandWidth, RandWidth);//
				}
				
				if(shapeChooser == 3) {
					Graphics2D g2d = (Graphics2D) g;
					g2d.setColor(RandColor);
					g2d.fillOval(500 -location , 500 - location , RandWidth, RandWidth);
				}
				
				location += 75;
					
			}		
	}
}
		
	

public static void main(String[] args) {
	
	MyPanel rects = new MyPanel();
	JFrame frame = new JFrame("Display shapes");
	frame.getContentPane();
	JButton load = new JButton("Load Shapes");
	JButton sort = new JButton("Sort Shapes");
	load.setBounds(150, 530, 150, 25);
	sort.setBounds(300, 530, 150, 25);
	rects.setLayout(null);
	frame.add(load);
	frame.add(sort);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.add(rects);
	frame.setSize(600, 600);
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
	frame.remove(rects);
		load.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				frame.add(rects);
				frame.repaint();
				counter = 0;
			
			}
		});
		sort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(rects);
				frame.add(rects);
				frame.repaint();
				counter++;
			}
		});		
}
}