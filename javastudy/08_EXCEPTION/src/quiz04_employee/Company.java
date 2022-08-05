package quiz04_employee;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Company {

	private Employee[] employees;
	private int idx;
	private Scanner sc;
	
	public Company() {
		employees = new Employee[5];
		sc = new Scanner(System.in);
	}
	
	public void addEmployee() throws EmployeeException {
		if(idx == employees.length) {
			throw new EmployeeException("FULL", 1);
		}
		System.out.print("고용형태를 입력하세요(1.정규직 / 2.고용직) >>> ");
		int job = sc.nextInt();
		System.out.print("추가할 사번 >>> ");
		int empNo = sc.nextInt();
		for(int i = 0; i < idx; i++) {
			if(employees[i].getEmpNo() == empNo) {
				System.out.println("중복된 사번입니다.");
				return;
			}
		}
		System.out.print("추가할 이름 >>> ");
		String name = sc.next();
		if(job == 1) {
			System.out.print("월급을 입력하세요 >>> ");
			int salary = sc.nextInt();
			Employee reg = new Regular(empNo, name, salary);
			employees[idx++] = reg;
		} else if(job == 2) {
			System.out.print("시급을 입력하세요 >>> ");
			int pay = sc.nextInt();
			System.out.print("일하는 시간을 적어주세요 >>> ");
			int workTime = sc.nextInt();
			Employee tem = new Temporary(empNo, name, pay, workTime);
			employees[idx++] = tem;
		}
		
		
	}

	public void dropEmployee() throws EmployeeException {
		if(idx == 0) {
			throw new EmployeeException("EMPTY", 2);
		}
		System.out.print("제거할 사번 >>> ");
		int number = sc.nextInt();
		for(int i = 0; i < idx; i++) {
			if(employees[i].getEmpNo() == number) {
				System.arraycopy(employees, i + 1, employees, i, idx - i - 1);
				employees[--idx] = null;
				System.out.println(number + "가 삭제되었습니다.");
				return;
			} 
		}
		
	}

	public void findEmployee() throws EmployeeException {
		if(idx == 0) {
			throw new EmployeeException("EMPTY", 2);
		}
		System.out.print("검색할 사번 >>> ");
		int number = sc.nextInt();
		for(int i = 0; i < idx; i++) {
			if(employees[i].getEmpNo() == number) {
				System.out.println(employees[i]);
			}
		}
		
	}

	public void printAllEmployees() throws EmployeeException {
		if(idx == 0) {
			throw new EmployeeException("EMPTY", 2);
		}
		for(int i = 0; i < idx; i++) {
			System.out.println(employees[i]);
		}
	}
	
	public void manage() {
		
		while(true) {
			try {
				System.out.print("1.추가 2.삭제 3.조회 4.목록 0.종료 >>> ");
				int choice = sc.nextInt();
				sc.nextLine();
				switch(choice) {
				case 1 : addEmployee(); break;
				case 2 : dropEmployee(); break;
				case 3 : findEmployee(); break;
				case 4 : printAllEmployees(); break;
				case 0 : return;
				default : System.out.println("알 수 없는 명령");
				}
			} catch(InputMismatchException e) {
				sc.next();
				System.out.println("명령은 정수로 입력");
			} catch(EmployeeException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

}
