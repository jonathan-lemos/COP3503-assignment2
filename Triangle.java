public class Triangle extends GeometricObject{
	double side1 = 1.0;
	double side2 = 1.0;
	double side3 = 1.0;

	public Triangle(){
		super();
	}

	public Triangle(double side1, double side2, double side3){
		super();
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

	public double getSide1(){
		return side1;
	}

	public void setSide1(double v){
		this.side1 = v;
	}

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
		//heron's formula
		return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
	}

	public double getPerimeter(){
		return side1 + side2 + side3;
	}

	@Override
	public String toString(){
		return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
	}
}
