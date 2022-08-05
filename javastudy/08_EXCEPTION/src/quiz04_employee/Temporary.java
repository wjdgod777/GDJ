package quiz04_employee;

public class Temporary extends Employee {
	
	private int pay;
	private int workTimes;
	


	public Temporary(int empNo, String name, int pay, int workTimes) {
		super(empNo, name);
		this.pay = pay;
		this.workTimes = workTimes;
	}



	@Override
	public String toString() {
		return super.toString() + ", pay=" + pay + ", workTimes=" + workTimes + "]";
	}
	
	

	
}
