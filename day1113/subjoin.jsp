<%@page import="day1113.ExamService"%>
<%@page import="day1113.ExamDAO3"%>
<%@page import="kr.co.sist.domain.CarDomain"%>
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
subjoin의 조회
</div>
<a href="index.jsp?page=day1113/subjoin&country=국산">국산</a>
<a href="index.jsp?page=day1113/subjoin&country=수입">수입</a>

<div>
<%
String country= request.getParameter("country");
if(country==null) {
	country="국산";
}
ExamService es = new ExamService();
List<CarDomain> carList = es.useSubjoin(country);
pageContext.setAttribute("carList", carList);
%>

<table class="table">
<tr>
<th>번호</th>
<th>모델명</th>
<th>가격</th>
<th>연식</th>
<th>옵션</th>
<th>구매일</th>
</tr>
<c:if test="${empty carList }">
<tr>
<td colspan="6">차량 정보가 존재하지 않습니다.</td>
</tr>
</c:if>
<c:forEach var="cd" items="${carList }" varStatus="i">
<tr>
<td><c:out value="${i.count }"/></td>
<td><c:out value="${cd.model }"/></td>
<td><fmt:formatNumber pattern="##,###" value="${cd.price}"/></td>
<td><c:out value="${cd.car_year}"/></td>
<td><c:out value="${cd.car_option}"/></td>
<td><fmt:formatDate pattern="MM-dd-yyyy" value="${cd.hiredate}"/></td>
</tr>
</c:forEach>
</table>
</div>
