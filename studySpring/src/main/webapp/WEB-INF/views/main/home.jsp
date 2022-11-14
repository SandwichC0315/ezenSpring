<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
	<meta charset="UTF-8">
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="<%=request.getContextPath()%>/board/list.do">링크</a><br/>
<a href="<%=request.getContextPath()%>/sample1110/paramex.do">계산하러 가기</a><br/>
<a href="<%=request.getContextPath()%>/student/insert.do">학생 정보 입력하기</a><br/>
<a href="<%=request.getContextPath()%>/board/list.do">boardtb 데이터 목록 조회하기</a><br/>
<a href="<%=request.getContextPath()%>/user/list.do">usertb 데이터 목록 조회하기</a>
</body>
</html>
