<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>  
  <!-- head 부분 -->
  <%@include file="/layout/head.jsp" %>
  </head>
   
  <body>
    <!-- Side Navbar -->
    <%@include file="/layout/sideNavi.jsp" %>
   
    <div class="page">
      <!-- navbar-->
      <%@include file="/layout/header.jsp" %>
      <!-- Breadcrumb-->
      <div class="breadcrumb-holder">
        <div class="container-fluid">
          <ul class="breadcrumb">
            <li class="breadcrumb-item"><a href="index.html">Home</a></li>
          </ul>
        </div>
      </div>
      <section class="forms">
        <div class="container-fluid">
          <!-- Page Header-->
          <header> 
            <h1 class="h3 display">
            	<c:choose>
           		 	<c:when test="${requestScope.board.typeNo eq 1}">
            			공지사항
            		</c:when>
            		
            		<c:when test="${requestScope.board.typeNo eq 2}">
            			기술공유 게시판
            		</c:when>
            		
            		<c:when test="${requestScope.board.typeNo eq 3}">
            			기술지원 게시판
            		</c:when>
            	</c:choose>
            </h1>
          </header>
          <div class="row">      
            <div class="col-lg-12">
              <div class="card">
                <div class="card-header d-flex align-items-center">
                  <h4>
					<c:choose>
    	       		 	<c:when test="${requestScope.board.typeNo eq 1}">
        	    			공지사항 수정
            			</c:when>
            		
     	    	   		<c:when test="${requestScope.board.typeNo eq 2}">
        	    			기술공유 글 수정
            			</c:when>
            		
            			<c:when test="${requestScope.board.typeNo eq 3}">
            				기술지원 글 수정
            			</c:when>
            		 </c:choose>
					</h4>
                </div>                
                  
                <div class="line"></div>                
                <div class="card-body">                
                  <form class="form-horizontal" action="/noticeModifySubmit.do" method="post" enctype="multipart/form-data">
                  	<input type="hidden" name="boardNo" value="${requestScope.board.boardNo }"/>
                  	<c:if test="${requestScope.board.typeNo eq 1}">
      	            	<div class="form-group row">
        	              <label class="col-sm-2 form-control-label">중요도</label>
            	          <div class="col-sm-1 mb-3">
                	        <select name="grade" class="form-control" selected="${requestScope.board.grade}">
                    	      <option>긴급</option>
                        	  <option>중요</option>
  	                        <option>일반</option>                          
    	                    </select>                        
        	              </div>
            	    	</div>
                	</c:if>
                    <div class="form-group row">
                      <label class="col-sm-2 form-control-label">제목</label>
                      <div class="col-sm-10">
                        <input value="${requestScope.board.name}" name="name" type="text" class="form-control" placeholder="제목을 입력하세요">
                      </div>
                    </div>               
                    <div class="line"></div>
                    <div class="form-group row">
                      <label class="col-sm-2 form-control-label">내용</label>
                      <div class="col-sm-10 mb-3">
                        <textarea name="text" class="form-control" style="height:500px;" placeholder="내용을 입력하세요">${requestScope.board.text}</textarea>
                      </div>
                    </div>
                    
                    <c:if test="${sessionScope.member.typeNo gt 2 && requestScope.board.typeNo eq 1}">              
                    <div class="line"></div>
                    <div class="form-group row">
                      <label class="col-sm-2 form-control-label">메인페이지 표시 <br><small class="text-primary">한개의 글만 메인페이지에 등록 가능합니다.</small></label>
                      <div class="col-sm-10">
                        <div class="i-checks">                      
                          <input id="loginActive" name="loginActive" type="checkbox"  value="${requestScope.board.loginActive}" class="form-control-custom">
                          <label for="loginActive">이 글을 메인페이지에 표시</label>
                        </div>                       
                      </div>
                    </div>            
                    </c:if>
                    <div class="line"></div>                    
                    <div class="form-group row">
                      <label class="col-sm-2 form-control-label">파일 첨부</label>
                      <div class="col-sm-3">                  
                        <div class="form-group">
                          <div class="input-group">
                            <div class="input-group-append">
                            	<input type="text" value="${requestScope.board.fileData.fileName }" id="fileName" name="fileName" class="form-control" placeholder="파일명" style="width:500px;" readonly/>
                            	<input type="file" name="upfile" id="fileInput" style="display:none;" readonly/>
                             	<button type="button" class="btn btn-primary" onclick="return inputFile();" name="upfile" id="fileInputBtn">파일선택</button>
                             	&nbsp;
                              	<button type="button" class="btn btn-primary" onclick="deleteFile();">첨부파일 삭제</button>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                     <div class="line"></div>
                    <div class="form-group row">
                      <div class="col-sm-6 offset-sm-6">
                      	<button type="submit" onclick="return isSave();" class="btn btn-primary">완료</button>
                        <a href="/views/notice/notice.jsp" onclick="return isCancel();" class="btn btn-secondary">취소</a>                        
                      </div>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
      <footer class="main-footer">
        <div class="container-fluid">
          <div class="row">
            <div class="col-sm-6">
              <p>Technical Support &copy; 2018-2019</p>
            </div>
            <div class="col-sm-6 text-right">
              <p>Design by <a href="https://bootstrapious.com" class="external">Bootstrapious</a></p>
              <!-- Please do not remove the backlink to us unless you support further theme's development at https://bootstrapious.com/donate. It is part of the license conditions and it helps me to run Bootstrapious. Thank you for understanding :)-->
            </div>
          </div>
        </div>
      </footer>
    </div>
    <!-- JavaScript files-->
	<%@ include file="/layout/javaScriptFile.jsp" %>
	
	<!-- cancel 버튼 확인을 위한 JavaScript 코드 -->
	<script>
		function isCancel(){
			if(window.confirm("정말로 취소하시겠습니까? 현재 작성하시던 글이 모두 취소됩니다.")){
				return true;
			}else
				return false;
		}
		
		function isSave(){
			if(window.confirm("저장하고 글을 올리시겠습니까?")){
				return true;
			}else
				return false;
		}
		
	
		// loginActive 체크박스를 checked로 처리  
		
		$(function (){			
			var loginActive = $("#loginActive");
			if(loginActive.val()=="Y"){				
				$("#loginActive").prop("checked",true);
			}
		});
		
		
		function inputFile(){
			$("#fileInput").click();
		};	
		
		
		$(function(){
			
				$("#fileInput").change(function(){
				
				var filePath = $("#fileInput").val();
				
				console.log(filePath);
			
				var fileName = filePath.split('\\').pop().trim();
				
				var ext = fileName.split('.').pop().trim();
				
				if(ext=="zip"||ext=="jpg"||ext=="png"||ext=="bmp"||ext=="jpeg"||ext=="gif"
					||ext=="hwp"||ext=="doc"||ext=="ppt"||ext=="xls"||ext=="txt"||ext=="pdf"
					||ext=="pptx"||ext=="docx"){
					
					$("#fileName").val(fileName);
				}
				else{
					
					alert("이미지,일반문서,zip 파일만 업로드 가능합니다.");
					
					$("#fileInput").val("");
					$("#fileName").val("");
					
					isFileExtError = "error";
				}	
			});			
		});
		
		function deleteFile(){
			$("#fileInput").val("");
			$("#fileName").val("");
		}
	
	
	
	</script>
	
    <!-- Main File-->
    <script src="/js/front.js"></script>
    
    
  </body>
</html>