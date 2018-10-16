import java.lang.IllegalArgumentException;

public class Circle2D{
	double x;
	double y;
	double radius;

	// default constructor for Circle2D
	public Circle2D(){
		this.x = 0;
		this.y = 0;
		this.radius = 1;
	}

	// constructor with values
	public Circle2D(double x, double y, double radius){
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	// X getter
	public double getX(){
		return this.x;
	}

	// X setter
	public void setX(double x){
		this.x = x;
	}

	// you get the picture
	public double getY(){
		return this.y;
	}

	public void setY(double y){
		this.y = y;
	}

	public double getRadius(){
		return this.radius;
	}

	public void setRadius(double radius){
		// radii cannot be below 0
		if (radius < 0){
			throw new IllegalArgumentException("Radius cannot be below 0");
		}
		this.radius = radius;
	}

	public double getPerimeter(){
		// 2 * pi * r
		return this.radius * 2.0 * Math.PI;
	}

	public double getArea(){
		// pi * r^2
		return this.radius * this.radius * Math.PI;
	}

	public boolean contains(double x, double y){
		// true the difference between the point and the center is less than the radius
		return Math.abs(x - this.x) <= this.radius &&
			Math.abs(y - this.y) <= this.radius;
	}

	// get top coordinate
	private double topY(){
		return this.y + this.radius;
	}

	// get bot coordinate
	private double botY(){
		return this.y - this.radius;
	}

	// get right coordinate
	private double rightX(){
		return this.x + this.radius;
	}

	// get left coordinate
	private double leftX(){
		return this.x - this.radius;
	}

	public boolean contains(Circle2D o){
		// this right must be greater than that right and
		// this left must be greater than that left etc.
		return this.rightX() >= o.rightX() &&
			this.leftX() <= o.rightX() &&
			this.topY() >= o.topY() &&
			this.botY() <= o.botY();
	}

	public boolean overlaps(Circle2D o){
		// this right must overlap other circle's left
		return ((this.rightX() >= o.leftX() &&
				// but the circle can't be completely off to the right of the other circle
				this.leftX() <= o.rightX()) ||

			//or

			// this top must overlap the other circle's bot
			(this.topY() >= o.botY() &&
			// but this circle can't be completely above the other circle's top
			 this.botY() <= o.topY())) ||

			//or

			// one of the circles contains the other
			this.contains(o) ||
			o.contains(this);
	}

	// this method is unused lmao
	private static double distance(double x1, double y1, double x2, double y2){
		// distance formula
		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}
}
