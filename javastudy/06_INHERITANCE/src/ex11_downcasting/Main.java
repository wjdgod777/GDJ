package ex11_downcasting;

public class Main {

	public static void main(String[] args) {
		
		Car car = new Car();
		Ev ev = new Ev();
		Hybrid hybrid = new Hybrid();
		
		Car[] cars = new Car[10];
		
		for(int i = 0; i < cars.length; i++) {
			if(Math.random() < (1.0/3)) {
				cars[i] = new Car();
			} else if(Math.random() <(2.0/3)) {
				cars[i] = new Ev();
			} else {
				cars[i] = new Hybrid();
			}
			System.out.println(cars[i]);
		}
		
		/*
		 * Car이면 drive() 호출
		 * Ev이면 charge() 호출
		 * Hybrid이면 addOil() 호출
		 */
		for(int i = 0; i < cars.length; i++) {
			if(cars[i] instanceof Hybrid) {
				((Hybrid)cars[i]).addOil();
			} else if(cars[i] instanceof Ev) {
				((Ev)cars[i]).charge();
			} else {
				cars[i].drive();
			}
		}
		
		

	}

}
