package com.sol.board.model.dao;

import java.awt.image.ImagingOpException;
import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sol.board.model.vo.Board;
import com.sol.comment.model.vo.Comment;
import com.sol.common.JDBCTemplate;
import com.sol.file.model.vo.FileData;

public class BoardDao {

	public int insertBoard(Connection conn, Board board) {
		// TODO Auto-generated method stub

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = "insert into board values(boardNo.nextval,?,0,0,0,?,?,?,0,?,?,sysdate,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getName());
			pstmt.setString(2, board.getGrade());
			pstmt.setString(3, board.getLoginActive());
			pstmt.setInt(4, board.getCreaterNo());
			pstmt.setInt(5, board.getStateNo());
			pstmt.setInt(6, board.getTypeNo());
			pstmt.setString(7, board.getText());
			pstmt.setString(8, board.getFileData().getFileName());
			pstmt.setLong(9, board.getFileData().getFileSize());
			pstmt.setString(10, board.getFileData().getFileFullPath());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;

	}

	public Board selectOneBoard(Connection conn, int boardNo) {
		// TODO Auto-generated method stub

		String sql = "select * from board where board_no=?";

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board board = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				board = new Board();
				board.setBoardNo(rset.getInt("board_no"));
				board.setName(rset.getString("board_name"));
				board.setHits(rset.getInt("board_hits"));
				board.setCommentNo(rset.getInt("board_comment_no"));
				board.setSelectedComment(rset.getInt("board_selected_comment"));
				board.setGrade(rset.getString("board_grade"));
				board.setCreaterNo(rset.getInt("board_creater_no"));
				board.setTypeNo(rset.getInt("board_type_no"));
				board.setCreateDate(rset.getString("board_create_date"));
				board.setText(rset.getString("board_text"));
				board.setStateNo(rset.getInt("board_state_no"));
				board.setLoginActive(rset.getString("board_login_active"));
				board.setManagerNo(rset.getInt("board_manager_no"));
				
				if(rset.getString("file_name")!=null) {
				
				FileData fileData = new FileData();
				fileData.setFileFullPath(rset.getString("file_full_path"));
				fileData.setFileName(rset.getString("file_name"));
				fileData.setFileSize(rset.getLong("file_size"));
				
				board.setFileData(fileData);
				
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return board;
	}

	public int modifyBoard(Connection conn, Board board) {
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = "update board set board_grade=?,board_login_active=?,board_text=?,file_name=?,file_size=?,file_full_path=? where board_no=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getGrade());
			pstmt.setString(2, board.getLoginActive());
			pstmt.setString(3, board.getText());
		
			pstmt.setString(4, board.getFileData().getFileName());
			pstmt.setLong(5, board.getFileData().getFileSize());
			pstmt.setString(6, board.getFileData().getFileFullPath());
			pstmt.setInt(7, board.getBoardNo());
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;
	}

	public int plusBoardViews(Connection conn, int boardNo, int boardHits) {
		// TODO Auto-generated method stub

		PreparedStatement pstmt = null;

		String sql = "update board set board_hits=? where board_no = ?";

		int result = 0;

		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, boardHits + 1);

			pstmt.setInt(2, boardNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;
	}

	public int changeCommentNo(Connection conn, int boardNo, int commentNo, int variation) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;

		String sql = "update board set board_comment_no=? where board_no = ?";

		int result = 0;

		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, commentNo + variation);

			pstmt.setInt(2, boardNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;
	}

	public ArrayList<Board> boardAllView(Connection conn, int boardTypeNo, int currentPage, int recordPerPage,String grade) {
		// TODO Auto-generated method stub
		
		String sql;
		if(grade==null)
			sql = "select * from " + "(select board.*,row_number() over (order by board_create_date desc) as num "
				+ "from board where board_type_no=?)" + " where num between ? and ?";
		else {
			sql = "select * from " + "(select board.*,row_number() over (order by board_create_date desc) as num "
					+ "from board where board_type_no=? and board_grade='"+grade+"')" + " where num between ? and ?";
		}
		
		PreparedStatement pstmt = null;

		ResultSet rset = null;

		ArrayList<Board> boardAllList = new ArrayList<>();

		int startNum = (currentPage - 1) * recordPerPage + 1;

		int endNum = currentPage * recordPerPage;

		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, boardTypeNo);

