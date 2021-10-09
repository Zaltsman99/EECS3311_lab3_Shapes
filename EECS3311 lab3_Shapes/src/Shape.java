import java.awt.Color;

public class Shape {
		
	int area = 0;
	int type = 0;
	int upperX;
	int upperY;
	int width = 0 ;
	int length = 0 ;
	Color shapeColor;
	
	
	public Shape(int type, int upperX, int upperY, int width, int length, Color shapeColor) {
		
		
		
		this.type = type;
		this.upperX = upperX;
		this.upperY = upperY;
		this.width = width;
		this.length = length;
		this.shapeColor = shapeColor;
		
		this.area = area(this.length, this.width, this.type);
		
	}
	
	public int area(int length, int width, int type) {
		
		if(type == 1) {
			return width*length;
		}
		
		if(type == 2) {
			return width*width;
		}
		
		if(type == 3) {
			return (int)(Math.PI *  (width/2) * (width/2));
		}
		return 0;
		
	}
	
    public Color getColor() {
		return shapeColor;
	}
	
	public int getarea(){
		return area;
	}
	
	public int gettype() {
		return type;
	}
	
	public int getwidth() {
		return width;
	}
	
	public int getlength() {
		return length;
	}
	
	public int getupperY() {
		return upperY;
	}	
	public int getupperX() {
		return upperX;
	}
	
	
}