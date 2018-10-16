public class Triangle extends GeometricObject{
	// the sides of the triangle
	double side1 = 1.0;
	double side2 = 1.0;
	double side3 = 1.0;

	public Triangle(){
		// call superclass constructor
		super();
	}

	public Triangle(double side1, double side2, double side3){
		// call superclass constructor
		super();
		// set values
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

	// gets side1. wow. that needed explanation
	public double getSide1(){
		return side1;
	}

	// sets side1
	public void setSide1(double v){
		this.side1 = v;
	}

	// you get the drill
	public double getSide2(){
		return side2;
	}

	public void setSide2(double v){
		this.side2 = v;
	}

	public double getSide3(){
		return side3;
	}

	public void setSide3(double v){
		this.side3 = v;
	}

	public double getArea(){
		double p = getPerimeter() / 2.0;
		// heron's formula
		return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
	}

	public double getPerimeter(){
		// perimeter = sum of side lengths
		return side1 + side2 + side3;
	}

	// @Override denotes that this overrides a method from superclass (Object)
	@Override
	public String toString(){
		return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
	}
}
