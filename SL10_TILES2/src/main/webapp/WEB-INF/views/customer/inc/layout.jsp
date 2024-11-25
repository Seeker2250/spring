<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title><tiles:getAsString name="title"/></title>
		<link href="notice.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
	
		<!-- header 시작 -->
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
		<!-- header 종료 -->
		<!-- visual 시작 -->
		<tiles:insertAttribute name="visual"></tiles:insertAttribute>
		<!-- visual 종료 -->
		<!-- main 시작 -->
		<!-- main 종료 -->
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
		</body>
</html>
