package com.sol.notice.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sol.board.model.service.BoardService;
import com.sol.board.model.vo.Board;
import com.sol.file.model.service.FileService;
import com.sol.file.model.vo.FileData;
import com.sol.member.model.vo.Member;

/**
 * Servlet implementation class CreateNoticeServlet
 */
@WebServlet(name = "CreateNotice", urlPatterns = { "/createNotice.do" })
public class CreateNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int fileSizeLimit = 5*1024*1024;
		
		HttpSession session = request.getSession();
		
		Member member = (Member) session.getAttribute("member");
		
		String uploadPath= getServletContext().getRealPath("/")+"uploadFile" + "\\" + member.getMemberNo();
		
		MultipartRequest mrequest = new MultipartRequest(request, uploadPath ,fileSizeLimit,"UTF-8",new DefaultFileRenamePolicy());		
		
		//file 관련 부분
		
		//file 이름
		String fileName = mrequest.getFilesystemName("upfile");
		
		System.out.println("fileName:"+ fileName);
		
		//file 경로
		String fileFullPath = uploadPath + "\\" + fileName;
		
		//fileSize
		
		long fileSize;
		
		//파일 이름이 없으면 파일 업로드 X
		if(fileName==""||fileName==null) {
			fileSize=0;
		}else {
		File file = new File(fileFullPath);
		fileSize = file.length();
		
		}
		
		FileData uploadFileData = new FileData(fileName, fileFullPath, fileSize);		
		
		//notice 관련부분
		
		int memberNo = member.getMemberNo(); 
				
		String grade = mrequest.getParameter("grade");
		String name = mrequest.getParameter("name");
		String loginActive;

		if(mrequest.getParameter("loginActive")==null) //체크가 안되어있으면 N , 되어 있으면 Y 
			loginActive = "N";
		else
			loginActive = "Y";					
		
		String text = mrequest.getParameter("text");
		
		if(loginActive.equals("Y")) {
			//loginActive를 모두 N으로 변경시킴
			int result = new BoardService().loginActiveAllN();		
			if(result>0)
				System.out.println("loginActive 모두 N으로 변경 완료");
		}
		
		//boardNo 0
		Board notice = new Board(0,0,name, text, 0, 0, 0, grade, loginActive, memberNo, 0, 0, 1, null,uploadFileData);
		
		System.out.println("등록 전 : " + text);
				
		int result = new BoardService().insertBoard(notice);
		
		//result +=new FileService().insertFile(notice.getBoardNo());
		
		if(result>0) {
			System.out.println("공지사항 등록 완료");
			response.sendRedirect("/views/notice/noticeCreateSuccess.jsp");			
		}
		else {
			System.out.println("공지사항 등록 실패");
			response.sendRedirect("/error.jsp");
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