package quiz08_schedule;

public class Day {

	private String schedule;

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	
	public void printSchedule() {
		// 스케쥴이 없거나 빈 문자열이면 
		if(schedule == null || schedule.trim().isEmpty()) {
			System.out.println("X");
		} else {
			System.out.println(schedule);
		}
	}
	
}
