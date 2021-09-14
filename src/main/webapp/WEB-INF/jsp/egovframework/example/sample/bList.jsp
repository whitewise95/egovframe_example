<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
		<div style="padding-top: 100xp" align="center">
	 	<h1>환영합니다. 스프링 게시판 입니다.</h1>
	 	<table	border="1" style="width: 700px">
	 		<col width="10%">
	 		<col width="40%">
	 		<col width="20%">
	 		<col width="20%">
	 		<col width="10%">	 		
	 		<tr align="left">
	 			<td>번호</td>
	 			<td>제목</td>
	 			<td>작성자</td>
	 			<td>작성일</td>
	 			<td>조회수</td>
	 		</tr>
	 		<c:forEach var="bdto" items="${bdto}">
	 		<tr align="center">
	 			<td>${bdto.num }</td>
	 			<td> <a href="${contextPath }/bInfo.do?num=${bdto.num }">${bdto.subject }</a></td>
	 			<td>${bdto.writer }</td>
	 			<td><fmt:formatDate value="${bdto.regDate }"  pattern="yy-MM-dd"/> </td>
	 			<td>${bdto.readCount }</td>
	 		</tr>
	 		</c:forEach>
	 		<tr>
	 			<td colspan="5" align="center">
	 				<input type="button" value="글쓰기" onclick="location.href='${contextPath}/bWrite.do'">
	 			</td>
	 		</tr>
	 	</table>
	 </div>
</body>
</html>