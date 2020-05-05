<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>	
    <%@include file="/layout/head.jsp" %>
  </head>
  
<body class="bg-light">

    <!-- Side Navbar -->
    <%@include file="/layout/sideNavi.jsp" %>    
    <div class="page">
      <!-- navbar-->
      <%@include file="/layout/header.jsp" %>

    <div class="container">
      <div class="py-5 text-center">
        <img class="d-block mx-auto mb-4" src="/img/logo.png" width="72" height="72">
        <h1>My Page</h1>
        <p class="lead" style="font-size:18px; color:skyblue;">회원정보를 확인하고 수정하세요</p>
      </div>

      <div class="row">
        <div class="col-md-4 order-md-2 mb-4">        
      
      <form action="/withdrawal.do" method="post">
      <div class="input-group">      	
      	<div class="input-group-append">
      		<button type="submit" onclick="return withdrawal();" class="btn btn-secondary">회원 탈퇴</button>
      	</div>
      </div>
      </form>
      
         
         <br><br>
        
        
          <h4 class="d-flex justify-content-between align-items-center mb-3">
            <span class="text-muted">기술공유 게시판 활동내역</span>
            <span class="badge badge-secondary badge-pill">${requestScope.memberSharingActivity.score}</span>
          </h4>
          <ul class="list-group mb-3">
            <li class="list-group-item d-flex justify-content-between lh-condensed">
              <div>
                <h6 class="my-0">올린 게시글 수<h6>
               	 <small class="text-muted">totalSharingCount</small>
              </div>
              <span class="text-muted">#${requestScope.memberSharingActivity.totalSharingCount}</span>
            </li>
            <li class="list-group-item d-flex justify-content-between lh-condensed">
              <div>
                <h6 class="my-0">답변 채택 완료된 글</h6>
                <small class="text-muted">selectedSharingCount</small>
              </div>
              <span class="text-muted">#${requestScope.memberSharingActivity.selectedSharingCount}</span>
            </li>
            <li class="list-group-item d-flex justify-content-between lh-condensed">
              <div>
                <h6 class="my-0">답변 미채택 글</h6>
                <small class="text-muted">unselectedSharingCount</small>
              </div>
              <span class="text-muted">#${requestScope.memberSharingActivity.unselectedSharingCount}</span>
            </li>
     <!--        <li class="list-group-item d-flex justify-content-between bg-light">
              <div class="text-success">
                <h6 class="my-0">Promo code</h6>
                <small>EXAMPLECODE</small>
              </div>
              <span class="text-success">#5</span>
            </li> -->
            <li class="list-group-item d-flex justify-content-between">
              <span>내가 단 댓글  수</span>
              #${requestScope.memberSharingActivity.totalCommentCount}
            </li>
          </ul>
          
          
         
          <br><br>
            <h4 class="d-flex justify-content-between align-items-center mb-3">
            <span class="text-muted">담당중인 기술지원 글 수</span>
            <span class="badge badge-secondary badge-pill">${requestScope.memberTechnicalActivity.totalCount}</span>
          </h4>
          <ul class="list-group mb-3">
	
	        <li class="list-group-item d-flex justify-content-between lh-condensed">
              <div>
                <h5 class="my-0">신규등록<h5>
              </div>
              <span class="text-muted">#${requestScope.memberTechnicalActivity.newRegistration}</span>
            </li>
            
            <li class="list-group-item d-flex justify-content-between lh-condensed">
              <div>
                <h5 class="my-0">담당직원 할당<h5>
              </div>
              <span class="text-muted">#${requestScope.memberTechnicalActivity.assignEngineer}</span>
            </li>
            
          
            <li class="list-group-item d-flex justify-content-between lh-condensed">
              <div>
                <h5 class="my-0">분석중<h5>
              </div>
              <span class="text-muted">#${requestScope.memberTechnicalActivity.analyzing}</span>
            </li>
            <li class="list-group-item d-flex justify-content-between lh-condensed">
              <div>
                <h5 class="my-0">추가 정보 요청</h5>
              </div>
              <span class="text-muted">#${requestScope.memberTechnicalActivity.requestInforation}</span>
            </li>
            <li class="list-group-item d-flex justify-content-between lh-condensed">
              <div>
                <h5 class="my-0">피드백 필요</h5>
              </div>
              <span class="text-muted">#${requestScope.memberTechnicalActivity.needFeedBack}</span>
            </li>
            <li class="list-group-item d-flex justify-content-between bg-light">
              <div class="text-success">
                <h5 class="my-0">해결 완료</h5>
              </div>
              <span class="text-success">#${requestScope.memberTechnicalActivity.resolved}</span>
            </li>
            <!-- <li class="list-group-item d-flex justify-content-between">
              <span>해결 완료</span>
              #${requestScope.memberSharingActivity.totalCommentCount}
            </li> -->
          </ul>
        
          

         
        </div>
        <div class="col-md-8 order-md-1">
          <h4 class="mb-3">My Info</h4>
          <form action="/changeInfo.do" method="post" class="needs-validation">
            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="companyType">Company Type</label>
                <input type="text" class="form-control" id="companyType" value= <c:if test="${sessionScope.member.typeNo gt 1}">제조사</c:if>
                																<c:if test="${sessionScope.member.typeNo eq 1}">협력사</c:if> readonly>
                <div class="invalid-feedback">                
                </div>
              </div>
              <div class="col-md-6 mb-3">
                <label for="companyName">Company Name</label>
                <input type="text" class="form-control" id="companyName" value="${sessionScope.member.company}" readonly>
                <div class="invalid-feedback">
                </div>
              </div>
            </div>

            <div class="mb-3">
              <label for="username">Username</label>
              <div class="input-group">
                <div class="input-group-prepend">
                  <span class="input-group-text">§</span>
                </div>
                <input type="text" value="${sessionScope.member.userName}" class="form-control" id="username" readonly>
                <div class="invalid-feedback" style="width: 100%;">                 
                </div>
              </div>
            </div>

            <div class="mb-3">
              <label for="email">Email <span class="text-muted"></span></label>
              <input type="email" value="${sessionScope.member.email }" class="form-control" id="email" name="email" readonly>
              <div class="invalid-feedback">
                Please enter a valid email address for shipping updates.
              </div>
            </div>

            <div class="mb-3">
              <label for="phone">Phone</label>
              <input type="text" value="${sessionScope.member.phone}"class="form-control" id="phone" name="phone" placeholder="전화번호를 입력하세요" required>
              <div class="invalid-feedback">
                Please enter your phone number.
              </div>
            </div>

            <div class="mb-3">
              <label for="passowrd">비밀번호 <span class="text-muted"></span></label>
              <input type="password" value="${sessionScope.member.password}" class="form-control"  id="password" name="password" placeholder="비밀번호를 입력하세요">              
            </div>
            
            <div class="mb-3">
              <label for="password2">비밀번호 확인  <span class="text-muted"></span></label>
              <input type="password"  value="${sessionScope.member.password}" class="form-control" id="password2" placeholder="비밀번호를 다시 한 번 입력해주세요">
              <p style="font-size:12px; color:red;" id="passCheckFail"></p>              
            </div>

            <div class="mb-3">
              <label for="password2">가입일시<span class="text-muted"></span></label>
              <input type="text"  value="${sessionScope.member.enrollDate}" class="form-control" id="enrollDate" readonly>	              
            </div>
            <hr class="mb-4">
                     
            <button style="float:left; height:50px; width:90%"class="btn btn-primary btn-lg btn-block" type="submit" onclick="return pwCheck();">회원 정보 변경</button>
            <button style="float:left; height:50px; width:10%" class="btn btn btn-secondary" type="reset">Reset</button>
          </form>
        </div>
      </div>

      <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">&copy; 2018-2019 Technical Support</p>
        <ul class="list-inline">
          <li class="list-inline-item"><a href="#">Privacy</a></li>
          <li class="list-inline-item"><a href="#">Technical</a></li>
          <li class="list-inline-item"><a href="#">Support</a></li>
        </ul>
      </footer>
    </div>

	</div>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="../../assets/js/vendor/popper.min.js"></script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <script src="../../assets/js/vendor/holder.min.js"></script>    
    
    <!-- JavaScript files-->
    <%@include file="/layout/javaScriptFile.jsp"%>
    
    <!-- JavaScript 이용하여 비밀번호와 비밀번호 확인 같은지 검사 -->
    <script>
    	function pwCheck(){
    		var password = $("#password").val();
    		var password2 = $("#password2").val();
    		
    		console.log(password);
    		console.log(password2);
    		
    		if(password==password2){
    			return true;
    		}else{
    			
    			
    			$("#passCheckFail").html("비밀번호 확인이 일치하지 않습니다.");
    			
    			return false;
    		}
    	};	
    	
    	function withdrawal(){
    		if(window.confirm("정말로 탈퇴하시겠습니까? 확인을 누르면 탈퇴가 완료됩니다.")){
    			alert("탈퇴가 완료되었습니다.");
    			return true;
    		}else{
    			return false;
    		}
    		
    		
    	}
    
    
    </script>
    
    
    
    <!-- Main File-->
    <script src="/js/front.js"></script>        
    </body>
</html>
    