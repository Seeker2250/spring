<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="/resources/images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/resources/cdn-main/example.css">
<script src="/resources/cdn-main/example.js"></script>
<style>
 span.material-symbols-outlined{
    vertical-align: text-bottom;
 }  
</style>
</head>
<body>
<header>
  <h1 class="main"><a href="#" style="position: absolute;top:30px;">Seeker Home</a></h1>
  <ul>  
    <li><a href="#">로그인</a></li>
    <li><a href="#">회원가입</a></li>
  </ul>
</header>
<div>
  <xmp class="code"> 
  list.jsp입니당
  </xmp>
  
  <table>
  	<caption style="text-align: right;">
  		<a href="/board/register"> 글쓰기</a>
  	</caption>
  	<thead>
         <tr>
           <th>#번호</th>
           <th>제목</th>
           <th>작성자</th>
           <th>작성일</th>
           <th>수정일</th>        
         </tr>
      </thead>
      <tbody>
      	<c:choose>
      		<c:when test="${empty list}">
      			<tr>
      				<td colspan="5">게시글 없어용 ㅠㅠ</td>
      			</tr>
      		</c:when>
      		<c:otherwise>
      			<c:forEach items="${list}" var="board">
      				<tr>
      					<td><c:out value="${board.bno}"/></td>
      					<%-- <td><a href="/board/get?bno=${board.bno}"><c:out value="${board.title }"/></a></td> --%>
      					<%--<td><a href="/board/get/${board.bno}"><c:out value="${board.title }"/></a></td>--%><!-- url속에 번호 가져가기 -->
      					<td><a class="move" href="${board.bno}"><c:out value="${board.title }"/></a></td>
      					<td><c:out value="${board.writer}"/></td>
      					<td><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd"/></td>
      					<td><fmt:formatDate value="${board.updatedate}" pattern="yyyy-MM-dd"/></td>
      				</tr>
      				
      				
      			</c:forEach>
      		</c:otherwise>
      	</c:choose>
      </tbody>
      
      <!-- 검색 부분  -->
      <tr>
      	<td colspan="5" align="center">
      	<form id="searchForm" action="/board/list" method="get">
      		<select id="type" name="type">
      			<option value="T">제목</option>
                <option value="C">내용</option>
                <option value="W">작성자</option>
                <option value="TC">제목 or 내용</option>
                <option value="TW">제목 or 작성자</option>
                <option value="TWC">제목 or 작성자 or 내용</option>
      		</select>
      		<input type="text" name="keyword" style="padding: 7px" <c:out value="${pageMaker.criteria.keyword}"/>>
      		<button type="button" style="min-height:32px">Search</button>
      		
      		<input type="hidden" name="pageNum" value="${pageMaker.criteria.pageNum}">
            <input type="hidden" name="amount" value="${pageMaker.criteria.amount}">
      	</form>
      	</td>
      </tr>
      
      <tfoot>
      	<tr>
      		<td colspan="5">
      			<div class="center">
      				<div class="pagination">
      					<c:if test="${pageMaker.prev}">
      						<a href="${pageMaker.startPage - 1}">&laquo;</a>
      					</c:if>
      					<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" step="1" var="num">
      						<a href="${num}" class='${num eq pageMaker.criteria.pageNum ? "active" : "" }'>${num}</a>
      					</c:forEach>
      					<c:if test="${pageMaker.next}">
      						<a href="${pageMaker.endPage + 1}">&raquo;</a>
      					</c:if>
      				</div><!-- pagination -->
      			</div><!-- center -->
      		</td>
      	</tr>
      </tfoot>
  </table>  
  <form id="actionForm" action="/board/list" method="get">
  	<input type="hidden" name="pageNum" value="${pageMaker.criteria.pageNum }">
  	<input type="hidden" name="amount" value="${pageMaker.criteria.amount }">
  	<!-- 검색조건 검색어 -->
  	<input type="hidden" name="type" value="${pageMaker.criteria.type}">
  	<input type="hidden" name="keyword" value ='<c:out value="${pageMaker.criteria.keyword}"/>'>
  	
  </form>
  
  <script type="text/javascript">
  //rttr.addFlashAttribute("result", board.getBno());
 	$(function(){
 		var result = '<c:out value="${result}"/>';
 		checkModal(result);
 		
 		//뒤로가기 하면 history 객체 비워버리기(뒤로가기 방지)
 		history.replaceState({}, null, null);
 		
 		function checkModal(result) {
 		    if(result === '' || history.state) return;
 		    if(parseInt(result) > 0){
 		        alert(`\${result} 번 글이 등록되었습니다.`);
 		    }
 		    if(result === 'SUCCESS'){  // 삭제 완료 처리 추가
 		        alert("삭제 완료!!!");
 		    }
 		}//checkModal
 		
 		
 		//1) paging block, 1 2 [3] 4 5 6 7 8 9 10 > 에서 번호 클릭할 때 이동
 		$(".pagination a").on("click", function (event){
 			event.preventDefault();
 			let pageNum = $(this).attr("href");//페이지 번호 들어가있어
 			//form 안에는 pageNum, amount 들어가있지
 			
 			/* actionForm
 	        .find("input[name='pageNum']")
 	        .val(pageNum);//여기서 submit하면 그냥 찾은 hidden tag가 submit 돼
 	    
 	    	actionForm.submit(); */
 	    	
 	    	 actionForm
 	        .find("input[name='bno']").remove()  // bno input 제거
 	        .end()
 	        .find("input[name='pageNum']")
 	        .val(pageNum)
 	        .end()
 	        .attr("action", "/board/list")  // action 원래대로
 	        .submit();
 	    	
 			/* actionForm
 	        .find("input[name='pageNum']")
 	        .val(pageNum)
 	        .end()
 	        .submit(); */
 	    	
 		})
 		
 		//2) 특정 페이지의 게시글 클릭하고 그 글 본 뒤에 클릭했던 곳으로 돌아와
		//   제목 클릭해서 상세보기 페이지로 이동할 때 pageNum, amount
	    //   상세보기에 있는 목록으로 이동하는 버튼 클릭할 때 그 해당 페이지로 이동
	    
	    // 파라미터에 다 싣고 가도 되겠지만 form 안에 hidden으로 두고 관리하자는거야
	    // 왜냐! ? 뒤에 파라미터 계속 다는 것보다 form 안에서 관리하는 게 나으니까!
		// 이러면 파라미터엔 bno만 있어도 되잖아	    		
	    
	    var actionForm=$("#actionForm");
 		
 		$("a.move").on("click", function(event){
 			event.preventDefault();
 			let bno = $(this).attr("href");//bno 들어가있을거야
 			actionForm//action에 /board/list 있으니까 바꿔
	 			.find("input[name='bno']").remove()  // 기존 bno input 제거
	 	        .end()
 				.attr("action", "/board/get")
 				.append(`<input type="hidden" name="bno" value="\${bno}">`)
 				.submit();//이것만 하면 페이지 번호, 수량은 가져가는데 글 번호는 안 가져가 그래서 위의 append 쓴 것
 		});//click
	    
 		
 		//[검색버튼 클릭할 때 클릭 이벤트 처리]
 		var searchForm = $("#searchForm");
 		$("#searchForm button").on("click", function (event){ 
 			
 			if(!searchForm.find("input[name=keyword]").val()){
 				alert("검색어(keyword)를 입력하세요");
 				return false;
 			}//if
 			searchForm.find(":hidden[name='pageNum']").val("1");
 			event.preventDefault();
 			searchForm.submit();
 		});//click
 		
 		//검색 조건 상태관리
 		$("#type").val('${empty param.type ? "T" : param.type}');
 		
 	})//document.ready
  
  </script>
</div> 
</body>
</html>







 

