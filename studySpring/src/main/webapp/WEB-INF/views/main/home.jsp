<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Home</title>
<meta charset="UTF-8">
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
	<a href="<%=request.getContextPath()%>/board/list.do">링크</a>
	<br />
	<a href="<%=request.getContextPath()%>/sample1110/paramex.do">계산하러 가기</a>
	<br />
	<a href="<%=request.getContextPath()%>/student/insert.do">학생 정보 입력하기</a>
	<br />
	<a href="<%=request.getContextPath()%>/board/list.do">boardtb 데이터 목록 조회하기</a>
	<br />
	<a href="<%=request.getContextPath()%>/user/list.do">usertb 유저 목록 조회하기</a>
	<br />
	<br />
	<br />


	<c:if test="${login != null}">
	${login.name} 님 환영합니다.
	<button onclick="location.href='user/logout.do'">로그아웃</button>
	</c:if>

	<c:if test="${login == null }">
		<form action="user/login.do" method="post">
			id : <input type="text" name="id"><br /> password : <input
				type="password" name="password"><br /> <input type="submit"
				value="로그인"> <a href="user/join.do">[회원가입]</a>
		</form>
	</c:if>
	<br />
	<a href="ajax/ajaxSample.do">ajax 예제 하러가기</a>
	<br/>
	<a href="fileupload.do">파일 업로드하기</a>
</body>
</html>
