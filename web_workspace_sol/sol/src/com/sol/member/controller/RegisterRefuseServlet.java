package com.sol.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sol.member.model.service.MemberService;
import com.sol.member.model.vo.Member;

/**
 * Servlet implementation class RegisterRefuseServlet
 */
@WebServlet(name = "RegisterRefuse", urlPatterns = { "/registerRefuse.do" })
public class RegisterRefuseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterRefuseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		
		System.out.println(email);
		
		int result = new MemberService().changeActive("R",email);		
		
		if(result>0)
			System.out.println("회원 active 변경 완료");
		
		ArrayList<Member> memberList = new ArrayList<>();
		
		ArrayList<Member> refuseList = new ArrayList<>();
		
		memberList = new MemberService().selectAllMember("W");
		
		refuseList = new MemberService().selectAllMember("R");
		
		ArrayList<ArrayList<Member>> list = new ArrayList<>();
		
		list.add(memberList);
		list.add(refuseList);
		
		response.setContentType("application/json");
		
		response.setCharacterEncoding("UTF-8");
		
		new Gson().toJson(list,response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
