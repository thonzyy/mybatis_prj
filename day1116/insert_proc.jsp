<%@page import="day1116.ExamDAO6"%>
<%@page import="day1110.ExamDAO2"%>
<%@page import="kr.co.sist.domain.EmpDomain"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info="" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<div>
procedure를 사용한 추가
</div>
<jsp:useBean id="ipVO" class="kr.co.sist.vo.InsertProcedureVO" scope="page"/>
<jsp:setProperty property="*" name="ipVO"/>
<div>
<form action="index.jsp">
<input type="hidden" name="page" value="${ param.page }"/>
부서번호 : <input type="text" name="deptno" class="inputBox"/><br/>
부서명 : <input type="text" name="dname" class="inputBox"/><br/>
위치 : <input type="text" name="loc" class="inputBox"/><br/>
<input type="submit" value="추가" class="btn btn-info btn-sm"/><br/>
</form>
</div> 

<div>
<c:if test="${ not empty param.deptno }">
<%

ExamDAO6.getInstance().insertProcedure(ipVO);
pageContext.setAttribute("ipVO", ipVO);
%>
<c:out value="${ ipVO.deptno }"/>번 부서의 추가 작업 결과<br/>
<c:out value="${ ipVO.msg }"/>

</c:if>
</div>


