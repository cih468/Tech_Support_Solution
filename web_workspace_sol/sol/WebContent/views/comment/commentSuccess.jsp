<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/layout/head.jsp" %>
<title>댓글 등록 완료</title>
</head>
<body>

<script>
	
	alert("댓글을 등록했습니다.");
	
	var boardType="${param.boardType}";
	
	if(boardType=="1")
		location.href="/noticeOneView.do?boardNo="+${param.boardNo}+"";
		
	if(boardType=="2")
		location.href="/sharingOneView.do?boardNo="+${param.boardNo}+"";
		
	if(boardType=="3")
		location.href="/technicalSupportOneView.do?boardNo="+${param.boardNo}+"";
	
</script>

</body>
</html>