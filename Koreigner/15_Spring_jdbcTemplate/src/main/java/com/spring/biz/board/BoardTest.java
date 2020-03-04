package com.spring.biz.board;

import com.spring.biz.board.impl.BoardDAO;

public class BoardTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoardVO vo = new BoardVO();
		vo.setTitle("테스트글2");
		vo.setWriter("테스터2");
		vo.setContent("테스트 글 내용2");
		
		BoardDAO dao = new BoardDAO();
		dao.insertBoard(vo);
	}

}
