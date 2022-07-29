package ex08_access.modifier;

public class UserMain {

	public static void main(String[] args) {
		
		User user = new User();
		
		user.setId("admin");
		System.out.println(user.getId());
		
		user.setPassword("1234qwer");
		System.out.println(user.getPassword());
		
		user.setEmail("123@naver.com");
		System.out.println(user.getEmail());
		
		user.setPoint(10000);
		System.out.println(user.getPoint());
		
//		user.setIsVip(false);
		System.out.println(user.getIsVip());
		
	}

}
