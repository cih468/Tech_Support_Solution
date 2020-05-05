package com.sol.technicalSupport.controller;

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
import com.sol.board.model.vo.PageBoardData;
import com.sol.member.model.vo.Member;

/**
 * Servlet implementation class TechnicalSupportViewServlet
 */
@WebServlet(name = "TechnicalSupportView", urlPatterns = { "/technicalSupportView.do" })
public class TechnicalSupportViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TechnicalSupportViewServlet() {
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
		int naviPerPage=3;
		
		HttpSession session = request.getSession();
		
		Member member = (Member) session.getAttribute("member");
		
		PageBoardData pageBoardData;
		
		if(member.getTypeNo()==1) {
		
			String company = member.getCompany();
		
			pageBoardData = new BoardService().techBoardAllView(3,currentPage,recordPerPage,naviPerPage,null,company);
		}
		
		else
			pageBoardData = new BoardService().boardAllView(3, currentPage, recordPerPage, naviPerPage, null); 
		
		ArrayList<Board> noticeAllList = pageBoardData.getBoardList();
		
		for (Board board : noticeAllList) {
			
			board.setText(board.getText().replaceAll("\r\n", "<br>"));
		}
		
		request.setAttribute("pageBoardData", pageBoardData);
		
		RequestDispatcher view = request.getRequestDispatcher("views/technicalSupport/technicalSupport.jsp");
		
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
