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
import com.sol.file.model.vo.FileData;
import com.sol.member.model.vo.Member;

/**
 * Servlet implementation class NoticeModifySubmitServlet
 */
@WebServlet(name = "NoticeModifySubmit", urlPatterns = { "/noticeModifySubmit.do" })
public class NoticeModifySubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeModifySubmitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int fileSizeLimit = 5*1024*1024;
		
		HttpSession session = request.getSession();
		
		Member member = (Member) session.getAttribute("member");
		
		String uploadPath= getServletContext().getRealPath("/")+"uploadFile" + "\\" + member.getMemberNo();
		
		MultipartRequest mrequest = new MultipartRequest(request, uploadPath ,fileSizeLimit,"UTF-8",new DefaultFileRenamePolicy());		
		
		String grade = mrequest.getParameter("grade");
		String name = mrequest.getParameter("name");
		String loginActive;
		int boardNo = Integer.parseInt(mrequest.getParameter("boardNo"));
		
		//System.out.println(boardNo);
		
		Board board = new BoardService().selectOneBoard(boardNo);
		
		if(board.getFileData()!=null) {
		
			File deleteFile = new File(board.getFileData().getFileFullPath());
		
			if(deleteFile.exists() && deleteFile.isFile()) {
				deleteFile.delete();
			}
		}
		

		if(mrequest.getParameter("loginActive")==null)	//체크 되있으면 1이 들어오고 아니면 null이 들어옴
			loginActive = "N";
		else
			loginActive = "Y";
		
		
		if(loginActive.equals("Y")) {
			//loginActive를 모두 N으로 변경시킴
			int result = new BoardService().loginActiveAllN();		
			if(result>0)
				System.out.println("loginActive 모두 N으로 변경 완료");
		}
		
		
		
		String text = mrequest.getParameter("text");
		
		String fileName = mrequest.getFilesystemName("upfile");
		String fileFullPath;
		long fileSize;
		if(fileName==null||fileName=="") {
			fileFullPath = null;
			fileSize=0;
		}
		else {
		
		fileFullPath = uploadPath+"\\"+fileName;
		
		File file = new File(fileFullPath);
		
		fileSize = file.length();
		
		}
		
		FileData fileData = new FileData(fileName, fileFullPath, fileSize);

		Board notice = new Board(0,boardNo,name, text, 0, 0, 0, grade, loginActive, 0, 0, 0, 1, null,fileData);
				
		int result = new BoardService().modifyBoard(notice);
		
		if(result>0) {
			response.sendRedirect("/views/notice/noticeModifySuccess.jsp?boardType="+board.getTypeNo());			
		}
		else {
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
