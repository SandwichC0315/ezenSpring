<%@page import="edu.study.vo.UserVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

	List<UserVO> list = (List<UserVO>)request.getAttribute("list");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 목록 페이지</title>
</head>
<body>

<table border="1">
	<thead>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
		</tr>
	</thead>
	
	<tbody>
		<%for (UserVO vo : list){ %>
		<tr>
			<td><%=vo.getId() %></td>
			<td><%=vo.getPassword() %></td>
			<td><%=vo.getName() %></td>
		</tr>
		<%} %>
	</tbody>
</table>

</body>
</html>