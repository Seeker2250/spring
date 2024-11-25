<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><tiles:getAsString name="title"/></title>
	<!-- login.css, join.css로 유동적으로 바뀌어야 해 -->
<link href='<tiles:getAsString name="css"/>' type="text/css" rel="stylesheet" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
</head>
<body>
	<!-- header 시작 -->
	<tiles:insertAttribute name="header"></tiles:insertAttribute>
	<!-- header 종료 -->
	<!-- visual 시작 -->
	<tiles:insertAttribute name="visual"></tiles:insertAttribute>
	<!-- visual 종료 -->

	<div id="main">
		<div class="top-wrapper clear">
			<!-- content 시작 -->
			<tiles:insertAttribute name="content"></tiles:insertAttribute>
			<!-- content 종료 -->
			<!-- nav 시작 -->
			<tiles:insertAttribute name="aside"></tiles:insertAttribute>
			<!-- nav 종료 -->
		</div>
	</div>
	<!-- footer 시작 -->
	<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	<!-- footer 종료 -->
	<!-- <script>
document.addEventListener('DOMContentLoaded', function() {
	document.getElementById('joinform').addEventListener('submit', function(e) {
    e.preventDefault();
    alert("되어라");
    console.log("submit 이벤트 발생");  // 이벤트 발생 확인
    
    const year = document.getElementById('year').value;
    const month = document.getElementById('month').value;
    const day = document.getElementById('day').value;
    
    // 값 확인
    console.log('입력값:', year, month, day);
    
    // 값이 비어있는지 체크
    if(!year || !month || !day) {
        alert('생년월일을 모두 입력해주세요');
        return false;
    }
    const formatMonth = month.padStart(2, '0');
    const formatDay = day.padStart(2, '0');
    document.getElementById('birth').value = 
        `${year}-${formatMonth}-${formatDay}`;
    
    // 폼 제출
    this.submit();
});
});
</script> -->
</body>
</html>
