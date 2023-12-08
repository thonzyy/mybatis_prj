package day1109;

import kr.co.sist.vo.TestVO;

public class UseLombok {

	public static void main(String[] args) {
		TestVO tVO = new TestVO();
		tVO.setAddr("우리집");
		tVO.setName("임태균");
		tVO.setNum(1);
		
		System.out.println(tVO);
		System.out.println(tVO.getAddr()+"/"+tVO.getName()+"/"+tVO.getNum() );
	}

}
