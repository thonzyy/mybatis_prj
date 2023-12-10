<%@page import="day1113.ExamDAO3"%>
<%@page import="kr.co.sist.domain.EmpDomain"%>
<%@page import="java.util.List"%>
<%@page import="day1110.ExamDAO2"%>
<%@page import="kr.co.sist.domain.CpDeptDomain"%>
<%@page import="day1109.ExamDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page info="" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <div>
$의 조회
</div>

<div>
<form action="index.jsp" >
<input type="hidden" name="page" value="${param.page}"/>
<input type="radio" name="type" value="1" ${param.type eq '1' ? " checked='checked'" : "" }>본사
<input type="radio" name="type" value="2" ${param.type eq '2' ? " checked='checked'" : "" }>지사
<input type="submit" value="조회" class="btn btn-info btn-sm"/>

 </form>
</div>

<c:if test="${not empty param.type }">
<div>
<%
String type=request.getParameter("type");
String tableName= "cp_emp3";
if(type==null||"1".equals(type)) {
	tableName="emp";
}//end if 
List<EmpDomain> empList=ExamDAO3.getInstance().dollarSign(tableName);

pageContext.setAttribute("empList", empList);
%>
<table class="table">
<tr>
<th>번호</th>
<th>사원번호</th>
<th>사원명</th>
<th>연봉</th>
<th>직무</th>
<th>부서번호</th>
<th>입사일</th>
</tr>
<c:if test="${empty empList }">
<tr>
<td colspan="4">사원 정보가 존재하지 않습니다.</td>
</tr>
</c:if>
<c:forEach var="emp" items="${empList }" varStatus="i">
<tr>
<td><c:out value="${i.count }"/></td>
<td><c:out value="${emp.empno }"/></td>
<td><c:out value="${emp.ename}"/></td>
<td><c:out value="${emp.sal}"/></td>
<td><c:out value="${emp.job}"/></td>
<td><c:out value="${emp.deptno}"/></td>
<td><c:out value="${emp.hiredate}"/></td>
</tr>
</c:forEach>
</table>
</div>
</c:if>