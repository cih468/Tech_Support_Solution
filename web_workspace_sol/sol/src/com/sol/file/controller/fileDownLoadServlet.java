package com.sol.file.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.SendResult;

import com.sol.file.model.service.FileService;
import com.sol.file.model.vo.FileData;

/**
 * Servlet implementation class fileDownLoadServlet
 */
@WebServlet(name = "fileDownLoad", urlPatterns = { "/fileDownLoad.do" })
public class fileDownLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fileDownLoadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		FileData fd = new FileService().downLoadFile(boardNo);
		
		System.out.println(fd.getFileName());
		System.out.println(fd.getFileFullPath());
		
		//파일이 있다면 파일 다운로드 로직 진행
		if(fd!=null) {
			
			File downLoadfile = new File(fd.getFileFullPath());
			
			String encFileName = new String(fd.getFileName().getBytes(),"ISO-8859-1");
			
			//파일 변경을 위한 헤더 변경
			
			response.setContentType("application/octet-stream");
			response.setContentLengthLong(downLoadfile.length());
			response.setHeader("Content-Disposition", "attachment;filename="+encFileName);
			
			//FileStream으로 파일의 내용 읽어오기
			FileInputStream fileIn = new FileInputStream(downLoadfile);
			
			//5. input 스트림으로 연결된 정보를 클라이언트에게 보내기 위한 outStream생성
			
			ServletOutputStream out = response.getOutputStream();
			
			byte[] output= new byte[4096];
			
			while(fileIn.read(output,0,4096)!=-1) {
				out.write(output,0,4096);
			}
			
			fileIn.close();
			out.close();
		
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
