package quiz01_library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryList {

	public static void m1() {
		List<String> books = new ArrayList<String>();
		books.add("어");
		books.add("린");
		books.add("왕");
		books.add("자");
		if(books.isEmpty()) {
			System.out.println("책이 없습니다.");
		} else {
			boolean result = books.remove("어");
			System.out.println(result);
			String removeItem = books.remove(1);
			System.out.println(removeItem);
		}System.out.println(books);
		
		if(books.contains("자")) {
			System.out.println("마지막권이 있습니다.");
		} else {
			System.out.println("마지막권이 없습니다.");
		}
		
//		for(int i = 0, length = books.size(); i < length; i++) {
//			Scanner sc = new Scanner(System.in);
//			String str = sc.next();
//			if() {
//				
//			} else {
//				System.out.println("일치하는 책의 정보가 없습니다.");
//			}
//		}
		
	}
	public static void main(String[] args) {

		m1();
		
		
		
	}
	
}

