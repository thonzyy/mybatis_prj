package day1109;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.sist.dao.MyBatisHandler;

public class ExamDAO {
	private static ExamDAO eDAO;
	private ExamDAO() {
		
	}
	
	public static ExamDAO getInstance() {
		if(eDAO==null) {
			eDAO= new ExamDAO();
		}
		return eDAO;
	}//getInstance
	
	public String scsr(int deptno)throws PersistenceException {
		
		String dname="";
		
		MyBatisHandler mbh= MyBatisHandler.getInstance();
		SqlSession ss= mbh.getMyBatisHandler("kr/co/sist/dao/mybatis-config.xml", false);
		
		// 쿼리문 실행
		dname=ss.selectOne("kr.co.sist.exam.scsr",deptno);
		
		mbh.closeHandler(ss);
		
		
		return dname;
	}//scsr
}
