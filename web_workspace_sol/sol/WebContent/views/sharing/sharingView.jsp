<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

   <head>
 	<%@ include file="/layout/head.jsp" %>
  </head>
  <body>
    <!-- Side Navbar -->
  	<%@ include file="/layout/sideNavi.jsp" %>
    <div class="page">
      <!-- navbar-->
      <%@include file="/layout/header.jsp"%>
      <!-- Breadcrumb-->
      <div class="breadcrumb-holder">
        <div class="container-fluid">
          <ul class="breadcrumb">
            <li class="breadcrumb-item"><a href="/views/main.jsp">Home</a></li>
            <li class="breadcrumb-item active">Sharing Technology      </li>
          </ul>
        </div>
      </div>
      <section>
        <div class="container-fluid">
          <!-- Page Header-->
          <header> 
            <div style="text-align:right;">
            	 <button type="button" class="btn btn-sm btn-outline-secondary">조회수</button><button type="button" class="btn btn-sm btn-outline-secondary">${requestScope.board.hits}</button> 	
            </div>
            <h1 class="h3 display">기술공유 게시판       </h1>
            <br>
            <h4> ${requestScope.board.grade}</h4>         
            <br>
            
            
          </header>

    <main role="main">

      <section class="jumbotron">
        <div class="container">
        
        	<div style="text-align:right;">
        	<button type="button" class="btn btn-sm btn-outline-secondary">작성일시</button>&nbsp;
       		${requestScope.board.createDate}
	        <br><br>
	        </div>
        
          <button type="button" class="btn btn-sm btn-outline-secondary">작성자</button>&nbsp;
          ${requestScope.creater.userName}
          <br><br>
          
          <h1 class="jumbotron-heading">
          <button type="button" class="btn btn-sm btn-outline-secondary">제목</button>&nbsp;
          ${requestScope.board.name}</h1>
          <br><br>
          	<p class="lead text-muted"><button type="button" class="btn btn-sm btn-outline-secondary">내용</button>&nbsp;
         	 <div style="overflow; scroll; width:1200px; height:400px; class="btn btn-sm btn-outline-secondary">
          		${requestScope.board.text}
         	 </div>
        	</p>
          <button type="button" class="btn btn-sm btn-outline-secondary">첨부파일</button>&nbsp;
          <a href="/fileDownLoad.do?boardNo=${requestScope.board.boardNo }">${requestScope.board.fileData.fileName}</a>
        </div>
      </section>
      
      
     <c:if test="${sessionScope.member.memberNo eq requestScope.board.createrNo|| sessionScope.member.typeNo eq 4}">
      <div style="text-align:right">      
      	<form action="/noticeModify.do?boardNo=${requestScope.board.boardNo}" method="post">      		
      		<button type="submit" class="btn btn-secondary my-2">수정</button>
      	</form>
      	<form action="/noticeDelete.do?boardNo=${requestScope.board.boardNo}" method="post">      	
        	<button type="submit" class="btn btn-secondary my-2" onclick="return deleteNotice();">삭제</button>
        </form>
      </div>
     </c:if>
		
		<br><br>
	<center>	
	
	<!-- 채택된 답변을 보여주는 div -->
	<div style="text-align:left">	
	 <c:if test="${requestScope.selectedComment.commentNo gt 0}">
      <c:set var="selectedComment" value="${requestScope.selectedComment }" />
       <div class="album py-5 bg-light">
        <div class="container">
          <div class="row">
            <div class="col-md-12">
              <div class="card mb-4 box-shadow">
              <button type="button" class="btn btn-sm btn-outline-secondary" style="width:100px; background-color:pink; color:white;">채택된 답변</button>&nbsp;<br>
                <div class="card-body">
               	  <button type="button" class="btn btn-sm btn-outline-secondary">${selectedComment.createrName} </button>&nbsp;<br>
                  <p class="card-text" id="commentTextView">${selectedComment.commentText}</p>	
                  <textarea value="${selectedComment.commentText}" name="commentTextModify" style="width:500px; height:130px; display:none; resize:none;">${comment.commentText}</textarea>
                  <div class="d-flex justify-content-between">
                    <div style="text-align:right;" class="btn-group">
                  		<form action="/selectComment.do?boardNo=${requestScope.board.boardNo}" method="post">
                      		<button type="submit" onclick="return selectComment(this);" class="btn btn-secondary my-2" class="selectComment">채택 취소</button>
                      		<input type="hidden" id="commentNo" name="commentNo" value="0"/>                      		
                  		</form>
                    </div>
                    <small class="text-muted">${selectedComment.createDate}</small>
                  </div>
                </div>
              </div>
            </div>
           </div>
        </div>
       </div>
     </c:if>
    </div>
     
		<div style="text-align:center">
			<form action="/insertComment.do?boardNo=${requestScope.board.boardNo}" method="post">
			   	<p style="text-align:right;">
     				<button type="button" class="btn btn-sm btn-outline-secondary">댓글수</button><button type="button" class="btn btn-sm btn-outline-secondary">${requestScope.board.commentNo}</button>
     				<input type="hidden" name="commentNo" value="${requestScope.board.commentNo}"/>
     		   	</p>        
         		<p style="text-align:center">      	
            		<textarea style="width:500px; height:100px; resize:none;" id="commentText" name="commentText"></textarea>            		   
            		<button id="insertComment" onclick="return commentSave();" class="btn btn-primary my-2">댓글 달기</button>
            	</p>
     		</form>
     	</div> 
     </center>
         
     
	 <c:choose>
	  <c:when test="${requestScope.commentIsEmpty eq true}">
       <div class="album py-5 bg-light">
        <div class="container">
          <div class="row">
            <div class="col-md-12">
              <div class="card mb-4 box-shadow">
                <div class="card-body">
                	<button type="button" class="btn btn-sm btn-outline-secondary">댓글 작성자명</button>&nbsp;<br><br>
                  <p class="card-text">댓글이 없습니다. 의견을 남겨주세요</p>
                  <div class="d-flex justify-content-between">
                    <div style="text-align:right;" class="btn-group">
                    </div>
                    <small class="text-muted">2018-11-11</small>
                  </div>
                </div>
              </div>
            </div>
           </div>
        </div>
       </div>
      </c:when>
      
     <c:otherwise>
      <c:forEach items="${requestScope.commentList}" var="comment" varStatus="status">
       <div class="album py-5 bg-light">
        <div class="container">
          <div class="row">
            <div class="col-md-12">
              <div class="card mb-4 box-shadow">
              	<c:if test="${comment.commentNo == requestScope.selectedComment.commentNo}">
                	<button type="button" class="btn btn-sm btn-outline-secondary" style="width:100px; background-color:pink; color:white;">채택된 답변</button>&nbsp;<br>
                </c:if>
                <div class="card-body">
                	<button type="button" class="btn btn-sm btn-outline-secondary">${comment.createrName} </button>&nbsp;<br>
                  <p class="card-text" id="commentTextView">${comment.commentText}</p>	
                  <textarea value="${comment.commentText}" name="commentTextModify" style="width:500px; height:130px; display:none; resize:none;">${comment.commentText}</textarea>
                  <div class="d-flex justify-content-between">
                    <div style="text-align:right;" class="btn-group">
                      <c:if test="${comment.createrEmail eq sessionScope.member.email || sessionScope.member.typeNo eq 4}">
                      	<form action="/modifyComment.do?commentNo=${comment.commentNo}&boardNo=${requestScope.board.boardNo}" method="post">
                      		<textarea value="${comment.commentText}" id="commentText" style="width:500px; height:130px; display:none; resize:none;">${comment.commentText}</textarea>
                      		<input type="hidden" name="commentTextModify"/>
                      		<button type="submit" id="modifyBtn" onclick="return modifyComment(this);" class="btn btn-secondary my-2">수정</button>                      		                      	
                      		&nbsp;
                      	</form>
                      	&nbsp;
                  		<form action="/deleteComment.do?commentNo=${comment.commentNo}&boardNo=${requestScope.board.boardNo}" method="post">
                      		<button type="submit" onclick="return deleteComment();" class="btn btn-secondary my-2">삭제</button>                      		
                  		</form>
                  		&nbsp; &nbsp;
                  		<form action="/selectComment.do?boardNo=${requestScope.board.boardNo}" method="post">
							<c:if test="${comment.commentNo != requestScope.selectedComment.commentNo}">
                      			<button type="submit" onclick="return selectComment(this);" class="btn btn-secondary my-2" class="selectComment">답변 채택</button>
                      		</c:if>
                      		<input type="hidden" id="commentNo" name="commentNo" value="${comment.commentNo}"/>                      		
                  		</form>
                      </c:if>
                    </div>
                    <small class="text-muted">${comment.createDate}</small>
                  </div>
                </div>
              </div>
            </div>
           </div>
        </div>
       </div>
     </c:forEach>
    </c:otherwise>
   </c:choose>
      

  </main>
    
    <!-- JavaScript files-->
 	<%@include file="/layout/javaScriptFile.jsp"%>
    <!-- Main File-->
    <script src="/js/front.js"></script>
    
    <!-- 댓글 달기 text창 만드는 JavaScript -->
    <script>
    
    	
    	function deleteNotice(){
			if(window.confirm("정말로 이 글을 삭제하시겠습니까?")){
				return true;
			}else{
				return false;
			}
		};
		
    	function commentSave(){
    		
    		if($("#commentText").val()==""){
    			alert("댓글을 입력해주세요");
    			return false;
    		}    			
    		else{    			
				return true;    			
    		}    			
    	}
    
    	function deleteComment(){
    		if(window.confirm("정말로 이 댓글을 삭제하시겠습니까?")){
    			return true;
    		}else{
    			return false;
    		}
    	}
    	
    	function modifyComment(modiBtn){
    		
    		var btn=modiBtn;
    		
    		if($(btn).html()=="완료"){    		
        		$(btn).html("수정");
				
				var thisText = $(btn).parent("form").parent("div").parent("div").siblings("textarea").val();
    			
    			var thisInput = $(btn).siblings("input");
    			
    			$(thisInput).val(thisText);
    			
        		return true;

    		}	
    		
    		else {
    			$(btn).parent("form").parent("div").parent("div").siblings("textarea").css("display","block");
        		$(btn).parent("form").parent("div").parent("div").siblings("p").css("display","none");
    			$(btn).html("완료");
    			return false;
    		}
    	}
    	
    	var selectNo="${requestScope.selectedComment.commentNo}";
    	
    	if($(".selectComment").siblings("input").val()==selectNo){
    		$(this).html("");
    	}
    	
    	function selectComment(selectBtn){    		
    		
    		if($(selectBtn).html()=="답변 채택"){
    			
    			if(selectNo==0||selectNo=="") //선택된 답변이 없으면
    				return true;    			 
    			else if(window.confirm("이전에 채택된 다른 답변이 있습니다. 변경하시겠습니까?"))	//현재 선택된 답변이 있으면
    				return true;
    			else
    				return false;
    		}else{
    			return true;    			
    		}
    			
    	}  		
    	
    	
    </script>
  </body>
</html>
