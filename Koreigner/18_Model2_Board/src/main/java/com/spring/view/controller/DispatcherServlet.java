package com.spring.view.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;
import com.spring.biz.user.UserVO;
import com.spring.biz.user.impl.UserDAO;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		request.setCharacterEncoding("UTF-8");
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">> *.do 요청에 대한 처리");
		//1. 클라이언트에서 어떤 작업요청이 왔는지 확인
		//   요청path 정보를 확인해서
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println("path : " + path);
		
		//2. 클라이언트의 요청형태에 따른 작업 처리
		if(path.equals("/login.do")) {
			System.out.println("로그인 처리");
			//1. 사용자가 입력한 데이터(정보) 추출
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			//2. DB연동처리(id, password 유무 확인)
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);
			
			UserDAO userDAO = new UserDAO();
			UserVO user = userDAO.getUser(vo);
			
			//3. 화면 네비게이션(화면이동)
			//로그인성공 : 게시글목록 보여주기
			//로그인실패 : 로그인 화면으로 이동
			if (user != null) {//사용자 정보가 존재하는 경우
				System.out.println("로그인 성공!!!");
				response.sendRedirect("getBoardList.do");
			} else {//사용자 정보가 없는 경우
				System.out.println("로그인 실패!!!");
				response.sendRedirect("login.jsp");
			}
		} else if (path.equals("/insertBoard.do")) {
			System.out.println("글등록 처리");
		} else if (path.equals("/logout.do")) {
			System.out.println("로그아웃 처리");
			//1. 브라우저와 연결된 세션 객체를 종료(초기화)
			request.getSession().invalidate();

			//2. 화면 네비게이션(로그인 페이지로 이동)
			response.sendRedirect("login.jsp");
			
		} else if (path.equals("/update.do")) {
			System.out.println("업데이트 처리");
		} else if (path.equals("/delete.do")) {
			System.out.println("글삭제 처리");
		} else if (path.equals("/getBoard.do")) {
			System.out.println(">>> 글 조회 처리");
		} else if (path.equals("/getBoardList.do")) {
			
			System.out.println(">>> 글 전체 목록 조회 처리");
			//1. 게시글 목록 조회(SELECT)
			BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardDAO.getBoardList();
			
			//2. 검색결과를 view에서 사용 할 수 있도록 저장
			request.getSession().setAttribute("boardList", boardList);

			//3. 리스트 페이지 새창 에서 호출 (redirect)
			response.sendRedirect("getBoardList.jsp");
		} 
		
	}
}
