package day1108;

import org.apache.ibatis.exceptions.PersistenceException;

import kr.co.sist.vo.DeptVO;

public class UseMyBatis {
	
	public void UseinsertDeptno() {
		UseMyBatisDAO umDAO = new UseMyBatisDAO();
		
		try {
			
			umDAO.insertDeptno(53);
			System.out.println("추가성공");
		}catch (PersistenceException pe) {
			System.out.println("추가실패");
			pe.printStackTrace();
		}
		
	}
	
	public void UseinsertSeqDeptno() {
		UseMyBatisDAO umDAO = new UseMyBatisDAO();
		
		try {
			
			umDAO.insertSeqDeptno();
			System.out.println("추가성공");
		}catch (PersistenceException pe) {
			System.out.println("추가실패");
			pe.printStackTrace();
		}
		
	}
	
	public void useUpdateDept() {
		UseMyBatisDAO umDAO = new UseMyBatisDAO();
		
		try {
			DeptVO dVO = new DeptVO();
			dVO.setDeptno(10);
			dVO.setDname("SI");
			dVO.setLoc("서울");
			int cnt = umDAO.updateDeptno(dVO);
			
			if(cnt==1) {
				System.out.println("변경성공");
				
			}else {
				
				System.out.println("변경된 값이 없습니다.");
			}
		}catch (PersistenceException pe) {
			System.out.println("에러");
			pe.printStackTrace();
		}//end catch
		
	}
		public static void main(String[] args) {
			UseMyBatis umb = new UseMyBatis();
			//umb.UseinsertDeptno();
			umb.useUpdateDept();
		}
}
