package com.sol.technicalSupport.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sol.board.model.service.BoardService;

/**
 * Servlet implementation class ChangeStateServlet
 */
@WebServlet(name = "ChangeState", urlPatterns = { "/changeState.do" })
public class ChangeStateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeStateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		int stateNo = Integer.parseInt(request.getParameter("stateNo"));
		
		int result = new BoardService().changeState(boardNo,stateNo);
		
		if(result>0)
			response.sendRedirect("/technicalSupportOneView.do?boardNo="+boardNo);
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
