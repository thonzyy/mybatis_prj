package day1108;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.sist.dao.MyBatisHandler;
import kr.co.sist.vo.DeptVO;

public class UseMyBatisDAO {

	public void insertDeptno(int deptno) throws PersistenceException{
		//.1 마이 바티스 핸들러 얻기
		SqlSession handler = MyBatisHandler.getInstance().getMyBatisHandler("kr/co/sist/dao/mybatis-config.xml", false);
		//2. 쿼리문을 찾아서 실행
		int cnt = handler.insert("kr.co.sist.dept.insertCpDeptno",deptno);
		if(cnt==1) {
			handler.commit();
		}
		handler.close();
	}
	
	public void insertSeqDeptno() throws PersistenceException{
		//.1 마이 바티스 핸들러 얻기
		SqlSession handler = MyBatisHandler.getInstance().getMyBatisHandler("kr/co/sist/dao/mybatis-config.xml", false);
		//2. 쿼리문을 찾아서 실행
		int cnt = handler.insert("kr.co.sist.dept.insertSeqCpDept");
		if(cnt==1) {
			handler.commit();
		}
		if(handler!=null) {
			handler.close();
		}
	}
	
	public int updateDeptno(DeptVO dVO) throws PersistenceException{
		
		int cnt=0;
		//.1 마이 바티스 핸들러 얻기
		
		SqlSession handler = MyBatisHandler.getInstance().getMyBatisHandler("kr/co/sist/dao/mybatis-config.xml", false);
		//2. 쿼리문을 찾아서 실행
		cnt = handler.update("kr.co.sist.dept.updateCpDept", dVO);
		if(cnt==1) {
			handler.commit();
		}
	
			handler.close();
			return cnt;
			
		
	}
}
