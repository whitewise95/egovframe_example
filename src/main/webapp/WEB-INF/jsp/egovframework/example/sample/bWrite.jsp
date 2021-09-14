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
	 	<form action="${contextPath }/bWritePro.do" method="post">
	 		<table border="1" style="width: 700px">
	 			<tr>
	 				<td>제목</td>
	 				<td><input type="text" name="subject" id="subject"></td>
	 			</tr>
	 			<tr>
	 				<td>작성자</td>
	 				<td><input type="text" name="writer" id="writer"></td>
	 			</tr>
	 			<tr>
	 				<td>패스워드</td>
	 				<td><input type="password" name="password"  id="password"></td>
	 			</tr>
	 			<tr>
	 				<td>글내용</td>
	 				<td><textarea rows="20" cols="50" name="content"  id="content"></textarea></td>
	 			</tr>
	 			<tr>
	 				<td colspan="2">
	 					<input type="submit" value="글쓰기">
	 					<input type="reset" value="다시쓰기">
	 					<input type="button" value="목록보기" onclick="location.href='${contextPath}/bList.do'">
	 				</td>
	 			</tr>
	 		</table>
	 	</form>
	 </div>
</body>
</html>