<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="insertOk" method="post">
		<input type="hidden" name="p" value="5">
		<input type="hidden" name="s" value="10">
		<input type="hidden" name="b" value="10">
		<input type="hidden" name="idx" value="0">
		<input type="hidden" name="m" value="1">
		이름 : <input type="text" name="name" required="required" placeholder="이름입력"/> <br />
		비번 : <input type="password" name="password" required="required" placeholder="비번입력"/> <br />
		내용 : <input type="text" name="content" required="required" placeholder="내용입력" size="80"/> <br />
		<input type="hidden" name="ip" value="${pageContext.request.remoteAddr }">
		<input type="submit" value="저장" />
	</form>
</body>
</html>