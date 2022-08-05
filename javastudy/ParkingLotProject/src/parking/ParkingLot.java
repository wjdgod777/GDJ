package parking;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ParkingLot {

	private String name;
	private Car[] cars;
	private int idx;
	private Scanner sc;
	
	public ParkingLot(String name) {
		this.name = name;
		cars = new Car[10];
		sc = new Scanner(System.in);
	}
	
	private void addCar() throws RuntimeException {
		if(idx == cars.length) {
			System.out.println("더이상 차량 등록이 불가능합니다.");
			return;
		}
		System.out.println("현재 등록된 차량 " + idx + "대");
		System.out.print("차량번호 >>> ");
		String number = sc.next();
		System.out.print("모델 >>> ");
		String model = sc.next();
		Car car = new Car(number, model);
		cars[idx++] = car;
		System.out.println("차량번호 " + number + " 차량이 등록되었습니다.");
	}
	
	private void deleteCar() throws RuntimeException {
		if(idx == 0) {
			System.out.println("등록된 차량이 없습니다.");
			return;
		}
		System.out.print("제거할 차량 번호 >>> ");
		String number = sc.next();
		for(int i = 0; i < idx; i++) {
			if(cars[i].getCarNo().equals(number)) {
				System.arraycopy(cars, i + 1, cars, i, idx - i - 1);
				cars[--idx] = null;
				System.out.println("차량번호 " + number + " 차량이 삭제되었습니다.");
				return;
			}
		}
		System.out.println("대상 차량이 존재하지 않습니다.");
	}
	
	private void printAllCars() throws RuntimeException {
		if(idx == 0) {
			System.out.println("등록된 차량이 없습니다.");
			 return;
		}
		System.out.println(name);
		for(int i = 0; i < idx; i++) {
			System.out.println(cars[i]);
		}
		
	}
	
	public void manage() {
		
		while(true) {
			try {
				System.out.print("1.추가 2. 삭제 3.전체 0.종료 >>> ");
				int choice = sc.nextInt();
				sc.nextLine();
				switch(choice) {
				case 1 : addCar(); break;
				case 2 : deleteCar(); break;
				case 3 : printAllCars(); break;
				case 0 : System.out.println("메뉴를 종료합니다.");
						 return;
				default : System.out.println("존재하지 않는 메뉴입니다.");
				}
				
			}catch(InputMismatchException e) {
				sc.next();
				System.out.println("처리 명령은 정수(1~4,0)입니다.");
			} catch(RuntimeException e) {
				System.out.println(e.getMessage());
			}
			
		}
		
	}
	
	
	
	
	
	
}
