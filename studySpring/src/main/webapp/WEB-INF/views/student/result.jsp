<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>학생들의 평균 점수 출력</h2>
	학생 1의 전체 평균 점수 : <%=request.getAttribute("s1aver")%><!-- 여기에 출력  -->
	<br/>
	학생 2의 전체 평균 점수 : <%=request.getAttribute("s2aver")%><!-- 여기에 출력  -->
	<br/>
	학생 3의 전체 평균 점수 : <%=request.getAttribute("s3aver")%><!-- 여기에 출력  -->
	<br/>
	<br/>
	수학 과목의 평균 점수 : <%=request.getAttribute("mathaver")%><!-- 여기에 출력  -->
	<br/>
	국어 과목의 평균 점수 : <%=request.getAttribute("korever")%><!-- 여기에 출력  -->
	<br/>
	영어 과목의 평균 점수 : <%=request.getAttribute("engaver")%><!-- 여기에 출력  -->
	<br/>
</body>
</html>