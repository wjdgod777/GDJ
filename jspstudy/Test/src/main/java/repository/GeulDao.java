package repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.Geul;
import domain.Geul;

public class GeulDao {
	
	private SqlSessionFactory factory;

	
	private static GeulDao dao = new GeulDao();
	private GeulDao() {
		try {
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream in = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(in);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static GeulDao getInstance() {
		return dao;
	}
	
	String mapper = "mybatis.mapper.geul.";
	
	public List<Geul> selectAllGeuls() {
		SqlSession ss = factory.openSession();
		List<Geul> geuls = ss.selectList(mapper + "selectAllGeuls");
		ss.close();
		return geuls;
	}
	
	public int selectAllGealsCount() {
		SqlSession ss = factory.openSession();
		int count = ss.selectOne(mapper + "selectAllGealsCount");
		ss.close();
		return count;
	}
	
	public int insertGeul(Geul geul) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert(mapper + "insertGeul", geul);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	public Geul selectGeulByNo(int geulNo) {
		SqlSession ss = factory.openSession();
		Geul geul = ss.selectOne(mapper + "selectGeulByNo", geulNo);  // geulNo를 파라미터로 전달
		ss.close();
		return geul;
	}
	
}
