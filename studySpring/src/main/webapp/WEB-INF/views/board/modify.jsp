<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="edu.study.vo.BoardVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정 페이지</title>
</head>
<body>
	<form action="modify.do" method ="post">
	<input type="hidden" name="bidx" value="${vo.bidx}">
		<table border="1">
			<tr>
				<th align="right">제목</th>
				<td><textarea name="title">${vo.title}</textarea></td>
			</tr>

			<tr>
				<th align="right">조회수</th>
				<td>${vo.hit}</td>
			</tr>

			<tr>
				<th align="right">작성자</th>
				<td>${vo.username}</td>
			</tr>

			<tr>
				<th align="right">등록일</th>
				<td>${vo.wdate}</td>
			</tr>

			<tr>
				<th align="right">내용</th>
				<td><textarea name="content">${vo.content}</textarea></td>
			</tr>
			<button>저장</button>
			<button type="button" onclick="view.do?bidx=${vo.bidx}">취소</button>
		</table>
	</form>
</body>
</html>