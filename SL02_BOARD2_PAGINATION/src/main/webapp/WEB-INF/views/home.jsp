<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world! - ${ user }
</h1>
<p>  The time on the server is ${serverTime}. </p>

<h3>
	<a href="/board/list">/board/list 요청</a>
</h3>

</body>
</html>
