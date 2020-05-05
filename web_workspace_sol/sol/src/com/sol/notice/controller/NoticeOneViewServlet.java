package com.sol.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sol.board.model.service.BoardService;
import com.sol.board.model.vo.Board;
import com.sol.comment.model.service.CommentService;
import com.sol.comment.model.vo.Comment;
import com.sol.member.model.service.MemberService;
import com.sol.member.model.vo.Member;

/**
 * Servlet implementation class NoticeOneViewServlet
 */
@WebServlet(name = "NoticeOneView", urlPatterns = { "/noticeOneView.do" })
public class NoticeOneViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeOneViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		Board board = new BoardService().selectOneBoard(boardNo);
		
		board.setText(board.getText().replaceAll("\r\n", "<br>"));
		
		RequestDispatcher view = request.getRequestDispatcher("views/notice/noticeView.jsp");
		
		HttpSession session = request.getSession();
		
		Member member = (Member) session.getAttribute("member");
		
		String createrEmail = member.getEmail();
		String createrName = member.getUserName();
		
		ArrayList<Comment> commentList= new CommentService().selectCommentList(boardNo,createrEmail,createrName);
		
		if(commentList.isEmpty())
			request.setAttribute("commentIsEmpty", true);
		else
			request.setAttribute("commentList", commentList);
		
		
		//System.out.println(board.getHits());
		
		int result = new BoardService().plusBoardViews(boardNo,board.getHits());
		
		if(result>0)
			//System.out.println("조회수 증가완료");
			; 
		
		Member creater = new MemberService().selectOneMember(board.getCreaterNo());
		
		request.setAttribute("creater", creater);

		request.setAttribute("board", board);
		
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
