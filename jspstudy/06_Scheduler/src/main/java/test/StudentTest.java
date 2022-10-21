package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import domain.Student;
import repository.StudentDao;

public class StudentTest {

	/*
		순서대로 전체 테스트 돌리기
		1. 삽입
			: 테스터, 50, 50, 50
		2. 목록
		3. 상세
		4. 수정
			: 테스터2, 60, 60, 60
		5. 삭제
	*/
	
	@Before
	public void 삽입테스트() {
		Student s = Student.builder()
				.name("테스터")
				.kor(50)
				.eng(50)
				.math(50)
				.ave(50)
				.grade("F")
				.build();
		assertEquals(1, StudentDao.getInstance().insertStudent(s));
	}
	
	@Test
	public void 목록테스트() {
		assertEquals(1, StudentDao.getInstance().selectAllStudents().size());
	}
	
	@Test
	public void 상세테스트() {
		assertNotNull(StudentDao.getInstance().selectStudentByNo(11));
	}
	
	@Test
	public void 수정테스트() {
		Student s = Student.builder()
				.name("테스터2")
				.kor(60)
				.eng(60)
				.math(60)
				.ave(60)
				.grade("D")
				.stuNo(11)
				.build();
		assertEquals(1, StudentDao.getInstance().updateStudent(s));
	}
	
	@After
	public void 삭제테스트() {
		assertEquals(1, StudentDao.getInstance().deleteStudent(11));
	}
	

}
