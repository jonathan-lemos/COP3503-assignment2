import java.lang.IllegalArgumentException;

class Circle1 extends GeometricObject1 implements Comparable{
	protected double radius;

	// Default constructor
	public Circle1(){
		this(1.0, "white", 1.0);
	}

	// Radius constructor
	public Circle1(double radius){
		super("white", 1.0);
		this.radius = radius;
	}

	// Full constructor
	public Circle1(double radius, String color, double weight){
		super(color, weight);
		this.radius = radius;
	}

	// radius getter
	public double getRadius(){
		return radius;
	}

	// radius setter, you know the deal
	public void setRadius(){
		this.radius = radius;
	}

	public double findArea(){
		// a = pi r squared
		return this.radius * this.radius * Math.PI;
	}

	public double findPerimeter(){
		// c = 2 pi r
		return this.radius * 2.0 * Math.PI;
	}

	// can't use @Override here
	// because for some reason it doesn't actually override everything
	public boolean equals(Circle1 o){
		return this.radius == o.radius &&
			// have to use .equals for string because string is an object
			this.color.equals(o.color) &&
			this.weight == o.weight;
	}

	@Override
	public int compareTo(Object o){
		if (!(o instanceof Circle1)){
			// o must be an instance of circle1
			throw new IllegalArgumentException("o is not an instance of Circle1");
		}
		// cast to access circle1 members
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
		// both have to be instances of Circle1
		if (!(o1 instanceof Circle1) ||
				!(o2 instanceof Circle1)){
			throw new IllegalArgumentException("Both operands muct be instances of Circle1");
				}
		// casts to make the dream work
		Circle1 c1 = (Circle1)o1;
		Circle1 c2 = (Circle1)o2;

		if (c1.radius > c2.radius){
			return c1;
		}
		return c2;
	}
}
