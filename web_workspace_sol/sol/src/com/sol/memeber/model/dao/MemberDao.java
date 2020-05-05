package com.sol.memeber.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sol.common.JDBCTemplate;
import com.sol.member.model.vo.Member;
import com.sol.member.model.vo.PageMemberData;
import com.sol.member.model.vo.SharingActivity;

public class MemberDao {

	public int insertMember(Connection conn, Member member) {
		// TODO Auto-generated method stub

		String sql = "insert into member values (memberNo.nextval,?,?,?,?,?,?,sysdate,'W')";

		PreparedStatement pstmt = null;

		int result = 0;

		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, member.getUserName());

			pstmt.setString(2, member.getPassword());

			pstmt.setString(3, member.getEmail());
			
			pstmt.setString(4, member.getPhone());

			pstmt.setInt(5, member.getTypeNo());

			pstmt.setString(6, member.getCompany());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		System.out.println("result : " + result);

		return result;

	}

	public Member isActiveId(Connection conn, String email, String password) {
		// TODO Auto-generated method stub

		String sql = "select * from member where member_email=? and member_password=? and member_active='Y'";

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		Member m = null;

		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, email);

			pstmt.setString(2, password);

			rset = pstmt.executeQuery();

			if (rset.next()) {

				m = new Member();
				m.setMemberNo(rset.getInt("MEMBER_NO"));
				m.setUserName(rset.getString("MEMBER_NAME"));
				m.setPassword(rset.getString("MEMBER_PASSWORD"));
				m.setEmail(rset.getString("MEMBER_EMAIL"));
				m.setPhone(rset.getString("MEMBER_PHONE"));
				m.setTypeNo(rset.getInt("MEMBER_TYPE_NO"));
				m.setCompany(rset.getString("MEMBER_COMPANY"));
				m.setEnrollDate(rset.getString("MEMBER_ENROLL_DATE"));
				m.setActive(rset.getString("MEMBER_ACTIVE"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return m;

	}

	public ArrayList<Member> selectAllMember(Connection conn, String active) {
		// TODO Auto-generated method stub

		Statement stmt = null;
		String sql = "select * from member where member_active='" + active + "' and member_type_no<4";
		ResultSet rset = null;

		ArrayList<Member> memberList = new ArrayList<>();

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				Member m = new Member();
				m.setMemberNo(rset.getInt("Member_no"));
				m.setUserName(rset.getString("MEMBER_NAME"));
				m.setPassword(null);
				m.setEmail(rset.getString("MEMBER_EMAIL"));
				m.setPhone(rset.getString("MEMBER_PHONE"));
				m.setTypeNo(rset.getInt("MEMBER_TYPE_NO"));
				m.setCompany(rset.getString("MEMBER_COMPANY"));
				m.setEnrollDate(rset.getString("MEMBER_ENROLL_DATE"));
				m.setActive(rset.getString("MEMBER_ACTIVE"));

				memberList.add(m);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}

		return memberList;
	}

	public int changeActive(Connection conn, String active, String email) {
		// TODO Auto-generated method stub

		int result = 0;

		Statement stmt = null;

		String sql = "update member set member_active='" + active + "' where member_email='" + email + "'";

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

	public int deleteMember(Connection conn, String email) {
		// TODO Auto-generated method stub

		Statement stmt = null;

		String sql = "delete from member where member_email='" + email + "'";

		int result = 0;

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

	public Member selectOneMember(Connection conn, String email) {
		// TODO Auto-generated method stub

		Statement stmt = null;

		String sql = "select * from member where member_email='" + email + "'";

		Member m = null;

		ResultSet rset = null;

		try {

			stmt = conn.createStatement();

			rset = stmt.executeQuery(sql);

			if (rset.next()) {
				m = new Member();
				m.setMemberNo(rset.getInt("Member_no"));
				m.setUserName(rset.getString("MEMBER_NAME"));
				m.setPassword(rset.getString("MEMBER_PASSWORD"));
				m.setEmail(rset.getString("MEMBER_EMAIL"));
				m.setPhone(rset.getString("MEMBER_PHONE"));
				m.setTypeNo(rset.getInt("MEMBER_TYPE_NO"));
				m.setCompany(rset.getString("MEMBER_COMPANY"));
				m.setEnrollDate(rset.getString("MEMBER_ENROLL_DATE"));
				m.setActive(rset.getString("MEMBER_ACTIVE"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}

		return m;
	}
	
	public Member selectOneMember(Connection conn, int memberNo) {
		// TODO Auto-generated method stub

		Statement stmt = null;

		String sql = "select * from member where member_no='" + memberNo + "'";

		Member m = null;

		ResultSet rset = null;

		try {

			stmt = conn.createStatement();

			rset = stmt.executeQuery(sql);

			if (rset.next()) {
				m = new Member();
				m.setMemberNo(rset.getInt("Member_no"));
				m.setUserName(rset.getString("MEMBER_NAME"));
				m.setPassword(rset.getString("MEMBER_PASSWORD"));
				m.setEmail(rset.getString("MEMBER_EMAIL"));
				m.setPhone(rset.getString("MEMBER_PHONE"));
				m.setTypeNo(rset.getInt("MEMBER_TYPE_NO"));
				m.setCompany(rset.getString("MEMBER_COMPANY"));
				m.setEnrollDate(rset.getString("MEMBER_ENROLL_DATE"));
				m.setActive(rset.getString("MEMBER_ACTIVE"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}

		return m;
	}

	public int changeInfo(Connection conn, String password, String phone, String email) {
		// TODO Auto-generated method stub

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = "update member set member_password=?, member_phone=? where member_email=?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, password);

			pstmt.setString(2, phone);

			pstmt.setString(3, email);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;

	}

	public int changeType(Connection conn, int typeNo, String email) {
		// TODO Auto-generated method stub

		int result = 0;

		Statement stmt = null;

		String sql = "update member set member_type_No='" + typeNo + "' where member_email='" + email + "'";

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

	public PageMemberData selectPageMember(Connection conn, String active, int currentPage, int recordCountPerPage) {
		// TODO Auto-generated method stub

		PreparedStatement pstmt = null;

		// 시작 멤버 번호
		int startNum = (currentPage - 1) * recordCountPerPage + 1;

		// 끝 멤버 번호
		int endNum = startNum + recordCountPerPage - 1;

		String sql = "select * from (select member.*,row_number() over(order by member_no desc) as num from member where member_active=? and member_no>0)"
				+ "	where num between ? and ?";

		ArrayList<Member> memberList = new ArrayList<>();

		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, active);

			pstmt.setInt(2, startNum);

			pstmt.setInt(3, endNum);

			rset = pstmt.executeQuery();

			while (rset.next()) {

				Member m = new Member();
				m.setMemberNo(rset.getInt("Member_no"));
				m.setUserName(rset.getString("MEMBER_NAME"));
				m.setPassword(null);
				m.setEmail(rset.getString("MEMBER_EMAIL"));
				m.setPhone(rset.getString("MEMBER_PHONE"));
				m.setTypeNo(rset.getInt("MEMBER_TYPE_NO"));
				m.setCompany(rset.getString("MEMBER_COMPANY"));
				m.setEnrollDate(rset.getString("MEMBER_ENROLL_DATE"));
				m.setActive(rset.getString("MEMBER_ACTIVE"));
				m.setNum(rset.getInt("num"));
				memberList.add(m);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		PageMemberData pd = new PageMemberData(null, memberList, startNum, currentPage);

		return pd;
	}

	public String getMemberNavi(Connection conn, String active, int currentPage, int recordCountPerPage,
			int naviCountPerPage) {
		// TODO Auto-generated method stub

		String sql = "select count(*) as total_count from member where member_active=? and member_no>0 order by member_no";

		// 회원의 총 인원수를 저장하는 변수
		int recordTotalCount = 0; // 초기값 0으로

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, active);

			rset = pstmt.executeQuery();

			if (rset.next())
				recordTotalCount = rset.getInt("total_count");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		System.out.println("record total cnt  : " + recordTotalCount);

		// 네비바의 페이지 개수
		int pageTotalCount = 0;

		// 총 멤버수를 한페이지에 들어가는 회원수로 나눈 나머지가 0이면 딱 떨어지고, 아니면 딱 떨어지지 않으므로 페이지수가 하나 더 필요(간단하게
		// 생각하면 '올림' 처리)
		if (recordTotalCount % recordCountPerPage == 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		} else {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}

		// 에러 방지 코드
		if (currentPage < 1)
			currentPage = 1;
		else if (currentPage > pageTotalCount)
			currentPage = pageTotalCount;

		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;

		int endNavi = startNavi + naviCountPerPage - 1;

		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		boolean needPrev = true;
		boolean needNext = true;

		if (startNavi == 1)
			needPrev = false;
		if (endNavi == pageTotalCount) {
			needNext = false;
		}

		StringBuilder sb = new StringBuilder();
		
		String pageType;
		
		if(active.equals("Y")) {
			pageType="currentPageType";		
		}
		else {
			pageType="currentPageNType";
		}
		

		if (needPrev)
			sb.append("<li class='page-item'><button onclick='pageSelect("+(startNavi-1)+",\""+pageType+"\");' class='page-link' href='/memberAllView.do?"+pageType+"="+(startNavi - 1) + "' tableindex='-1'>Previous</a></li>");
		else
			sb.append("<li class='page-item disabled'><a class='page-link' href='#' tableindex='-1'>Previous</a></li>");

		for (int i = startNavi; i <= endNavi; i++) {
			if (i == currentPage) {
				// 현재 페이지가 내가 있는 위치 페이지와 같다면 진하게 표시
				sb.append(
						"<li class='page-item'><button onclick='return pageSelect("+(i)+",\""+pageType+"\");' style='background-color:#EAEAEA' class='page-link'>" + i + "</a></li>");
			} else {
				sb.append("<li class='page-item'><button onclick='return pageSelect("+(i)+",\""+pageType+"\");' class='page-link'>"
						+ i + "  </a></li>");
			}
		}
		if (needNext)
			sb.append("<li class='page-item'><button onclick='pageSelect("+(endNavi+1)+",\""+pageType+"\");' class='page-link'>Next</a></li>");
		else
			sb.append("<li class='page-item disabled'><a class='page-link' href='#' tableindex='-1'>Next</a></li>");
		
		return sb.toString();
	}

	public int totalSharingCounting(Connection conn, Member selectMember) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql =  "select count(*) as total_count from board where board_creater_no = ? and board_type_no=2"; 
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,selectMember.getMemberNo());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("total_count");
			}
				
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}

	public int selectedSharingCounting(Connection conn, Member selectMember) {
	int result = 0;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql =  "select count(*) as selected_count from board where board_creater_no = ? and board_type_no=2 and board_selected_comment>0"; 
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,selectMember.getMemberNo());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("selected_count");
			}
				
			System.out.println(result);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int unselectedSharingCounting(Connection conn, Member selectMember) {
	int result = 0;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql =  "select count(*) as unselected_count from board where board_creater_no = ? and board_type_no=2 and board_selected_comment=0"; 
				
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,selectMember.getMemberNo());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("unselected_count");
			}
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int totalCommentCounting(Connection conn, Member selectMember) {
	int result = 0;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = "select count(*) as total_comment_count from comment_table c, board b where c.comment_creater_email = ? and b.board_type_no=2 and c.board_no = b.board_no";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,selectMember.getEmail());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("total_comment_count");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int technicalActive(Connection conn, Member selectMember, int state) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String userType;
		
		if(selectMember.getTypeNo()==1)
			userType="creater";
		else
			userType="manager";
		
		
		
		String sql = "select count(*) as total from board where board_type_no=3 and board_state_no=? and board_"+userType+"_no=?";
		
		int count = 0;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, state);
			
			pstmt.setInt(2, selectMember.getMemberNo());
			
			rset=pstmt.executeQuery();
						
			if(rset.next()) {
				count = rset.getInt("total");
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

	public ArrayList<Member> selectEngineerList(Connection conn) {
		// TODO Auto-generated method stub
		
		
		
		Statement stmt = null;
		
		String sql = "select * from member where member_active='Y' and member_type_no between 2 and 3order by member_no";
		
		ResultSet rset = null;

		ArrayList<Member> engineerList = new ArrayList<>();
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				Member m = new Member();
				m.setMemberNo(rset.getInt("Member_no"));
				m.setUserName(rset.getString("MEMBER_NAME"));
				m.setPassword(null);
				m.setEmail(rset.getString("MEMBER_EMAIL"));
				m.setPhone(rset.getString("MEMBER_PHONE"));
				m.setTypeNo(rset.getInt("MEMBER_TYPE_NO"));
				m.setCompany(rset.getString("MEMBER_COMPANY"));
				m.setEnrollDate(rset.getString("MEMBER_ENROLL_DATE"));
				m.setActive(rset.getString("MEMBER_ACTIVE"));

				engineerList.add(m);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}

		return engineerList;
	}

	public ArrayList<Integer> manageCountList(Connection conn) {
		// TODO Auto-generated method stub
		
		Statement stmt = null;
		
		ResultSet rset = null;
		
		String sql = "select count(*) as manage_count from member m, board b "
				+ "where b.board_state_no<6 and m.member_type_no between 2 and 3 and m.member_active='Y' and b.board_manager_no=m.member_no "
				+ "group by m.member_no order by member_no";
		
		ArrayList<Integer> engineerManageCountList = new ArrayList<>();
		
		try {
			
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			while(rset.next())
			{
				int manageCount = rset.getInt("manage_count");
				engineerManageCountList.add(manageCount);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		
		return engineerManageCountList;
	}

	public int getCompanyMemberCount(Connection conn, String company) {
		// TODO Auto-generated method stub
		
		String sql = "select count(*) as count from member where member_company=? and member_enroll_date+7>sysdate";		
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		int count = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, company);
			
			rset = pstmt.executeQuery();
			
			if(rset.next())
				count = rset.getInt("count");
			
		
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