package day1110;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.sist.dao.MyBatisHandler;
import kr.co.sist.domain.CpDeptDomain;
import kr.co.sist.domain.EmpDomain;
import kr.co.sist.domain.ZipcodeDomain;
import kr.co.sist.vo.EmpVO;

public class ExamDAO2 {
	private static ExamDAO2 eDAO2;
	private  String configXML;
	private ExamDAO2() {
		configXML="kr/co/sist/dao/mybatis-config.xml";
	}
	
	public static ExamDAO2 getInstance() {
		if (eDAO2==null) {
			eDAO2= new ExamDAO2();
		}
		return eDAO2;
	}//getInstance
	
	/**
	 * 여러 컬럼에 행 하나 조회
	 * @param deptno
	 * @return
	 * @throws PersistenceException
	 */
	public CpDeptDomain mcsr(int deptno)throws PersistenceException  {
		CpDeptDomain cdd= null;
		MyBatisHandler mbh= MyBatisHandler.getInstance();
		//1핸들러 얻기
		SqlSession ss= mbh.getMyBatisHandler("kr/co/sist/dao/mybatis-config.xml", false);
		//2. 수행 후 결과 얻기
		cdd=ss.selectOne("kr.co.sist.exam2.mcsr",deptno);
		//3 핸들러 닫기
		mbh.closeHandler(ss);
		return cdd;
	}
	
	
	/**
	 * 컬럼 하나에 여러 행 조회
	 * @param deptno
	 * @return
	 * @throws PersistenceException
	 */
	public List<String> scmr(int deptno )throws PersistenceException{
		List<String> list = null;
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		
		
		//1.핸들러 얻기
		SqlSession ss= mbh.getMyBatisHandler("kr/co/sist/dao/mybatis-config.xml", false);
		
		//2. 파싱할 노드를 찾고, 쿼리를 수행
		list= ss.selectList("kr.co.sist.exam2.scmr",deptno);
		
		
		//3. 핸들러 닫기
		mbh.closeHandler(ss);
		return list;
	}//scmr
	
	public List<Integer> exam(int deptno )throws PersistenceException{
		List<Integer> list = null;
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		
		
		//1.핸들러 얻기
		SqlSession ss= mbh.getMyBatisHandler("kr/co/sist/dao/mybatis-config.xml", false);
		
		//2. 파싱할 노드를 찾고, 쿼리를 수행
		list= ss.selectList("kr.co.sist.exam2.exam",deptno);
		
		
		//3. 핸들러 닫기
		mbh.closeHandler(ss);
		return list;
	}//scmr
	
	public List<EmpDomain> mcmr( )throws PersistenceException{
		List<EmpDomain> list = null;
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		
		
		//1.핸들러 얻기
		SqlSession ss= mbh.getMyBatisHandler("kr/co/sist/dao/mybatis-config.xml", false);
		
		//2. 파싱할 노드를 찾고, 쿼리를 수행
		list= ss.selectList("kr.co.sist.exam2.mcmr");
		
		
		//3. 핸들러 닫기
		mbh.closeHandler(ss);
		return list;
	}//scmr
	
	public List<EmpDomain> lessThan(int sal)throws PersistenceException{
		List<EmpDomain>list = null;
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss= mbh.getMyBatisHandler(configXML, false);
		
		list=ss.selectList("kr.co.sist.exam2.lessThan", sal);
		
		mbh.closeHandler(ss);
		return list;
	}
	
	public List<EmpDomain> greaterThan(int sal)throws PersistenceException{
		List<EmpDomain>list = null;
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss= mbh.getMyBatisHandler(configXML, false);
		
		list=ss.selectList("kr.co.sist.exam2.greaterThan", sal);
		
		mbh.closeHandler(ss);
		return list;
	}
	
	public List<ZipcodeDomain> selectZipcode(String dong )throws PersistenceException{
		List<ZipcodeDomain> list = null;
		MyBatisHandler mbh= MyBatisHandler.getInstance();
		SqlSession ss = mbh.getMyBatisHandler(configXML, false);
		list = ss.selectList("kr.co.sist.exam2.like",dong);
		
		mbh.closeHandler(ss);
		return list;
	}
	
	public static void main(String[] args) {
		ExamDAO2 ed=ExamDAO2.getInstance();
		System.out.println(ed.selectZipcode("역삼동"));
	}
}
