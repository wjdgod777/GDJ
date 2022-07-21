package ex01_random;

public class Ex01 {

	public static void main(String[] args) {
		
		// 난수(Random number) 발생 
		// Random 클래스, Math 클래스를 주로 활용한다.
		
		System.out.println(Math.random());
		System.out.println();
		
		// 0.0 <= Math.random() < 1.0
		// 0%  <= Math.random() < 100%
		
		// 확률 처리하기
		// 10% 확률로 "대박", 90% 확률로 "쪽박"
		
		if(Math.random() < 0.1) {
			System.out.println("대박");
		} else {
			System.out.println("쪽박");
		} System.out.println();
		
		// 2. 난수 값 생성
		
		// Math.random()				0.0 <= n < 1.0
		// Math.random() * 5 			0.0 <= n < 5.0
		// (int)(Math.random() * 5)		  0 <= n < 5
		// (int)(Math.random() * 5) + 1	  1 <= n < 6
		
		// 연습
		// 주사위 2개 던지기
		
		for(int n = 0; n < 2; n++) {
			int dice = (int)(Math.random() * 6) + 1;
			System.out.println("주사위 값 = " + dice);
		} System.out.println();
		
		// 연습
		// 6자리 숫자로 된 인증번호 만들기
		// String code = "******"
		String code = "";
		for(int n = 0; n < 6; n++) {
			int secret = (int)(Math.random() * 10);
			code += secret;
		}System.out.println("인증번호는 \'" + code + "\'입니다.");
		System.out.println();
		
		// System.out.println((char)((int)(Math.random() * 26) + 'A'));
		
		// 연습
		// 6자리 영문(대문자 + 소문자) 인증번호 만들기
		String code1 = "";
		for(int m = 0; m < 6; m++) {
			if(Math.random() < 0.33) {
				code1 += (char)((int)(Math.random() * 26) + 'A');
			} else if(Math.random() < 0.66) {
				code1 += (char)((int)(Math.random() * 26) + 'a');
			} else { 
				code1 += (int)(Math.random() * 10);
			}
			
		}System.out.println("인증번호는 \'" + code1 + "\'입니다.");
		
	}

}
