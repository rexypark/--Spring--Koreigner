<%@page import="com.spring.biz.board.BoardVO"%>
<%@page import="com.spring.biz.board.impl.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- 전달받은 파라미터 값 사용 DB조회하고 화면에 표시 --%>
<%
	//1. 전달받은 데이터 추출
	int seq = Integer.parseInt(request.getParameter("seq"));	
	
	
	//2. DB 연동 처리(하나의 글 조회)
	BoardDAO boardDAO = new BoardDAO();
	BoardVO vo = new BoardVO();
	vo.setSeq(seq);
	vo = boardDAO.getBoard(vo);
	
	
	//3. 조회 데이터 화면 표시(HTML 작성)
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#container {
		width: 700px;
		margin: 0 auto;
	}
	h1, h3, p { text-align: center; }
	table { border-collapse: collapse; }
	table, th, td {
		border: 1px solid black;
		margin: 0 auto;
	}
	th { background-color: orange; }
	.center { text-align: center; }
	.border-none, .border-none td { border: none; }
</style>
</head>
<body>
	<div>
		<h1>글 상세</h1>
		<p><a href="logout_proc.jsp">Logout</a></p>
		<hr>
		<form action="updateBoard_proc.jsp" method="get" >
		<!-- <input type="text" name="regdate" value="<%=vo.getSeq() %>"> -->
			<table>
			<tr>
				<th>번호</th>
				<td><input type="text" name="seq" value="<%=vo.getSeq() %>"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="<%=vo.getTitle() %>"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" value="<%=vo.getWriter() %>"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><input type="text" name="content" value="<%=vo.getContent() %>"></td>
			</tr>
			<tr>
				<th>날짜</th>
				<td><input type="text" name="regdate" value="<%=vo.getRegdate() %>"></td>
			</tr>
			<tr>
				<th>조회수</th>
				<td><input type="text" name="cnt" value="<%=vo.getCnt() %>"></td>
			</tr>
			<tr>
			<td colspan="2">
				<input type="submit" value="글수정">
			</td>
			</tr>
			</table>		
		</form>
		<p>
			<a href="insertBoard.jsp">글등록</a>
			<a href="deleteBoard.jsp?seq=<%=vo.getSeq()%>">글삭제</a>
			<a href="getBoardList.jsp">글목록</a>
			
		</p>
	</div>
</body>
</html>