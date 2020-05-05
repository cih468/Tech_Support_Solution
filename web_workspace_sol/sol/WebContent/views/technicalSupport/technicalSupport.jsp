<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
 	<%@ include file="/layout/head.jsp" %>
 	<script src="//code.jquery.com/jquery.min.js"></script>
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
            <li class="breadcrumb-item"><a href="index.html">Home</a></li>
            <li class="breadcrumb-item active">기술 지원       </li>
          </ul>
        </div>
      </div>
      <section>
        <div class="container-fluid">
          <!-- Page Header-->
          <header> 
            <h1 class="h3 display">기술 지원            </h1>
          </header>
          <div class="row">
            <div class="col-lg-12">
              <div style="text-align:right;">
     			<c:if test="${sessionScope.member.typeNo eq 1 || sessionScope.member.typeNo eq 4}">
          	 		<button onclick="hrefForm();" class="btn btn-primary my-2">글 작성</button>
          	 	</c:if>
          	  </div>
              <div class="card">
                <div class="card-header">
                  <h4>기술 지원 게시판</h4>
                </div>
                <div class="card-body">
                  <div class="table-responsive">	
                    <table class="table table-striped table-sm">
                      <thead>
                        <tr id="check">
                          <th>#</th>
                          <th>제목</th>
                          <th>내용</th>
                          <th>진행상황</th>
                          <th>조회수</th>
                          <th>댓글수</th>
                        </tr>
                      </thead>   
                      <tbody>
                      	<c:forEach var="board" items="${requestScope.pageBoardData.boardList}" varStatus="status">	
                      		<tr id="boardList${status.count}">
                      			<th scope="row">${board.num}</th>
    	                  		<td>${board.name}</td>
        	              		<td id="text${status.count}">        	              		
	        	              		<!-- td에 내용 일정량까지만 추가하는 것 -->
									<script>
										var boardText = "${board.text}";
										document.write(boardText.substring(0,10));									
										$("#text${status.count}").append($("boardText"));
										
										$("#boardList${status.count}").mouseenter(function(){											
											$(this).css("border","outset");				
										});
										
										$("#boardList${status.count}").mouseleave(function(){											
											$(this).css("border","none");				
										});
								
										$("#boardList${status.count}").click(function(){											
											location.href="/technicalSupportOneView.do?boardNo=${board.boardNo}"
										});
						    	    </script>
        	              		</td>
            	          		<td>
            	          			<c:choose>
            	          				<c:when test="${board.stateNo eq 1}">
            	          					신규등록
            	          				</c:when>
            	          				
            	          				<c:when test="${board.stateNo eq 2}">
            	          					본사담당직원 할당완료
            	          				</c:when>
            	          				
            	          				<c:when test="${board.stateNo eq 3}">
            	          					분석 중
            	          				</c:when>
            	          				
            	          				<c:when test="${board.stateNo eq 4}">
            	          					추가 정보요청
            	          				</c:when>
            	          				
            	          				
            	          				<c:when test="${board.stateNo eq 5}">
            	          					피드백 필요
            	          				</c:when>
            	          				
            	          				
            	          				<c:when test="${board.stateNo eq 6}">
            	          					해결완료
            	          				</c:when>
            	          				
            	          			</c:choose>
            	          		</td>
                	      		<td>${board.hits}</td>
                    	  		<td>${board.commentNo}</td>                    	  		
                      		</tr>                      	
                      	</c:forEach>
                      </tbody>
                    </table>
                    <ul class="pagination justify-content-center">
                    	${requestScope.pageBoardData.pageNavi}
                    </ul>
                  </div>
                </div>
              </div>
              <div class="form-group" style="line-height:10px;">
              	<form action = "/search.do" method="get" class="form-inline">
              		<select id="searchSelect" name="searchSelect" class="form-control mb-2 mr-sm-2">
	              		<option value="1">제목</option>
    	          		<option value="2">내용</option>
        	      		<option value="3">진행상황</option>
            	  	</select>            	  	
            	  	
            	  	<select id="searchState" name="searchState" class="form-control mb-2 mr-sm-2" style="display:none;" value="1">
	              		<option value="1">신규등록</option>
    	          		<option value="2">본사직원 할당</option>
        	      		<option value="3">분석 중</option>
        	      		<option value="4">추가 정보요청</option>
        	      		<option value="5">피드백 필요</option>
        	      		<option value="6">해결 완료</option>
            	  	</select>
            	  	
            	  	<input type="hidden" name="boardTypeNo" value="3"/> 	  
              		<input type="text" id="searchText" name="searchText" placeholder="검색어를 입력하세요" class="form-control mb-2 mr-sm-2"/>
              		<button type="submit" class="btn btn-info" style="background-color:dodger-blue;">검색</button>
              	</form>
              </div>
              
            </div>
          </div>
        </div>
      </section>
      <footer class="main-footer">
        <div class="container-fluid">
          <div class="row">
            <div class="col-sm-6">
              <p>Technical Support&copy; 2018-2019</p>
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
 	<%@include file="/layout/javaScriptFile.jsp"%>
    <!-- Main File-->
    <script src="/js/front.js"></script>
    
   	<script>
		function hrefForm(){
			location.href="/views/technicalSupport/technicalSupportCreate.jsp";
		} 	
 	</script>
 	
 	<script>
 		
 		$("#searchSelect").change(function(){
 			if($("#searchSelect").val()==3){
 				$("#searchState").css("display","block");
 				$("#searchText").val("1");
 				$("#searchText").css("display","none");
 			}else{
 				$("#searchState").css("display","none");
 				$("#searchText").css("display","block");
 			}
 		});
 		
 		
 		$("#searchState").change(function(){
 			$("#searchText").val($("#searchState").val());
 		})
 			
 		
 			
 		
 		
 	
 	
 	</script>
    
  </body>
</html>