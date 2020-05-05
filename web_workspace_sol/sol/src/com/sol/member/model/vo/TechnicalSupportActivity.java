package com.sol.member.model.vo;

public class TechnicalSupportActivity {
	
	private int newRegistration;	//신규등록
	private int assignEngineer; 	//담당직원 할당
	private int analyzing;			//분석중
	private int requestInforation;	//추가 정보요청
	private int needFeedBack;		//피드백필요
	private int resolved;			//해결완료
	private int totalCount;			//전체 담당 수
	
	public TechnicalSupportActivity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TechnicalSupportActivity(int newRegistration, int assignEngineer, int analyzing, int requestInforation,
			int needFeedBack, int resolved) {
		super();
		this.newRegistration = newRegistration;
		this.assignEngineer = assignEngineer;
		this.analyzing = analyzing;
		this.requestInforation = requestInforation;
		this.needFeedBack = needFeedBack;
		this.resolved = resolved;
	}

	public int getNewRegistration() {
		return newRegistration;
	}

	public void setNewRegistration(int newRegistration) {
		this.newRegistration = newRegistration;
	}

	public int getAssignEngineer() {
		return assignEngineer;
	}

	public void setAssignEngineer(int assignEngineer) {
		this.assignEngineer = assignEngineer;
	}

	public int getAnalyzing() {
		return analyzing;
	}

	public void setAnalyzing(int analyzing) {
		this.analyzing = analyzing;
	}

	public int getRequestInforation() {
		return requestInforation;
	}

	public void setRequestInforation(int requestInforation) {
		this.requestInforation = requestInforation;
	}

	public int getNeedFeedBack() {
		return needFeedBack;
	}

	public void setNeedFeedBack(int needFeedBack) {
		this.needFeedBack = needFeedBack;
	}

	public int getResolved() {
		return resolved;
	}

	public void setResolved(int resolved) {
		this.resolved = resolved;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount() {
		this.totalCount = this.newRegistration+this.analyzing + this.requestInforation + this.needFeedBack + this.resolved+ this.assignEngineer; 
	}

	
	

}
