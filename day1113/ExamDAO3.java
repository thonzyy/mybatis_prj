package day1113;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.sist.dao.MyBatisHandler;
import kr.co.sist.domain.CarDomain;
import kr.co.sist.domain.EmpDomain;
import kr.co.sist.domain.JoinDomain;
import kr.co.sist.vo.BoardVO;

public class ExamDAO3 {

	private static ExamDAO3 eDAO3;
	private String configPath;
	
	private ExamDAO3() {
	configPath="kr/co/sist/dao/mybatis-config.xml";
	}
	public static ExamDAO3 getInstance() {
		if(eDAO3==null) {
			eDAO3= new ExamDAO3();
		}
		
		return eDAO3;
	}
	
	public List<CarDomain> selectSubquery(BoardVO bVO)throws PersistenceException{
		List<CarDomain> list = null;
		
		
		//1 핸들러 얻기
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		
		SqlSession ss = mbh.getMyBatisHandler(configPath, false);
		
		list=ss.selectList("kr.co.sist.exam3.subQuery", bVO);
		
		mbh.closeHandler(ss);
	
		
		return list;
	}
	
	public List<EmpDomain> union()throws PersistenceException{
		List<EmpDomain> list= null;
		
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getMyBatisHandler(configPath, false);
		
		list=ss.selectList("kr.co.sist.exam3.union");
		
		mbh.closeHandler(ss);
		return list;
	}
	
	public List<JoinDomain> join()throws PersistenceException{
		List<JoinDomain> list= null;
		
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getMyBatisHandler(configPath, false);
		
		list=ss.selectList("kr.co.sist.exam3.join");
		
		mbh.closeHandler(ss);
		return list;
	}
	
	public List<CarDomain> subjoin(String country)throws PersistenceException{
		List<CarDomain> list= null;
		
		MyBatisHandler mbh = MyBatisHandler.getInstance();
		SqlSession ss = mbh.getMyBatisHandler(configPath, false);
		
		list=ss.selectList("kr.co.sist.exam3.subjoin",country);
		
		mbh.closeHandler(ss);
		return list;
	}
	
	public List<EmpDomain> dollarSign(String tableName)throws PersistenceException {
		List<EmpDomain> list= null;
		MyBatisHandler mbh= MyBatisHandler.getInstance();
		SqlSession ss= mbh.getMyBatisHandler(configPath, false);
		list= ss.selectList("kr.co.sist.exam3.dollarSign",tableName);
		mbh.closeHandler(ss);
		
		return list;
	}
	public static void main(String[] args) {
		BoardVO bVO = new BoardVO();
		bVO.setStartNum(4);
		bVO.setEndNum(10);
		
		ExamDAO3.getInstance().dollarSign("cp_emp3");
	}
	
	

}
