package ex06_constructor;

public class StudentMain {

	public static void main(String[] args) {

		Student student = new Student("이름", "학교");
		
		System.out.println(student.getName());
		System.out.println(student.getSchool());

	}

}
