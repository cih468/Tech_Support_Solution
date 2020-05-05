package com.sol.sharing.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sol.board.model.service.BoardService;
import com.sol.board.model.vo.Board;
import com.sol.board.model.vo.PageBoardData;

/**
 * Servlet implementation class SharingViewServlet
 */
@WebServlet(name = "SharingView", urlPatterns = { "/sharingView.do" })
public class SharingViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SharingViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage;

		// 페이지 번호를 누르고 들어왔으면 그값, 아니면 1
		if (request.getParameter("currentPage") == null || request.getParameter("currentPage") == "")
			currentPage = 1;
		else
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		int recordPerPage=5;
		int naviPerPage=2;
		
		PageBoardData pageBoardData = new BoardService().boardAllView(2,currentPage,recordPerPage,naviPerPage,null);
		
		ArrayList<Board> sharingAllList = pageBoardData.getBoardList();
		
		for (Board board : sharingAllList) {
			
			board.setText(board.getText().replaceAll("\r\n", "<br>"));
		}
		
		request.setAttribute("pageBoardData", pageBoardData);
		
		RequestDispatcher view = request.getRequestDispatcher("views/sharing/sharing.jsp");
		
		view.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
