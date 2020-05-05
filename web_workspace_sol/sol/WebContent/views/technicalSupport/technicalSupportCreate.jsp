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
            <li class="breadcrumb-item active">Notice       </li>
          </ul>
        </div>
      </div>
      <section class="forms">
        <div class="container-fluid">
          <!-- Page Header-->
          <header> 
            <h1 class="h3 display">기술 지원 게시판</h1>
          </header>
          <div class="row">      
            <div class="col-lg-12">
              <div class="card">
                <div class="card-header d-flex align-items-center">
                  <h4>기술지원 게시글 작성</h4>
                </div>                
                  
                <div class="line"></div>                
                <div class="card-body">                
                  <form class="form-horizontal" action="/createTechnicalSupport.do" method="post" enctype="multipart/form-data">
                    <div class="form-group row">
                      <label class="col-sm-2 form-control-label">제목</label>
                      <div class="col-sm-10">
                        <input id="name" name="name" type="text" class="form-control" placeholder="제목을 입력하세요">
                      </div>
                    </div>               
                    <div class="line"></div>
                    <div class="form-group row">
                      <label class="col-sm-2 form-control-label">내용</label>
                      <div class="col-sm-10 mb-3">
                        <textarea id="text" name="text" class="form-control" style="height:500px;" placeholder="내용을 입력하세요"></textarea>
                      </div>
                    </div>
                                             
                    <div class="line"></div>                    
                    <div class="form-group row">
                      <label class="col-sm-2 form-control-label">파일 첨부</label>
                      <div class="col-sm-8">                  
                        <div class="form-group">
                          <div class="input-group">                           
                            <div class="input-group-append">
                             <input type="text" id="fileName" name="fileName" class="form-control" placeholder="파일명" style="width:500px;" readonly/>                             
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
                      	<button type="submit" class="btn btn-primary" onclick="return isSave();">완료</button>
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
	
		var isFileExtError="";
		
		function isCancel(){
			if(window.confirm("정말로 취소하시겠습니까? 현재 작성하시던 글이 모두 취소됩니다.")){
				return true;
			}else
				return false;
		};
		
		function isSave(){
			
			if($("#name").val()=="" || $("#text").val()=="")
			{
				alert("작성되지 않은 부분이 있습니다.");
				return false;
			}		
			
			if(window.confirm("저장하고 글을 올리시겠습니까?")){
				return true;
			}else
				return false;
		};
		
		
		
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
		
		//권한이 안되면 글쓰기 화면 로드가 안되도록 설정
		$(function(){
			
			if("${sessionScope.member.typeNo}"!=1 && "${sessionScope.member.typeNo}"!=4){
			
				alert("글쓰기 권한이 없습니다.(협력사 직원만 작성이 가능합니다.)");
			
				location.href="/technicalSupportView.do";
			}
		});
				
	
		
	</script>
	
	
	
    <!-- Main File-->
    <script src="/js/front.js"></script>
  </body>
</html>