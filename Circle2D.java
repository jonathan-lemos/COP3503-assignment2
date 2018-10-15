import java.lang.IllegalArgumentException;

public class Circle2D{
	double x;
	double y;
	double radius;

	public Circle2D(){
		this.x = 0;
		this.y = 0;
		this.radius = 1;
	}

	public Circle2D(double x, double y, double radius){
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public double getX(){
		return this.x;
	}

	public void setX(double x){
		this.x = x;
	}

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
		// if the difference between the point and the center is less than the radius
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
		// this right must be greater than that right
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

			//one of the circles contains the other
			this.contains(o) ||
			o.contains(this);
	}

	private static double distance(double x1, double y1, double x2, double y2){
		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}
}
