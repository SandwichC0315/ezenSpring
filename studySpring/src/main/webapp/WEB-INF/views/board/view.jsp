<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="edu.study.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%
	List<BoardVO> list = (List<BoardVO>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세 페이지</title>
</head>
<body>
	<h2>게시글 상세 페이지</h2>
	가상경로 /board/view.do 요청시 나타나는 페이지
	
	
	<table border="1">
		<tr>
			<th align="right">제목</th>
			<td>${vo.title}</td>
		</tr>
		
		<tr>
			<th align="right">조회수</th>
			<td>${vo.hit}</td>
		</tr>
		
		<tr>
			<th align="right">작성자</th>
			<td>${vo.uidx}</td>
		</tr>
		
		<tr>
			<th align="right">등록일</th>
			<td>${vo.wdate}</td>
		</tr>
		
		<tr>
			<th align="right">내용</th>
			<td>${vo.content}</td>
		</tr>
	</table>
	<button onclick="location.href='list.do'">목록</button>
	<button onclick="location.href='modify.do?bidx=${vo.bidx}'">수정</button> 
	<button onclick="delfrm.submit();">삭제</button>
	<form name="delfrm" action="delete.do" method="post">
		<input type="hidden" name="bidx" value="${vo.bidx}">
	</form>
	
</body>
</html>
<!--
수정 버튼 클릭 시 board/modify.jsp 를 만들어 포워드합니다.
이 때 수정을 누른 게시글에 대한 정보가 수정데이터는 입력양식 안에, 나머지는 일반 셀로 출력되도록 만들어보세요.
-->





