package com.sol.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.jsp.tagext.PageData;

import org.omg.CORBA.INTERNAL;

import com.sol.common.JDBCTemplate;
import com.sol.member.model.vo.Member;
import com.sol.member.model.vo.PageMemberData;
import com.sol.member.model.vo.SharingActivity;
import com.sol.member.model.vo.TechnicalSupportActivity;
import com.sol.memeber.model.dao.MemberDao;

public class MemberService {

	public int insertMember(Member member) {
		// TODO Auto-generated method stub

		Connection conn = JDBCTemplate.getConnection();

		int result = new MemberDao().insertMember(conn, member);

		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);

		return result;
	}

	public Member isActiveId(String email, String password) {
		// TODO Auto-generated method stub
		
		Connection conn = JDBCTemplate.getConnection();
				
		Member m = new MemberDao().isActiveId(conn,email,password);
		
		JDBCTemplate.close(conn);
		
		return m;

	}

	public ArrayList<Member> selectAllMember(String active) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Member> memberList = new MemberDao().selectAllMember(conn,active);
		
		JDBCTemplate.close(conn);
		
		return memberList;
		
		
	}

	public int changeActive(String active,String email) {
		// TODO Auto-generated method stub
		
		int result = 0 ;
		
		Connection conn = JDBCTemplate.getConnection();
		
		result = new MemberDao().changeActive(conn,active,email);
		
		if(result>0)
			JDBCTemplate.commit(conn);
		else
			JDBCTemplate.rollback(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int deleteMember(String email) {
		// TODO Auto-generated method stub
		
		int result = 0;
		
		Connection conn = JDBCTemplate.getConnection();
		
		result = new MemberDao().deleteMember(conn,email);
		
		if(result>0)
			JDBCTemplate.commit(conn);		
		else
			JDBCTemplate.rollback(conn);
		
		return result;

	}

	public Member selectOneMember(String email) {
		// TODO Auto-generated method stub
		
		Connection conn = JDBCTemplate.getConnection();
		
		Member m = new MemberDao().selectOneMember(conn,email);
		
		JDBCTemplate.close(conn);
		
		return m;
	}
	
	
	public Member selectOneMember(int memberNo) {
		// TODO Auto-generated method stub
		
		Connection conn = JDBCTemplate.getConnection();
		
		Member m = new MemberDao().selectOneMember(conn,memberNo);
		
		JDBCTemplate.close(conn);
		
		return m;
	}

	public int changeInfo(String password, String phone, String email) {
		// TODO Auto-generated method stub
		
		int result = 0 ;
		
		Connection conn = JDBCTemplate.getConnection();
		
		result = new MemberDao().changeInfo(conn,password,phone,email);
		
		if(result>0)
			JDBCTemplate.commit(conn);
		else
			JDBCTemplate.rollback(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}

	public int changeType(int typeNo, String email) {
		// TODO Auto-generated method stub
		
		int result = 0 ;
				
		Connection conn = JDBCTemplate.getConnection();
			
		result = new MemberDao().changeType(conn,typeNo,email);
				
		if(result>0)
			JDBCTemplate.commit(conn);
		else
			JDBCTemplate.rollback(conn);
				
		JDBCTemplate.close(conn);
				
		return result;
	}

	public PageMemberData selectPageMember(String active, int currentPage) {
		// TODO Auto-generated method stub		
		
		Connection conn = JDBCTemplate.getConnection();
		
		//회원이 한페이지에 몇명이나 등록될지
		int recordCountPerPage = 3;
		//navi가 한페이지에 몇개나 표시될지
		int naviCountPerPage=3;		
		
		PageMemberData pd = new MemberDao().selectPageMember(conn, active, currentPage,recordCountPerPage);
		
		String pageNavi = new MemberDao().getMemberNavi(conn, active, currentPage,recordCountPerPage,naviCountPerPage);
		
		pd.setPageNavi(pageNavi);
		
		return pd;
	}

	public SharingActivity sharingActive(Member selectMember) {
		// TODO Auto-generated method stub
		
		Connection conn = JDBCTemplate.getConnection();
		
		int totalSharingCount = new MemberDao().totalSharingCounting(conn,selectMember);
		
		int selectedSharingCount = new MemberDao().selectedSharingCounting(conn,selectMember);
		
		int unselectedSharingCount = new MemberDao().unselectedSharingCounting(conn,selectMember);
		
		int totalCommentCount = new MemberDao().totalCommentCounting(conn,selectMember);
		
		//공유 게시판에 올린 글 수 확인
		SharingActivity memberSharingActivity = new SharingActivity(totalSharingCount, selectedSharingCount, unselectedSharingCount, totalCommentCount);
		
		memberSharingActivity.setScore();
		
		JDBCTemplate.close(conn);
		
		return memberSharingActivity;
	}

	public TechnicalSupportActivity technicalActive(Member selectMember) {
		// TODO Auto-generated method stub
		
		Connection conn = JDBCTemplate.getConnection();
		
		int countNewRegistration = 1;
		
		int countAssignEngineer = 2;
		
		int countAnalyzing = 3;
		
		int countRequestInformation=4;
		
		int countNeedFeedBack=5;
		
		int countResolved = 6;
		
		int newRegistration = new MemberDao().technicalActive(conn,selectMember,countNewRegistration);
		
		int assignEngineer = new MemberDao().technicalActive(conn,selectMember,countAssignEngineer);
		
		int analyzing = new MemberDao().technicalActive(conn,selectMember,countAnalyzing);
		
		int requestInformation = new MemberDao().technicalActive(conn,selectMember,countRequestInformation);
		
		int needFeedBack = new MemberDao().technicalActive(conn,selectMember,countNeedFeedBack);
		
		int resolved = new MemberDao().technicalActive(conn,selectMember,countResolved);
		
		TechnicalSupportActivity memberTechnicalActivity = new TechnicalSupportActivity(newRegistration, assignEngineer, analyzing, requestInformation, needFeedBack, resolved);
		
		memberTechnicalActivity.setTotalCount();
		
		JDBCTemplate.close(conn);
		
		return memberTechnicalActivity;
	}

	public ArrayList<Member> selectEngineerList() {
		// TODO Auto-generated method stub
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Member> engineerList= new MemberDao().selectEngineerList(conn);
		
		ArrayList<Integer> engineerManageCountList = new MemberDao().manageCountList(conn);
		
		JDBCTemplate.close(conn);
		
		return engineerList;
	}
	
	public ArrayList<Integer> manageCountList() {
		// TODO Auto-generated method stub
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Integer> engineerManageCountList = new MemberDao().manageCountList(conn);
		
		JDBCTemplate.close(conn);
		
		return engineerManageCountList;
	}

}
