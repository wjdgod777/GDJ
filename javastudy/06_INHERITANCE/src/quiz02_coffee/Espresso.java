package quiz02_coffee;

public class Espresso extends Coffee {

	private int water;

	public Espresso(String name, int water) {
		super(name);
		this.water = water;
	}
	
	@Override
	public void info() {
		super.info();
		System.out.print(", 물 " + water + "ml");
	}
	
}
