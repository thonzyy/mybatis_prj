<%@page import="day1114.ExamDAO4"%>
<%@page import="day1110.ExamDAO2"%>
<%@page import="kr.co.sist.domain.EmpDomain"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info="" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<div>
dynamic if 의 조회
</div>
<jsp:useBean id="bVO" class="kr.co.sist.vo.BoardVO" scope="page"/>
<jsp:setProperty name="bVO" property="*"/>
<div>
<form action="index.jsp">
<input type="hidden" name="page" value="${ param.page }"/>
<select name="fieldName">
<option value="content">내용</option>
<option value="writer">작성자</option>
</select>
 <input type="text" name="keyword" class="inputBox"/>
<input type="submit" value="검색" class="btn btn-info btn-sm"/><br/>
</form>
</div> 
<div>
<%
ExamDAO4 eDAO=ExamDAO4.getInstance();
int totalCnt=eDAO.dynamicIf(bVO);
%>
총 레코드의 수 : <%= totalCnt %> 건
</div>


