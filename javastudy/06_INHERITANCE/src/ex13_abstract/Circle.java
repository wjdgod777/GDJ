package ex13_abstract;

public class Circle extends Shape {

	private int radius;

	public Circle(String type, int radius) {
		super(type);
		this.radius = radius;
	}
	
	// Shape 클래스는 추상 클래스이므로, 반드시 double getArea() 메소드를 오버라이드 해야 함
	@Override
	public double getArea() {
		return Math.PI * Math.pow(radius, radius);
	}
	
}
