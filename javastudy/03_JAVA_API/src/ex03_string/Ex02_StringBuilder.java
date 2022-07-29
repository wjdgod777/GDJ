package ex03_string;

public class Ex02_StringBuilder {

	public static void main(String[] args) {
		
		// java.lang.StringBuilder 클래스
		// append(문자열) 기존 내용에 문자열 추가
		StringBuilder sb = new StringBuilder();
		sb.append(1);
		sb.append(true);
		sb.append('T');
		sb.append(3.14);
		sb.append("hello");
		System.out.println(sb);
		System.out.println();
		
		// StringBuilder로 만든 문자열은 반드시 마지막에 String으로 변환해야 함
		String result = sb.toString();
		System.out.println(result.equals("1trueT3.14hello"));
		System.out.println();
		
		// String과 StringBuilder의 성능 테스트
		// abcdefghijklmnopqrstuvwxyz
		// StringBuilder가 더 빠르다.
		
		String alphabet1 = "";
		long begin1 = System.nanoTime();
		for(char ch = 'a'; ch <= 'z'; ch++) {
			alphabet1 += ch;
		}
		long end1 = System.nanoTime();
		System.out.println("알파벳 = "+ alphabet1 + " 계산하는데 걸린 시간 = " + (end1 - begin1));
		
		StringBuilder sb2 = new StringBuilder();
		long begin2 = System.nanoTime();
		for(char ch = 'a'; ch <= 'z'; ch++) {
			sb2.append(ch);
		}
		long end2 = System.nanoTime();
		String alphabet2 = sb2.toString();
		System.out.println("알파벳 = "+ alphabet2 + " 계산하는데 걸린 시간 = " + (end2 - begin2));
		
		// 연습. 대문자 6자리로 구성된 인증코드 작성하기
		StringBuilder sbCode = new StringBuilder();
		for(int sbc = 0; sbc < 6; sbc++) {
			sbCode.append((char)((int)(Math.random() * 26) + 'A'));
		}
		
		String code = sbCode.toString();
		System.out.println("인증코드 : " + code);
		
		// 연습. 1 2 3 4 5 6 7 8 9 10 만들기
		StringBuilder sbPaging = new StringBuilder();
		for(int pa = 1; pa <= 10; pa++) {
			sbPaging.append(pa + " ");
		}
		
		String paging = sbPaging.toString();
		System.out.println(paging);
		
		}

}
