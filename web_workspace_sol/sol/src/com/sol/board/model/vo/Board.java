package com.sol.board.model.vo;

import com.sol.file.model.vo.FileData;

public class Board {
	
	int num;		//리스트에 표시할 번호
	int boardNo;	
	String name;	//제목
	String text;	//내용
	int hits;	//조회수
	int commentNo;	//게시물 댓글수
	int selectedComment;	//채택된 댓글 번호
	String grade;	//등급(중요도)
	String loginActive;	//로그인화면 보여주기
	int createrNo;
	int managerNo;
	int stateNo;
	int typeNo;
	String createDate;
	FileData fileData;
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Board(int num, int boardNo, String name, String text, int hits, int commentNo, int selectedComment,
			String grade, String loginActive, int createrNo, int managerNo, int stateNo, int typeNo, String createDate,
			FileData fileData) {
		super();
		this.num = num;
		this.boardNo = boardNo;
		this.name = name;
		this.text = text;
		this.hits = hits;
		this.commentNo = commentNo;
		this.selectedComment = selectedComment;
		this.grade = grade;
		this.loginActive = loginActive;
		this.createrNo = createrNo;
		this.managerNo = managerNo;
		this.stateNo = stateNo;
		this.typeNo = typeNo;
		this.createDate = createDate;
		this.fileData = fileData;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public int getSelectedComment() {
		return selectedComment;
	}
	public void setSelectedComment(int selectedComment) {
		this.selectedComment = selectedComment;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getLoginActive() {
		return loginActive;
	}
	public void setLoginActive(String loginActive) {
		this.loginActive = loginActive;
	}
	public int getCreaterNo() {
		return createrNo;
	}
	public void setCreaterNo(int createrNo) {
		this.createrNo = createrNo;
	}
	public int getManagerNo() {
		return managerNo;
	}
	public void setManagerNo(int managerNo) {
		this.managerNo = managerNo;
	}
	public int getStateNo() {
		return stateNo;
	}
	public void setStateNo(int stateNo) {
		this.stateNo = stateNo;
	}
	public int getTypeNo() {
		return typeNo;
	}
	public void setTypeNo(int typeNo) {
		this.typeNo = typeNo;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public FileData getFileData() {
		return fileData;
	}
	public void setFileData(FileData fileData) {
		this.fileData = fileData;
	}
}
	
		