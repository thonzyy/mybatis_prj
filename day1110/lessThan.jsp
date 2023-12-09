<%@page import="kr.co.sist.domain.EmpDomain"%>
<%@page import="java.util.List"%>
<%@page import="day1110.ExamDAO2"%>
<%@page import="kr.co.sist.domain.CpDeptDomain"%>
<%@page import="day1109.ExamDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page info="" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <div>
&lt;의 조회
</div>

<div>
<form action="index.jsp" >
<input type="hidden" name="page" value="${param.page }"/>
연봉 : <input type="text" name="sal" class="inputBox">
<input type="submit" value="조회" class="btn btn-info btn-sm"/>

 </form>
</div>

<c:if test="${not empty param.sal }">
<div>
<%
int sal= Integer.parseInt(request.getParameter("sal"));
List<EmpDomain> empList=ExamDAO2.getInstance().lessThan(sal);

pageContext.setAttribute("empList", empList);
%>
<table class="table">
<tr>
<th>번호</th>
<th>사원번호</th>
<th>사원명</th>
<th>연봉</th>
</tr>
<c:if test="${empty empList }">
<tr>
<td colspan="5">사원 정보가 존재하지 않습니다.</td>
</tr>
</c:if>
<c:forEach var="emp" items="${empList }" varStatus="i">
<tr>
<td><c:out value="${i.count }"/></td>
<td><c:out value="${emp.empno }"/></td>
<td><c:out value="${emp.ename}"/></td>
<td><c:out value="${emp.sal}"/></td>
</tr>
</c:forEach>
</table>
</div>
</c:if>