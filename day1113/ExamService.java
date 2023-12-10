package day1113;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.sist.dao.MyBatisHandler;
import kr.co.sist.domain.CarDomain;

public class ExamService {
	
	
	public List<CarDomain> useSubjoin( String Country)throws PersistenceException{
		List<CarDomain> list= null;
		ExamDAO3 eDAO = ExamDAO3.getInstance();
		
		try {
			list=eDAO.subjoin(Country);
			CarDomain cd= null;
			String option="";
			for(int i = 0 ; i<list.size() ; i++) {
				cd=list.get(i);
				option=cd.getCar_option();
				
				if(option.length() > 19) {
					cd.setCar_option(option.substring(0,18)+"...");
					list.set(i, cd);
				}//end if 
			}//end for 
		}catch(PersistenceException pe ) {
			pe.printStackTrace();
		}
		
		return list;
	}

}
