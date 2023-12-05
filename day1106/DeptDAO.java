package day1106;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.sist.dao.MyBatisHandler;
import kr.co.sist.vo.DeptVO;

public class DeptDAO {
	
	public void insert(DeptVO dVO) throws PersistenceException {
		int cnt = 0;
		//1.MyBatis Handler 얻기
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getMyBatisHandler("kr/co/sist/dao/mybatis-config.xml", true);
		
		//2.DB 작업 수행
		cnt = ss.insert("kr.co.sist.dept.insertDept", dVO);
//		if(cnt == 1) {
//			ss.commit();
//		}
		
		//3.Handler 닫기
		ss.close();
	}

}
