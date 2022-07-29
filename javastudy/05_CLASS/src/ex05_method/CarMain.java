package ex05_method;

public class CarMain {

	public static void main(String[] args) {
		
		// 객체 생성
		Car car = new Car();
		
		car.addoil(5);
		car.addoil(50);
		car.addoil(100);
		
		car.pushAccel();
		car.pushAccel();
		car.pushAccel();
		car.pushAccel();
		car.pushAccel();
		car.pushAccel();
		car.pushAccel();
		
		car.pushBrake();
		car.pushBrake();
		car.pushBrake();
		
		car.panel();

	}

}
