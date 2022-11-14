<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>학생 정보 입력하기</h2>
	<form action="<%=request.getContextPath()%>/student/result.do" method="post">
		<fieldset>
			<legend>학생1</legend>
			이름 : <input type="text" name="s1name"><br/>
			수학 : <input type="number" name="s1math"><br/>
			국어 : <input type="number" name="s1kor"><br/>
			영어 : <input type="number" name="s1english"><br/>
		</fieldset>
		
		<fieldset>
			<legend>학생2</legend>
			이름 : <input type="text" name="s2name"><br/>
			수학 : <input type="number" name="s2math"><br/>
			국어 : <input type="number" name="s2kor"><br/>
			영어 : <input type="number" name="s2english"><br/>
		</fieldset>
		
		<fieldset>
			<legend>학생3</legend>
			이름 : <input type="text" name="s3name"><br/>
			수학 : <input type="number" name="s3math"><br/>
			국어 : <input type="number" name="s3kor"><br/>
			영어 : <input type="number" name="s3english"><br/>
		</fieldset>
		<input type="submit" value="등록">
	</form>
</body>
</html>