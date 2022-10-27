package repository;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.Member;

public class MemberDao {

	// SqlSessionFactory 빌드
	private SqlSessionFactory factory;
	
	// singleton - pattern
	private static MemberDao dao = new MemberDao();
	private MemberDao() {
		try {
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream in = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(in);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static MemberDao getInstance() {
		return dao;
	}
	
	String mapper = "mybatis.mapper.member.";
	
	public Member login(Member member) {
		SqlSession ss = factory.openSession();
		Member login = ss.selectOne(mapper + "login", member);
		return login;
	}
	
	public int insertMember(Member member) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert(mapper + "insertMember", member);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	public int deleteMember(int memberNo) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete(mapper + "deleteMember", memberNo);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;	
	}
	
	
}
