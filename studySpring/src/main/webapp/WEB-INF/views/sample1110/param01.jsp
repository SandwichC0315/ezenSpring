<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Spring으로 파라미터 넘기기 예제</h2>
	<form action="<%=request.getContextPath()%>/sample1110/result.do" method="post">
		1 : <input type="number" name="num1" required><br/>
		1 : <input type="number" name="num2" required><br/>
		연산자 : 
		<input type="radio" name="oper" value="plus">+ 
		<input type="radio" name="oper" value="minus">-
		<input type="radio" name="oper" value="multi">*
		<input type="radio" name="oper" value="divide">/
		<br/>
		<input type="submit" value="계산하기">
	</form>
</body>
</html>