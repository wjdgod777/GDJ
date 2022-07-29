package ex03_method;

public class CalculatorMain {

	public static void main(String[] args) {
		
		// 객체 생성
		Calculator calculator = new Calculator();
		
		// calculator 객체의 add() 메소드 호출
		// 1. 2, 3 : 인수(add 메소드로 전달하는 값), 인수는 매개변수에 저장된다.
		// 2. answer : add 메소드의 반환값(return result)이 저장된다.
		int answer1 = calculator.add(4, 2);
		
		System.out.println(answer1);
		
		// sub() 메소드 호출
		int answer2 = calculator.sub(4, 2);
		
		System.out.println(answer2);
		
		// mul() 메소드 호출
		int answer3 = calculator.mul(4, 2);

		System.out.println(answer3);
		
		// div() 메소드 호출
		double answer4 = calculator.div(4, 2);
		
		System.out.println(answer4);
		
		// 몫() 메소드 호출
		int answer5 = calculator.nul(4, 2);
		
		System.out.println(answer5);

	}

}
