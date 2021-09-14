<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
 	<div style="padding-top: 100px;" align="center" >
 		<table border="1" style="width: 700px">
 			<tr>
 				<td>제목</td>
 				<td>${bd.subject }</td>
 			</tr>
 			<tr>
 				<td>작성자</td>
 				<td>${bd.writer }</td>
 			</tr>
 			<tr>
 				<td>작성일</td>
 				<td>${bd.regDate }</td>
 			</tr>
 			<tr>
 				<td>조회수</td>
 				<td>${bd.readCount}</td>
 			</tr>
 			<tr>
 				<td>글내용</td>
 				<td>${bd.content }</td>
 			</tr>
 			<tr>
 				<td colspan="2">
 					
 					<input type="button" value="수정하기" onclick="location.href='${contextPath}/bUpdate.do?num=${bd.num }'">
 					<input type="button" value="삭제하기" onclick="location.href='${contextPath}/bDelete.do?num=${bd.num }'">
 					<input type="button" value="목록보기" onclick="location.href='${contextPath}/bList.do'">
 				</td>
 			</tr>
 		</table>
 	</div>
</body>
</html>