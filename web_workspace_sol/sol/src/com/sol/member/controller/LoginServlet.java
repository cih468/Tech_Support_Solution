package com.sol.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sol.board.model.service.BoardService;
import com.sol.board.model.vo.Board;
import com.sol.member.model.service.MemberService;
import com.sol.member.model.vo.MainData;
import com.sol.member.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "Login", urlPatterns = { "/login.do" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String email = request.getParameter("loginUserEmail");
		String password = request.getParameter("loginPassword");
		
		//System.out.println(email + password);		

		Member m = new MemberService().isActiveId(email,password);
		
		if(m==null)
			response.sendRedirect("/views/loginFail.jsp");
		else {
			HttpSession session = request.getSession();
			//System.out.println(m.getPassword());
			session.setAttribute("member", m);
			
			//로그인 이후 페이지에 띄울 공지사항 찾는 비즈니스 로직
			Board activeNotice = new BoardService().selectActiveBoard();
			MainData mainData = new BoardService().getMainData(m.getMemberNo(),m.getCompany(),m.getEmail());
			
			RequestDispatcher view = request.getRequestDispatcher("views/main.jsp");			

			request.setAttribute("board", activeNotice);
			request.setAttribute("mainData", mainData);
			
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
