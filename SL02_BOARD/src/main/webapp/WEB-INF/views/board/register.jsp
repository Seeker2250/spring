<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  register.jsp입니당
  name속성, VO의 이름, DB의 컬럼명은 일치해야 해 
  	VO에는 setter가 있어야 하니까 getter와 setter는 필수적이고, 그래서 @Data 쓰는거야
  </xmp>
  <form action="/board/register" method="post">
  <!-- name속성, VO의 이름, DB의 컬럼명은 일치해야 해 
  	   VO에는 setter가 있어야 하니까 getter와 setter는 필수적이고, 그래서 @Data 쓰는거야-->
     <table>  
       <tbody>
         <tr>
           <th>제목</th>
           <td><input type="text" name="title" class="full" autofocus="autofocus"></td>        
         </tr> 
         <tr>
           <th>내용</th>
           <td><textarea  name="content" class="full"></textarea></td>        
         </tr> 
         <tr>
           <th>작성자</th>
           <td><input type="text" name="writer" class="short"></td>        
         </tr>  
       </tbody> 
       <tfoot>
         <tr>
           <td colspan="2">
             <button type="submit">Submit</button>
             <button type="reset">Reset</button>
             <button type="button" class="back" onclick="history.back();">back</button>
           </td>
         </tr>
       </tfoot>
     </table>
     
     <input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
       
  </form>
</div> 
</body>
</html>







 

