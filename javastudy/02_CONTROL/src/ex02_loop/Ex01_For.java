package ex02_loop;

public class Ex01_For {

	public static void main(String[] args) {
		
		// for문
		// 연속된 숫자를 생성할 때 주로 사용한다.
		// 배열과 함께 자주 사용된다.
		// for(초기문; 조건문; 증감문) {
		// 	실행문
		// }
		
		// 1 ~ 10
		
		for(int n = 1; n <= 10; n++) {
			
			System.out.print(n);
		}	System.out.println();
			System.out.println();
			
		// 초기문 -> 조건문 -> 실행문 -> 증감문 -> 조건문 -> 실행문 -> 증감문 …
		
		// 연습
		// 10 ~ 1
		
		for(int m = 10; m >= 1; m--) {
			
			System.out.print(m);
		}	System.out.println();
			System.out.println();
		
		// 연습
		// 구구단 7단 출력
		
		for(int b = 1; b <= 9; b++) {
			
			System.out.println("7 x " + b + " = " +(7*b));
		} System.out.println();
		
		// 연습
		// 1 ~ 100 사이의 모든 3의 배수만 출력하기
		for(int c = 1; c <= 100; c++) {
			if(c % 3 == 0) {
				System.out.print(c + " ");
			}
		}System.out.println("\n");
		
		int wallet = 0;
		wallet += 1000;
		wallet += 2000;
		wallet += 3000;
		System.out.println(wallet);
		System.out.println();
		
		// 연습
		// 1~ 100 모든 정수 더하기(5050)
		
		int total = 0;
		for(int a = 1; a <= 100; a++) {
			
			total += a;
			
		} System.out.println("1~ 100 까지의 합 = " + total);
		System.out.println();
		
		// 연습
		// begin ~ end 모든 정수 더하기
		// begin과 end중 누가 큰 지 모르는 상황
		// begin을 end보다 항상 작은 값으로 바꾼 뒤 begin ~ end 모두 더하기 진행
		// begin이 end보다 크다면 begin과 end를 교환
		
		int begin = 100;
		int end = 50;
		int all = 0;
		if(begin > end) {
			int change = begin;
			begin = end;
			end = change;
		} // System.out.println(begin + "" + end);
		for(int add = begin; add <= end; add++) {
			all += add;
		}System.out.println(begin + "부터 " + end + "까지의 합 = " + all);
		System.out.println();
			
		// 연습
		// 평점(1 ~ 5)에 따른 별(★) 출력하기
		
		int score = 3;
		String star = "";
		for(int a = 0; a < score; a++) {
			star += "★";
		}System.out.println("평점 " + score + "점은 " + star + " 입니다.");
		
		
	}

}
