<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글등록</title>
</head>
<body>
	<div>
		<h1>글등록</h1>
		<p><a href="Logout_proc.jsp">Log_Out</a></p>
		<hr>
		<form action="insertBoard_proc.jsp" method="post">
		  <table>
		  	<tr>
		  		<th>제목</th>
		  		<td>
		  			<input type="text" name="title" size="30">
		  		<td>
		  	</tr>
		  	<tr>
		  		<th>writer</th>
		  		<td>
		  			<input type="text" name="writer" size="30">
		  		<td>
		  	</tr>
		  	<tr>
		  		<th>내용</th>
		  		<td>
		  			<textarea type="text" name="content" rows="10" cols="40"></textarea>
		  		<td>
		  	</tr>
		  	<tr>
		  		<td colspan="2">
		  			<input type="submit" value="새글등록">
		  		<td>
		  	</tr>
		  </table>
		</form>
		<p><a href="getBoardList.jsp">글목록 가기</a></p>
	</div>
</body>
</html>