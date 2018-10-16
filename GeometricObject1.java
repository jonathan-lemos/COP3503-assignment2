abstract class GeometricObject1{
	protected String color;
	protected double weight;

	// Default constructor
	protected GeometricObject1(){
		color = "white";
		weight = 1.0;
	}

	// Construct a geometric object because reading is hard
	protected GeometricObject1(String color, double weight){
		this.color = color;
		this.weight = weight;
	}

	// getter for color
	public String getColor() {
		return color;
	}

	// setter for color
	public void setColor(String color){
		this.color = color;
	}

	// getter for weight
	public double getWeight() {
		return weight;
	}

	// setter for weight
	public void setWeight(double weight) {
		this.weight = weight;
	}

	// abstract method that gets the area of this object
	public abstract double findArea();

	// abstract method that gets the perimeter of this object
	public abstract double findPerimeter();
}