			pstmt.setInt(2, startNum);

			pstmt.setInt(3, endNum);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Board board = new Board();
				board.setNum(rset.getInt("num"));
				board.setBoardNo(rset.getInt("board_no"));
				board.setName(rset.getString("board_name"));
				board.setHits(rset.getInt("board_hits"));
				board.setCommentNo(rset.getInt("board_comment_no"));
				board.setSelectedComment(rset.getInt("board_selected_comment"));
				board.setGrade(rset.getString("board_grade"));
				board.setLoginActive(rset.getString("board_login_active"));
				board.setCreaterNo(rset.getInt("board_creater_no"));
				board.setManagerNo(rset.getInt("board_manager_no"));
				board.setStateNo(rset.getInt("board_state_no"));
				board.setTypeNo(rset.getInt("board_type_no"));
				board.setCreateDate(rset.getString("board_create_date"));
				board.setText(rset.getString("board_text"));
				boardAllList.add(board);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		//System.out.println(boardAllList.size());

		return boardAllList;

	}
	
	
	public ArrayList<Board> techBoardAllView(Connection conn, int boardTypeNo, int currentPage, int recordPerPage,String grade,String company) {
		// TODO Auto-generated method stub
		
		
		String sql = "select * from " +
				  "(select m.member_company,b.*,row_number() over (order by b.board_create_date desc) as num from board b, member m "
				  + "where b.board_type_no=? and b.board_creater_no=m.member_no and m.member_company=?)"+
				  " where num between ? and ?";
		
		PreparedStatement pstmt = null;

		ResultSet rset = null;

		ArrayList<Board> boardAllList = new ArrayList<>();

		int startNum = (currentPage - 1) * recordPerPage + 1;

		int endNum = currentPage * recordPerPage;

		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, boardTypeNo);
			
			pstmt.setString(2, company);

			pstmt.setInt(3, startNum);

			pstmt.setInt(4, endNum);
	

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Board board = new Board();
				board.setNum(rset.getInt("num"));
				board.setBoardNo(rset.getInt("board_no"));
				board.setName(rset.getString("board_name"));
				board.setHits(rset.getInt("board_hits"));
				board.setCommentNo(rset.getInt("board_comment_no"));
				board.setSelectedComment(rset.getInt("board_selected_comment"));
				board.setGrade(rset.getString("board_grade"));
				board.setLoginActive(rset.getString("board_login_active"));
				board.setCreaterNo(rset.getInt("board_creater_no"));
				board.setManagerNo(rset.getInt("board_manager_no"));
				board.setStateNo(rset.getInt("board_state_no"));
				board.setTypeNo(rset.getInt("board_type_no"));
				board.setCreateDate(rset.getString("board_create_date"));
				board.setText(rset.getString("board_text"));
				boardAllList.add(board);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		//System.out.println(boardAllList.size());

		return boardAllList;

	}

	public String makePageNavi(Connection conn, int boardTypeNo, int currentPage, int recordPerPage, int naviPerPage) {
		// TODO Auto-generated method stub

		String sql = "select count(*) as total from board where board_type_no=?";

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		StringBuilder sb = new StringBuilder();

		int totalCount = 0;

		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, boardTypeNo);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				totalCount = rset.getInt("total");
			}

			int totalNaviCount = 0;

			if (totalCount % recordPerPage == 0)
				totalNaviCount = totalCount / recordPerPage;
			else
				totalNaviCount = totalCount / recordPerPage + 1;

			int start = 0;
			int end = 0;
			
		
			start = ((currentPage-1) / naviPerPage)*naviPerPage + 1;
		

			end = start + naviPerPage - 1;

			int prev = 0;
			int next = 0;

			if (start - 1 > 0)
				prev = start - 1;

			if (end > totalNaviCount)
				end = totalNaviCount;
			
			boolean needPrev=true;
			boolean needNext=true;
			
			if (start == 1)
				needPrev = false;
			if (end == totalNaviCount) {
				needNext = false;
			}
			
			next=end+1;
			
			//System.out.println("start :" + start);
			
			//System.out.println("end :" + end);
			
			//System.out.println("totalNavi :" + totalNaviCount);
			
			//System.out.println("totalCnt :" + totalCount);
			
			String boardViewServlet=null;
			
			if(boardTypeNo==1)
				boardViewServlet="noticeView.do";
			
			if(boardTypeNo==2)
				boardViewServlet="sharingView.do";
			
			if(boardTypeNo==3)
				boardViewServlet="technicalSupportView.do";
			
			
			

			if(needPrev)
				sb.append("<li class='page-item'><a class='page-link' href='/"+boardViewServlet+"?currentPage="+prev+"'>prev</a></li>");
			else
				sb.append("<li class='page-item disabled'><a class='page-link' href='/"+boardViewServlet+"?currentPage=" + prev + "'>prev</a></li>");

			for (int i = start; i <= end; i++) {
				if(i==currentPage)
					sb.append("<li class='page-item'><a style='background-color:#EAEAEA' class='page-link' href='/"+boardViewServlet+"?currentPage="+i+"'>"+i+"</button></li>");
				else
					sb.append("<li class='page-item'><a class='page-link' href='/"+boardViewServlet+"?currentPage="+i+"'>"+i+"</a></li>");
			}

			if(needNext)
				sb.append("<li class='page-item'><a class='page-link' href='/"+boardViewServlet+"?currentPage="+next+"'>next</a></li>");
			else
				sb.append("<li class='page-item disabled'><a class='page-link' href='/"+boardViewServlet+"?currentPage=" + next + "'>next</a></li>");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return sb.toString();
	}
	
	
	
	public String makeTechPageNavi(Connection conn, int boardTypeNo, int currentPage, int recordPerPage, int naviPerPage,String company) {
		// TODO Auto-generated method stub

		String sql = "select count(*) as total from board b,member m where board_type_no=? and b.board_creater_no=m.member_no and m.member_company=?";

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		StringBuilder sb = new StringBuilder();

		int totalCount = 0;

		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, boardTypeNo);
			
			pstmt.setString(2, company);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				totalCount = rset.getInt("total");
			}

			int totalNaviCount = 0;

			if (totalCount % recordPerPage == 0)
				totalNaviCount = totalCount / recordPerPage;
			else
				totalNaviCount = totalCount / recordPerPage + 1;

			int start = 0;
			int end = 0;
			
		
			start = ((currentPage-1) / naviPerPage)*naviPerPage + 1;
		

			end = start + naviPerPage - 1;

			int prev = 0;
			int next = 0;

			if (start - 1 > 0)
				prev = start - 1;

			if (end > totalNaviCount)
				end = totalNaviCount;
			
			boolean needPrev=true;
			boolean needNext=true;
			
			if (start == 1)
				needPrev = false;
			if (end == totalNaviCount) {
				needNext = false;
			}
			
			next=end+1;
			
			//System.out.println("start :" + start);
			
			//System.out.println("end :" + end);
			
			//System.out.println("totalNavi :" + totalNaviCount);
			
			//System.out.println("totalCnt :" + totalCount);
			
			String boardViewServlet=null;
			
			if(boardTypeNo==1)
				boardViewServlet="noticeView.do";
			
			if(boardTypeNo==2)
				boardViewServlet="sharingView.do";
			
			if(boardTypeNo==3)
				boardViewServlet="technicalSupportView.do";
			
			
			

			if(needPrev)
				sb.append("<li class='page-item'><a class='page-link' href='/"+boardViewServlet+"?currentPage="+prev+"'>prev</a></li>");
			else
				sb.append("<li class='page-item disabled'><a class='page-link' href='/"+boardViewServlet+"?currentPage=" + prev + "'>prev</a></li>");

			for (int i = start; i <= end; i++) {
				if(i==currentPage)
					sb.append("<li class='page-item'><a style='background-color:#EAEAEA' class='page-link' href='/"+boardViewServlet+"?currentPage="+i+"'>"+i+"</button></li>");
				else
					sb.append("<li class='page-item'><a class='page-link' href='/"+boardViewServlet+"?currentPage="+i+"'>"+i+"</a></li>");
			}

			if(needNext)
				sb.append("<li class='page-item'><a class='page-link' href='/"+boardViewServlet+"?currentPage="+next+"'>next</a></li>");
			else
				sb.append("<li class='page-item disabled'><a class='page-link' href='/"+boardViewServlet+"?currentPage=" + next + "'>next</a></li>");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return sb.toString();
	}

	public int deleteBoard(Connection conn, int boardNo) {
		// TODO Auto-generated method stub
		
		int result=0;
		
		PreparedStatement pstmt = null;
		
		String sql = "delete from board where board_no = ?";
		
		try {
			
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public Comment selectOneComment(Connection conn, int commentNo) {
		// TODO Auto-generated method stub
		
		PreparedStatement pstmt = null;
		
		String sql = "select * from comment_table where comment_no = ?";
		
		ResultSet rset = null;
		
		Comment selectComment = null;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, commentNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
			
				selectComment= new Comment();
				
				selectComment.setCommentNo(rset.getInt("comment_no"));
				
				selectComment.setCommentText(rset.getString("comment_text"));
				
				selectComment.setBoard_no(rset.getInt("board_no"));
				
				selectComment.setCreateDate(rset.getString("create_date"));
				
				selectComment.setCreaterEmail(rset.getString("comment_creater_email"));
				
				selectComment.setCreaterName(rset.getString("comment_creater_name"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		
		
		return selectComment;
	}

	public int selectComment(Connection conn, int boardNo, int commentNo) {
		// TODO Auto-generated method stub
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String sql = "update board set board_selected_comment=? where board_no=?";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, commentNo);
			
			pstmt.setInt(2, boardNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		
		
		
		return result;
	}

	public Board selectActiveBoard(Connection conn) {
		// TODO Auto-generated method stub
		
		Statement stmt = null;
		
		String sql = "select * from Board where board_login_active='Y'";
		
		ResultSet rset = null;
		
		Board board= null;
		
		try {
			
			stmt = conn.createStatement();

			rset = stmt.executeQuery(sql);

			if (rset.next()) {
				board = new Board();
				board.setBoardNo(rset.getInt("board_no"));
				board.setName(rset.getString("board_name"));
				board.setHits(rset.getInt("board_hits"));
				board.setCommentNo(rset.getInt("board_comment_no"));
				board.setSelectedComment(rset.getInt("board_selected_comment"));
				board.setGrade(rset.getString("board_grade"));
				board.setCreaterNo(rset.getInt("board_creater_no"));
				board.setTypeNo(rset.getInt("board_type_no"));
				board.setCreateDate(rset.getString("board_create_date"));
				board.setText(rset.getString("board_text"));
				board.setLoginActive(rset.getString("board_login_active"));
				
				if(rset.getString("file_name")!=null) {
				
				FileData fileData = new FileData();
				fileData.setFileFullPath(rset.getString("file_full_path"));
				fileData.setFileName(rset.getString("file_name"));
				fileData.setFileSize(rset.getLong("file_size"));
				
				board.setFileData(fileData);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		return board;
	}

	public int loginActiveAllN(Connection conn) {
		
		int result=0;
		
		Statement stmt = null;
		
		String sql = "update board set board_login_active='N' where board_type_no=1";
		
		try {
			stmt = conn.createStatement();
			
			result = stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(stmt);
		}
		
		return result;
	}

	public int manage(Connection conn, int memberNo, int boardNo) {
		// TODO Auto-generated method stub
		
		PreparedStatement pstmt = null;
		
		String sql = "update board set board_manager_no=? where board_no=?";
		
		int result = 0;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			
			pstmt.setInt(2, boardNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int changeState(Connection conn, int stateNo, int boardNo) {
		// TODO Auto-generated method stub
		
		PreparedStatement pstmt = null;
		
		String sql = "update board set board_state_no=? where board_no=?";
		
		int result=0;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,stateNo);
			
			pstmt.setInt(2, boardNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Board> searchBoard(Connection conn, int boardTypeNo, int currentPage, int recordPerPage,
			int searchSelect, String searchText, int searchState) {
		
		String searchType=null;

		if(searchSelect==1)	//제목검색
		{
			searchType="board_name";
		}
		else if(searchSelect==2)	//본문검색
		{
			searchType="board_text";
		}else {
			
			if(boardTypeNo==1)
				searchType="board_grade";
			
			else if(boardTypeNo==3)
				searchType="board_state_no";			
		}
		
		String sql = "select * from " + "(select board.*,row_number() over (order by board_create_date desc) as num "
				+ "from board where board_type_no=? and "+ searchType + " like ?) where num between ? and ?";

		
		ArrayList<Board> boardSearchList = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		int startNum = (currentPage - 1) * recordPerPage + 1;

		int endNum = currentPage * recordPerPage;

		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, boardTypeNo);
			
			pstmt.setString(2, "%"+searchText+"%");

			pstmt.setInt(3, startNum);

			pstmt.setInt(4, endNum);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Board board = new Board();
				board.setNum(rset.getInt("num"));
				board.setBoardNo(rset.getInt("board_no"));
				board.setName(rset.getString("board_name"));
				board.setHits(rset.getInt("board_hits"));
				board.setCommentNo(rset.getInt("board_comment_no"));
				board.setSelectedComment(rset.getInt("board_selected_comment"));
				board.setGrade(rset.getString("board_grade"));
				board.setLoginActive(rset.getString("board_login_active"));
				board.setCreaterNo(rset.getInt("board_creater_no"));
				board.setManagerNo(rset.getInt("board_manager_no"));
				board.setStateNo(rset.getInt("board_state_no"));
				board.setTypeNo(rset.getInt("board_type_no"));
				board.setCreateDate(rset.getString("board_create_date"));
				board.setText(rset.getString("board_text"));
				boardSearchList.add(board);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return boardSearchList;
		
		
	}

	public String makeSearchPageNavi(Connection conn, int boardTypeNo, int currentPage, int recordPerPage,
			int naviPerPage, int searchSelect, String searchText, int searchState) {
		
		String searchType=null;
		
		if(searchSelect==1)	//제목검색
		{
			searchType="board_name";
		}
		else if(searchSelect==2)	//본문검색
		{
			searchType="board_text";
		}else {
			
			if(boardTypeNo==1)
				searchType="board_grade";
			
			else if(boardTypeNo==3)
				searchType="board_state_no";			
		}
						
		String sql = "select count(*) as total from board where board_type_no=? and " +searchType+" like ?";

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		StringBuilder sb = new StringBuilder();

		int totalCount = 0;
		
		System.out.println("searchText : " + searchText );
		System.out.println("searchType : " + searchType );
		System.out.println("searchSelect : " + searchSelect );



		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, boardTypeNo);
			
			pstmt.setString(2, "%"+searchText+"%");

			rset = pstmt.executeQuery();

			if (rset.next()) {
				totalCount = rset.getInt("total");
			}

			System.out.println("totalCount:" + totalCount);
			
			int totalNaviCount = 0;

			if (totalCount % recordPerPage == 0)
				totalNaviCount = totalCount / recordPerPage;
			else
				totalNaviCount = totalCount / recordPerPage + 1;

			int start = 0;
			int end = 0;
			
		
			start = ((currentPage-1) / naviPerPage)*naviPerPage + 1;
		

			end = start + naviPerPage - 1;

			int prev = 0;
			int next = 0;

			if (start - 1 > 0)
				prev = start - 1;

			if (end > totalNaviCount)
				end = totalNaviCount;
			
			boolean needPrev=true;
			boolean needNext=true;
			
			if (start == 1)
				needPrev = false;
			if (end == totalNaviCount) {
				needNext = false;
			}
			
			next=end+1;
			
			//System.out.println("start :" + start);
			
			//System.out.println("end :" + end);
			
			//System.out.println("totalNavi :" + totalNaviCount);
			
			//System.out.println("totalCnt :" + totalCount);
			
			String boardViewServlet="search.do";
			
			if(needPrev)
				sb.append("<li class='page-item'><a class='page-link' href='/"+boardViewServlet+"?currentPage="+prev+""
						+ "&boardTypeNo="+boardTypeNo+"&searchText="+searchText+"&searchSelect="+searchSelect+"&searchState="+searchState+"'"
						+ ">prev</a></li>");
			else
				sb.append("<li class='page-item disabled'><a class='page-link' href='/"+boardViewServlet+"?currentPage=" + prev + "'>prev</a></li>");

			for (int i = start; i <= end; i++) {
				if(i==currentPage)
					sb.append("<li class='page-item disabled'><a style='background-color:#EAEAEA' class='page-link' href='/"+boardViewServlet+"?currentPage="+i+"'>"+i+"</button></li>");
				else
					sb.append("<li class='page-item'><a class='page-link' href='/"+boardViewServlet+"?currentPage="+i+""
							+ "&boardTypeNo="+boardTypeNo+"&searchText="+searchText+"&searchSelect="+searchSelect+"&searchState="+searchState+"'"
							+ ">"+i+"</a></li>");
			}

			if(needNext)
				sb.append("<li class='page-item'><a class='page-link' href='/"+boardViewServlet+"?currentPage="+next+""
						+ "&boardTypeNo="+boardTypeNo+"&searchText="+searchText+"&searchSelect="+searchSelect+"&searchState="+searchState+"'"
						+ ">next</a></li>");
			else
				sb.append("<li class='page-item disabled'><a class='page-link' href='/"+boardViewServlet+"?currentPage=" + next + "'>next</a></li>");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return sb.toString();
	}

	public ArrayList<Board> techBoardSearch(Connection conn, int boardTypeNo, int currentPage, int recordPerPage,
			int searchSelect, String searchText, int searchState, String company) {
		String searchType=null;

		if(searchSelect==1)	//제목검색
		{
			searchType="board_name";
		}
		else if(searchSelect==2)	//본문검색
		{
			searchType="board_text";
		}else {
			
			if(boardTypeNo==1)
				searchType="board_grade";
			
			else if(boardTypeNo==3)
				searchType="board_state_no";			
		}
		
		String sql = "select * from " +
		  "(select m.member_company,b.*,row_number() over (order by b.board_create_date desc) as num from board b, member m "
		  + "where b.board_type_no=? and b."+ searchType + " like ? and b.board_creater_no=m.member_no and m.member_company=?)"+
		  " where num between ? and ?";

		ArrayList<Board> boardSearchList = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		int startNum = (currentPage - 1) * recordPerPage + 1;

		int endNum = currentPage * recordPerPage;

		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, boardTypeNo);
			
			pstmt.setString(2, "%"+searchText+"%");

			pstmt.setString(3, company);
			
			pstmt.setInt(4, startNum);

			pstmt.setInt(5, endNum);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Board board = new Board();
				board.setNum(rset.getInt("num"));
				board.setBoardNo(rset.getInt("board_no"));
				board.setName(rset.getString("board_name"));
				board.setHits(rset.getInt("board_hits"));
				board.setCommentNo(rset.getInt("board_comment_no"));
				board.setSelectedComment(rset.getInt("board_selected_comment"));
				board.setGrade(rset.getString("board_grade"));
				board.setLoginActive(rset.getString("board_login_active"));
				board.setCreaterNo(rset.getInt("board_creater_no"));
				board.setManagerNo(rset.getInt("board_manager_no"));
				board.setStateNo(rset.getInt("board_state_no"));
				board.setTypeNo(rset.getInt("board_type_no"));
				board.setCreateDate(rset.getString("board_create_date"));
				board.setText(rset.getString("board_text"));
				boardSearchList.add(board);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return boardSearchList;
	}

	public String makeTechSearchPageNavi(Connection conn, int boardTypeNo, int currentPage, int recordPerPage,
			int naviPerPage, int searchSelect, String searchText, int searchState, String company) {

		String searchType=null;
		
		if(searchSelect==1)	//제목검색
		{
			searchType="board_name";
		}
		else if(searchSelect==2)	//본문검색
		{
			searchType="board_text";
		}else {
			
			if(boardTypeNo==1)
				searchType="board_grade";
			
			else if(boardTypeNo==3)
				searchType="board_state_no";			
		}
		
		String sql = "select count(*) as total from board b,member m where b.board_type_no=? and " + searchType + " like ? and b.board_creater_no=m.member_no and m.member_company=?";

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		StringBuilder sb = new StringBuilder();

		int totalCount = 0;

		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, boardTypeNo);
			
			pstmt.setString(2, "%"+searchText+"%");
			
			pstmt.setString(3, company);


			rset = pstmt.executeQuery();

			if (rset.next()) {
				totalCount = rset.getInt("total");
			}

			System.out.println("totalCount:" + totalCount);
			
			int totalNaviCount = 0;

			if (totalCount % recordPerPage == 0)
				totalNaviCount = totalCount / recordPerPage;
			else
				totalNaviCount = totalCount / recordPerPage + 1;

			int start = 0;
			int end = 0;
			
		
			start = ((currentPage-1) / naviPerPage)*naviPerPage + 1;
		

			end = start + naviPerPage - 1;

			int prev = 0;
			int next = 0;

			if (start - 1 > 0)
				prev = start - 1;

			if (end > totalNaviCount)
				end = totalNaviCount;
			
			boolean needPrev=true;
			boolean needNext=true;
			
			if (start == 1)
				needPrev = false;
			if (end == totalNaviCount) {
				needNext = false;
			}
			
			next=end+1;
			
			//System.out.println("start :" + start);
			
			//System.out.println("end :" + end);
			
			//System.out.println("totalNavi :" + totalNaviCount);
			
			//System.out.println("totalCnt :" + totalCount);
			
			String boardViewServlet="search.do";
			
			if(needPrev)
				sb.append("<li class='page-item'><a class='page-link' href='/"+boardViewServlet+"?currentPage="+prev+""
						+ "&boardTypeNo="+boardTypeNo+"&searchText="+searchText+"&searchSelect="+searchSelect+"&searchState="+searchState+"'"
						+ ">prev</a></li>");
			else
				sb.append("<li class='page-item disabled'><a class='page-link' href='/"+boardViewServlet+"?currentPage=" + prev + "'>prev</a></li>");

			for (int i = start; i <= end; i++) {
				if(i==currentPage)
					sb.append("<li class='page-item disabled'><a style='background-color:#EAEAEA' class='page-link' href='/"+boardViewServlet+"?currentPage="+i+"'>"+i+"</button></li>");
				else
					sb.append("<li class='page-item'><a class='page-link' href='/"+boardViewServlet+"?currentPage="+i+""
							+ "&boardTypeNo="+boardTypeNo+"&searchText="+searchText+"&searchSelect="+searchSelect+"&searchState="+searchState+"'"
							+ ">"+i+"</a></li>");
			}

			if(needNext)
				sb.append("<li class='page-item'><a class='page-link' href='/"+boardViewServlet+"?currentPage="+next+""
						+ "&boardTypeNo="+boardTypeNo+"&searchText="+searchText+"&searchSelect="+searchSelect+"&searchState="+searchState+"'"
						+ ">next</a></li>");
			else
				sb.append("<li class='page-item disabled'><a class='page-link' href='/"+boardViewServlet+"?currentPage=" + next + "'>next</a></li>");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return sb.toString();
	}

	public int getSharingCount(Connection conn) {
		// TODO Auto-generated method stub
		
		Statement stmt = null;
		
		ResultSet rset = null;
		
		String sql = "select count(*) as count from board where board_type_no=2 and board_create_date+7>sysdate";
		
		int count =0;
		
		try {
			
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				count = rset.getInt("count");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		
		return count;
	}

	public int getEmergencyCount(Connection conn) {
		// TODO Auto-generated method stub
		Statement stmt = null;
		
		ResultSet rset = null;
		
		String sql = "select count(*) as count from board where board_type_no=1 and board_grade='긴급' and board_create_date+7>sysdate";
		
		int count =0;
		
		try {
			
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				count = rset.getInt("count");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		
		return count;
	}

	public int getNewTechnicalCount(Connection conn, String company, int boardState) {
		// TODO Auto-generated method stub
				PreparedStatement pstmt = null;
				
				ResultSet rset = null;
				
				String sql = null;
				
				if(company.equals("sol")) {
					sql = "select count(*) as count from board where board_type_no=3 and board_create_date+7>sysdate and board_state_no=?";
				}
				else {
					sql = "select count(*) as count from board b, member m where board_type_no=3" + 
							"                           and m.member_company='"+company+"' and b.board_create_date+7>sysdate" + 
							"							and b.board_creater_no = m.member_no" + 
							"							and b.board_state_no=?";
				}
				
				int count =0;
				
				try {
					
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setInt(1, boardState);
					
					rset = pstmt.executeQuery();
					
					if(rset.next()) {
						count = rset.getInt("count");
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					JDBCTemplate.close(rset);
					JDBCTemplate.close(pstmt);
				}
				
				
				return count;
			}

}
