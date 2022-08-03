package quiz01_coffee;

public class Americano extends Espresso {
	
	private String temp;

	public Americano(String name, int water, String temp) {
		super(name, water);
		this.temp = temp;
	}
	
	@Override
	public void info() {
		super.info();
		System.out.println(", " + temp + "아메리카노");
	}

	

}
