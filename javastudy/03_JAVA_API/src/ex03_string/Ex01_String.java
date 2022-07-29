package ex03_string;

public class Ex01_String {

	public static void main(String[] args) {
		
		String str1 = "hello";
		String str2 = "hello";
		
		System.out.println(str1 == str2);
		System.out.println();
		
		String str3 = new String("hi");
		String str4 = new String("hi");
		
		System.out.println(str3 == str4);
		System.out.println();
		
		// 1. 문자열 동등 비교
		
		boolean result1 = str1.equals(str2);
		boolean result2 = str3.equals(str4);
		System.out.println(result1);
		System.out.println(result2);
		if(str1.equals(str2)) {
			System.out.println("같아요");
		} else {
			System.out.println("달라요");
		} System.out.println();
		
		if(!str3.equals(str4)) {
			System.out.println("달라요");
		} else {
			System.out.println("같아요");
		} System.out.println();
		
		// 2. 대소문자를 무시한 문자열 동등 비교
		
		String str5 = "Hello World";
		String str6 = "hELLO wORLD";
		boolean result3 = str5.equalsIgnoreCase(str6);
		System.out.println(result3);
		System.out.println();
		
		// 3. 문자열 길이 반환
		
		String name = "우영우";
		int length = name.length();
		System.out.println("글자수 : " + length);
		System.out.println();
		
		// 4. 특정 위치의 문자(char)만 반환
		// 특정 위치
		// 인덱스(index)라고 함
		// 글자마자 부여된 정수값
		// 0으로 시작
		
		System.out.println(name.charAt(0));
		System.out.println(name.charAt(1));
		System.out.println(name.charAt(2));
		System.out.println();
		
		// 5. 문자열의 일부 문자열(String)을 반환
		// 1) substring(begin) : 인덱스 begin(포함)부터 끝까지 반환
		// 2) substring(begin, end) : 인덱스 begin(포함)부터 인덱스 end(불포함)까지 반환
		
		System.out.println(name.substring(0,1));
		System.out.println(name.substring(1));
		System.out.println();
		
		// 6. 특정 문자열을 찾아서 해당 인덱스(int)를 반환
		//    1) indexOf
		//       (1) 발견된 첫 번째 문자열의 인덱스를 반환
		//       (2) 발견된 문자열이 없는 경우 -1을 반환
		//    2) lastIndexOf
		//       (1) 발견된 마지막 문자열의 인덱스를 반환
		//       (2) 발견된 문자열이 없는 경우 -1을 반환
		
		int idx1 = name.indexOf("우");
		int idx2 = name.indexOf("영우");
		System.out.println(idx1);
		System.out.println(idx2);
		int idx3 = name.lastIndexOf("우");
		int idx4 = name.lastIndexOf("영우");
		System.out.println(idx3);
		System.out.println(idx4);
		System.out.println();
		
		// 7. 문자열이 특정 패턴으로 시작하는가?
		//    startWith(문자열)
		
		if(name.startsWith("우")) {
			System.out.println("우씨입니다.");
		} else {
			System.out.println("우씨가 아닙니다.");
		} System.out.println();
//		System.out.println(name.startsWith("우") ? "우씨입니다." : "우씨가 아닙니다.");
		
		// 8. 문자열이 특정 패턴으로 끝나는지 여부를 boolean(true, false) 반환
		//    endWith(문자열)
		
		String filename = "image.jpg"; // jpg, png로 끝나면 이미지로 가정
		if(filename.endsWith("jpg") || filename.endsWith("png")) {
			System.out.println("이미지입니다.");
		} else {
			System.out.println("이미지가 아닙니다.");
		} System.out.println();
		
		// 9. 문자열이 특정 패턴을 포함하는지 여부를 boolean(true, false) 반환
		//    contains(문자열)
		
		String email = "wjdgod777@naver.com";
		if(email.contains("@") && email.contains(".")) {
			System.out.println("이메일입니다.");
		} else {
			System.out.println("이메일이 아닙니다.");
		} System.out.println();
		
		// 10. 불필요한 공백 제거(좌우 공백)
		//     trim() - 중간 공백은 제거 X
		
		String message = "  안녕  하세요  ";
		System.out.println(message.trim());
		System.out.println(message.trim().length());
		System.out.println();
		
		// 11. 대소문자 변환하기
//		     toUpperCase() : 대문자로 변환하기
//		     toLowerCase() : 소문자로 변환하기
		
		String source = "Best Of Best";
		System.out.println(source.toUpperCase());
		System.out.println(source.toLowerCase());
		System.out.println();
		
		// 12. 찾아 바꾸기
		//     replace(old, new) : old를 new로 변환하기
		
		String replaced = source.replace("Best", "Worst");
		System.out.println(source);
		System.out.println(replaced);
		System.out.println();
		
		// 주의. replaceAll() 메소드는 특정 문자열을 찾아서 변환하는 것이 아님.
		
		String ip = "192.168.101.91";
		String replacedIp = ip.replaceAll(".", "-"); // 192_168_101_91를 기대 -> .은 모든 문자열 변환
		System.out.println(replacedIp);
		System.out.println();
		
		// 13. 빈 문자열인지 여부를 검사한 뒤 boolean(true, false) 반환
		//     isEmpty()
		String id = " ";
		if(id.trim().isEmpty()) {
			System.out.println("빈 문자열");
		} else {
			System.out.println("빈 문자열 아님");
		}
		
		// isBlank는 11버전에 나왔음으로 대중화 X
//		if(id.isBlank()) {
//			System.out.println("빈 문자열");
//		} else {
//			System.out.println("빈 문자열 아님");
//		}
		
		// 연습. 파일이름을 파일명과 확장자로 분리하기
		// 단, jpg, git, png 이미지인 경우에만 작업을 진행한다.
		String fullName = "apple.jpg";
		String fileName = ""; // apple
		String extName = "";  // jpg
		int idxOfDot = fullName.lastIndexOf(".");
		fileName = fullName.substring(0,idxOfDot);
		extName = fullName.substring(idxOfDot+1);
		System.out.println(fileName);
		System.out.println(extName);
		

		// 연습. 문자열 "abc12345def67890ghijk"에서
		// 아라비아숫자,1234567890을 제외하고 한 글자씩 화면에 출력하기
		String str = "abc12345def67890ghijk";
		for(int a = 0; a < str.length(); a++) {
			char ch = str.charAt(a);
			if(ch >= '0' && ch <= '9') {
				continue;
			}
				System.out.print(ch + " ");
		}
		
		
		
	}

}
