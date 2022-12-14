<%@page import="edu.study.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- jstl 사용하기 위해 필요한 태그 -->
<%
	List<BoardVO> list = (List<BoardVO>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>

</head>
<body>
	<h2>게시글 목록 페이지</h2>
	가상경로 /board/list.do 를 요청했을 때 나타나는 페이지입니다. 게시글 목록 페이지입니다.
	<br />
	<c:if test="${login != null}">
	${login.name} 님 환영합니다.
	</c:if>
	<br/>
	<h2><%=request.getAttribute("data1")%></h2>

	<table border="1">
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>등록일</th>
			</tr>
		</thead>
		
		<tbody>
			<!-- 여기에 출력 -->
			<%for(BoardVO vo : list){%>
			<tr>
				<td><%=vo.getBidx() %></td>
				<td><a href="view.do?bidx=<%=vo.getBidx()%>"><%=vo.getTitle() %></a></td>
				<td><%=vo.getWdate() %></td>			
			</tr>
			<%} %>
		</tbody>
	</table>
	
	<c:if test="${login != null}">
		<button onclick="location.href='insert.do';">등록</button>
	</c:if>
</body>
</html>