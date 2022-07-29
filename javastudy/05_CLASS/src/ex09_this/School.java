package ex09_this;

public class School {

	// 필드
	private Student[] students;
	private int idx;
	
	// 생성자
	public School(int cnt) {
		students = new Student[cnt];
	}
	
	// 메소드
	public void addStudent(Student student) {
		if(idx == students.length) {
			System.out.println("Full");
			return;
		}
		students[idx++] = student;	
	
	}
	
	public void printStudents() {
//		for(int i = 0; i < idx; i++) {
//			System.out.println(students[i].getName() + ", " + students[i].getStuNo());
//		}
		for(Student student : students) {
			if(student != null) {
			System.out.println(student.getName() + ", " + student.getStuNo());
			}
		}
	}
	
}
