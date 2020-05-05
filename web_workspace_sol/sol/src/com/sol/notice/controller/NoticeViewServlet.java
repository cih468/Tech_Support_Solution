package com.sol.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.ha.context.ReplicatedContext;

import com.sol.board.model.service.BoardService;
import com.sol.board.model.vo.Board;
import com.sol.board.model.vo.PageBoardData;

/**
 * Servlet implementation class NoticeViewServlet
 */
@WebServlet(name = "NoticeView", urlPatterns = { "/noticeView.do" })
public class NoticeViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NoticeViewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int currentPage;

		// 페이지 번호를 누르고 들어왔으면 그값, 아니면 1
		if (request.getParameter("currentPage") == null || request.getParameter("currentPage") == "")
			currentPage = 1;
		else
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		int recordPerPage=5;
		int naviPerPage=3;
		
		PageBoardData pageBoardData = new BoardService().boardAllView(1,currentPage,recordPerPage,naviPerPage,null);
		
		PageBoardData pageBoardDataImportance = new BoardService().boardAllView(1,1,recordPerPage,naviPerPage,"중요");
		
		PageBoardData pageBoardDataNormal = new BoardService().boardAllView(1,1,recordPerPage,naviPerPage,"일반");
		
		PageBoardData pageBoardDataEmergency = new BoardService().boardAllView(1,1,recordPerPage,naviPerPage,"긴급");
		
		ArrayList<Board> noticeAllList = pageBoardData.getBoardList();
		
		for (Board board : noticeAllList) {
			
			board.setText(board.getText().replaceAll("\r\n", "<br>"));
		}
		
		ArrayList<Board> noticeImportanceList = pageBoardDataImportance.getBoardList();

		for (Board board : noticeImportanceList) {
			
			board.setText(board.getText().replaceAll("\r\n", "<br>"));
			
		}
		
		ArrayList<Board> noticeNormalList = pageBoardDataNormal.getBoardList();

		
		for (Board board : noticeNormalList) {
			
			board.setText(board.getText().replaceAll("\r\n", "<br>"));
		}
		
		ArrayList<Board> noticeEmergencyList = pageBoardDataEmergency.getBoardList();

		for (Board board : noticeEmergencyList) {
			
			board.setText(board.getText().replaceAll("\r\n", "<br>"));
		}
		
		request.setAttribute("pageBoardData", pageBoardData);
		
		request.setAttribute("pageBoardDataImportance", pageBoardDataImportance);

		request.setAttribute("pageBoardDataNormal", pageBoardDataNormal);
		
		request.setAttribute("pageBoardDataEmergency", pageBoardDataEmergency);
		
		RequestDispatcher view = request.getRequestDispatcher("views/notice/notice.jsp");
		
		view.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
