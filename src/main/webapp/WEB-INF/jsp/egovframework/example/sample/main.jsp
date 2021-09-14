<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>
	 <div style="padding-top: 100px;" align="center" >
	 	<h1>환영합니다. 스프링 게시판 입니다.</h1>
	 	<button onclick="location.href='${contextPath}/bList.do'">게시판 보기</button>
	 </div>
</body>
</html>