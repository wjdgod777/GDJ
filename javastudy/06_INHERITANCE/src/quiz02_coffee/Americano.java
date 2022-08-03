package quiz02_coffee;

public class Americano {
	
	private Espresso espresso;
	private int shot;
	private String temp;

	
	
	public Americano(Espresso espresso, int shot, String temp) {
		super();
		this.espresso = espresso;
		this.shot = shot;
		this.temp = temp;
	}

	public void info() {
		espresso.info();
		System.out.println(" " + shot + "샷, " + temp + " 아메리카노");
	}

	

}
