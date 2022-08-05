package leejunghangbabo;

import java.util.Scanner;

public class Baboyayaya {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Hang hang = new Hang(100);
		int randomDamage = (int)(Math.random() * 100) + 1;
		
		System.out.print("안녕하세요 바보씨 이름을 입력하시오 >>> ");
		String lee = sc.nextLine();
		
		System.out.println("이제부터 폭력을 시작하지 " + lee + "!!! ㄹㅇ 오늘 죽을 준비!!! <Enter>");
		sc.nextLine();
		
		System.out.println();
		System.out.println("지금 너의 피는 " +  hang.getHP() + "이다!!! 맞을거면 <Enter>를 눌러라!!!! <Enter>");
		sc.nextLine();
		
		while(hang.getHP() > 0) {
			if(hang.getHP() == 0) {
				return;
			}
		sc.nextLine();
		System.out.println("퍽!!!!!!!");
		
		hang.setHP(hang.getHP() - randomDamage);
		
		System.out.println("흐흫ㅎ.. 너의피는 " + hang.getHP() + " 남았따!!!!");
		}

		System.out.println("불쌍한 " + lee + "는(은) 죽었다!!!! 사요나라!!!!!");
	}

}
