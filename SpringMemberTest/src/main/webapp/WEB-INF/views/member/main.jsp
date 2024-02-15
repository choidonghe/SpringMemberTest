<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>/member/main.jsp</h1>
	
	<c:if test="${empty id }">
		  <c:redirect url="/member/login"/>
	</c:if>
	
	${id}님 환영합니다. <br>
	
	<input type="button" value="로그아웃" onclick="location.href='/member/logout';">
	
	<hr>
	
	<h3><a href=/member/info> 회원정보 조회</a></h3>
	
	<h3><a href=/member/update>회원정보 수정</a></h3>
	
	<h3><a href=/member/delete>회원정보 삭제</a></h3>
	
	<c:if test="${!empty id && id.equals('admin')}">
	<h3><a href=/member/list>회원정보 목록</a></h3>
	</c:if>
	
	
	
	
</body>
</html>