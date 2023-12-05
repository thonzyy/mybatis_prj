package day1106;

import org.apache.ibatis.exceptions.PersistenceException;

import kr.co.sist.vo.DeptVO;

public class TestMyBatis {
	
	public void addDept() {
		DeptVO dVO = new DeptVO();
		dVO.setDeptno(82);
		dVO.setDname("개발");
		dVO.setLoc("서울");
		
		DeptDAO dDAO = new DeptDAO();
		
		try {
			dDAO.insert(dVO);
			System.out.println("추가성공");
			
		} catch(PersistenceException pe) {
//			pe.printStackTrace();
			System.out.println("추가실패");
		}
	}
	
	public static void main(String[] args) {
		TestMyBatis tmb = new TestMyBatis();
		tmb.addDept();
	}

}
