package ex02_create;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateSequenceMain {

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			
			// OracleDriver 로드
			Class.forName("oracle.jdbc.OracleDriver");
			
			// Connection 생성
			String url = "jdbc:oracle:thin:@localhost:1521:xe";  // DB마다 url은 달라짐(Oracle XE 버전 기준)
			String user = "SCOTT";  // 대소문자 상관 없음
			String password = "TIGER";  // 계정 만들 때 사용한 대소문자를 지켜야 함
			con = DriverManager.getConnection(url, user, password);
			
			// 쿼리문 작성
			String sql = "CREATE SEQUENCE BOARD_SEQ NOCACHE";
			
			// PreparedStatement 객체 생성
			ps = con.prepareStatement(sql);
			
			// 쿼리문 실행
			ps.execute();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			
			// Connection 닫기, PreparedStatement 닫기
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
				
			} catch(SQLException e) {
				e.printStackTrace(); 
			}
		}
		
	}

}
