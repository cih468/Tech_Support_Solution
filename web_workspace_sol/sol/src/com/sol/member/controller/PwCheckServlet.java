package com.sol.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sol.member.model.service.MemberService;
import com.sol.member.model.vo.Member;
import com.sol.member.model.vo.SharingActivity;
import com.sol.member.model.vo.TechnicalSupportActivity;

/**
 * Servlet implementation class PwCheckServlet
 */
@WebServlet(name = "PwCheck", urlPatterns = { "/pwCheck.do" })
public class PwCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PwCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		Member m = (Member)session.getAttribute("member");
		
		Member selectMember = new MemberService().selectOneMember(m.getEmail());
		
		//기술공유 게시판 활동내역 값들을 뽑아오는 로직
		SharingActivity memberSharingActivity = new MemberService().sharingActive(selectMember);
		
		TechnicalSupportActivity memberTechnicalActivity = new MemberService().technicalActive(selectMember);
		
		String pwCheck = request.getParameter("loginPassword");
		
		if(selectMember.getPassword().equals(pwCheck)) {
			
			request.setAttribute("memberSharingActivity", memberSharingActivity);
			
			request.setAttribute("memberTechnicalActivity", memberTechnicalActivity);
			
			RequestDispatcher view = request.getRequestDispatcher("views/myPage/myPage.jsp");
			
			view.forward(request, response);	
		}
		else {
			response.sendRedirect("views/myPage/pwError.jsp");
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
