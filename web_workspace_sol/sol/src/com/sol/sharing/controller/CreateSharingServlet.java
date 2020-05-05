package com.sol.sharing.controller;

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
import com.sol.file.model.vo.FileData;
import com.sol.member.model.vo.Member;

/**
 * Servlet implementation class CreateSharingServlet
 */
@WebServlet(name = "CreateSharing", urlPatterns = { "/createSharing.do" })
public class CreateSharingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateSharingServlet() {
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
		String fileName = mrequest.getParameter("fileName");
		
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
				
		String name = mrequest.getParameter("name");
		String loginActive;					
		
		String text = mrequest.getParameter("text");
		
		//boardNo 0
		Board sharing = new Board(0,0,name, text, 0, 0, 0, null, null, memberNo, 0, 0, 2, null,uploadFileData);
		
		System.out.println("등록 전 : " + text);
				
		int result = new BoardService().insertBoard(sharing);
		
		//result +=new FileService().insertFile(notice.getBoardNo());
		
		if(result>0) {
			System.out.println("기술공유 등록 완료");
			response.sendRedirect("/views/sharing/sharingCreateSuccess.jsp");			
		}
		else {
			System.out.println("기술공유 등록 실패");
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
