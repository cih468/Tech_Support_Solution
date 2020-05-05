package com.sol.notice.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sol.board.model.service.BoardService;
import com.sol.board.model.vo.Board;

/**
 * Servlet implementation class NoticeDeleteServlet
 */
@WebServlet(name = "NoticeDelete", urlPatterns = { "/noticeDelete.do" })
public class NoticeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		Board board = new BoardService().selectOneBoard(boardNo);
		
		int result = new BoardService().deleteBoard(boardNo);
		
		if(result>0) {
			
			if(board.getFileData()!=null) {
				
				String fileFullPath = board.getFileData().getFileFullPath();
				
				File deleteFile = new File(board.getFileData().getFileFullPath());
			
				if(deleteFile.exists() && deleteFile.isFile()) {
					deleteFile.delete();
				}
			}
			
			response.sendRedirect("/views/notice/noticeDeleteSuccess.jsp?boardType="+board.getTypeNo());
		}
		else
			response.sendRedirect("/error.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
