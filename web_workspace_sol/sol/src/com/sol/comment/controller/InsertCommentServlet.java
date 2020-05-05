package com.sol.comment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.SendResult;

import com.sol.board.model.service.BoardService;
import com.sol.board.model.vo.Board;
import com.sol.comment.model.service.CommentService;
import com.sol.member.model.vo.Member;

/**
 * Servlet implementation class InsertCommentServlet
 */
@WebServlet(name = "InsertComment", urlPatterns = { "/insertComment.do" })
public class InsertCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		String commentText = request.getParameter("commentText");
		
		HttpSession session = request.getSession();
		
		Member member = (Member) session.getAttribute("member");
		
		String createrEmail = member.getEmail();
		
		String createrName = member.getUserName();
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		Board board = new BoardService().selectOneBoard(boardNo);
		
		int result = new CommentService().insertComment(createrEmail,createrName,boardNo,commentText);
		
		System.out.println(request.getParameter("commentNo"));
		
		int commentNo = Integer.parseInt(request.getParameter("commentNo"));
		
		System.out.println(commentNo);
		
		int result2 = new BoardService().changeCommentNo(boardNo,commentNo,1);
		
		if(result2>0)
			//System.out.println("댓글 수 증가 완료");
		
		
		
		if(result>0)
			response.sendRedirect("views/comment/commentSuccess.jsp?boardNo="+boardNo+"&boardType="+board.getTypeNo());
		else
			response.sendRedirect("error.jsp");
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
