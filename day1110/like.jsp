<%@page import="kr.co.sist.domain.ZipcodeDomain"%>
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
like의 조회
</div>

<div>
<form action="index.jsp" >
<input type="hidden" name="page" value="${param.page }"/>
동이름 : <input type="text" name="dong" class="inputBox">
<input type="submit" value="조회" class="btn btn-info btn-sm"/><br/>
예) 역삼동, 역삼1동

 </form>
</div>

<c:if test="${not empty param.dong }">
<div>
<%
String dong= request.getParameter("dong");
List<ZipcodeDomain> zipList=ExamDAO2.getInstance().selectZipcode(dong);

pageContext.setAttribute("zipList", zipList);
%>
<table class="table">
<tr>
<th>번호</th>
<th>우편번호</th>
<th>주소</th>
</tr>
<c:if test="${empty zipList }">
<tr>
<td colspan="3"><c:out value="${param.dong }"/>은 존재하지 않습니다.<br>
동 이름을 확인하세요,</td>
</tr>
</c:if>
<c:forEach var="zd" items="${zipList }" varStatus="i">
<tr>
<td><c:out value="${i.count }"/></td>
<td><c:out value="${zd.zipcode }"/></td>
<td><c:out value="${zd.sido}"/> <c:out value="${zd.gugun}"/>
<c:out value="${zd.dong}"/><c:out value="${zd.bunji}"/></td>
</tr>
</c:forEach>
</table>
</div>
</c:if>