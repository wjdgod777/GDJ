package ex08_access.modifier;

public class User {

	// 필드는 private이다.
	private String id;
	private String password;
	private String email;
	private int point;
	private boolean isVip;
	
	// 메소드는 public이다.
	public String getId() {
		return id;
	}
	public void setId(String pId) {
		id = pId;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String pPassword) {
		password = pPassword;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String pEmail) {
		email = pEmail;
	}
	
	public int getPoint() {
		return point;
	}
	public void setPoint(int pPoint) {
		point = pPoint;
		setIsVip(point>=1000);
	}
	
	public boolean getIsVip() {
		return isVip;
	}
	private void setIsVip(boolean pIsVip) {
		isVip = pIsVip;
		
	}
	
}
