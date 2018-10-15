import java.lang.IllegalArgumentException;

class Circle1 extends GeometricObject1 implements Comparable{
	protected double radius;

	public Circle1(){
		this(1.0, "white", 1.0);
	}

	public Circle1(double radius){
		super("white", 1.0);
		this.radius = radius;
	}

	public Circle1(double radius, String color, double weight){
		super(color, weight);
		this.radius = radius;
	}

	public double getRadius(){
		return radius;
	}

	public void setRadius(){
		this.radius = radius;
	}

	public double findArea(){
		return this.radius * this.radius * Math.PI;
	}

	public double findPerimeter(){
		return this.radius * 2.0 * Math.PI;
	}

	public boolean equals(Circle1 o){
		return this.radius == o.radius &&
			this.color.equals(o.color) &&
			this.weight == o.weight;
	}

	@Override
	public int compareTo(Object o){
		if (!(o instanceof Circle1)){
			throw new IllegalArgumentException("o is not an instance of Circle1");
		}
		Circle1 oo = (Circle1)o;
		if (this.radius < oo.radius){
			return -1;
		}
		else if (this.radius > oo.radius){
			return 1;
		}
		else{
			return 0;
		}
	}

	public static Circle1 max(Comparable o1, Comparable o2){
		if (!(o1 instanceof Circle1) ||
				!(o2 instanceof Circle1)){
			throw new IllegalArgumentException("Both operands muct be instances of Circle1");
				}
		Circle1 c1 = (Circle1)o1;
		Circle1 c2 = (Circle1)o2;

		if (c1.radius > c2.radius){
			return c1;
		}
		return c2;
	}
}
