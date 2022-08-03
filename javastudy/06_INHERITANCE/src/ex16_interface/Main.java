package ex16_interface;

// 산책이 가능한 애완동물(Pet)은 Walkable 인터페이스를 구현시키고,
// 산책 메소드에서는 Walkable 타입의 애완동물만 받는다.

public class Main {

	public static void main(String[] args) {

		Dog dog = new Dog("백구");
		Cat cat = new Cat("냥냥이");
		Snake snake = new Snake("낼름이");
		
		Person person = new Person();
		person.foodFeed(dog, "개껌");	// 백구에게 개껌주기
		person.foodFeed(cat, "츄르");	// 냥냥이에게 츄르주기
		person.foodFeed(snake, "쥐");	// 낼름이에게 쥐주기
		
		person.walk(dog);	// 백구와 산책
		person.walk(cat);	// 냥냥이와 산책
//		person.walk(snake);	// 실행을 못하게 막고 싶다.
		
		
	}

}
