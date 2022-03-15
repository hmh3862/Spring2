<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름 : ${name } <br />
	나이 : ${age } <br /><hr />
	
	이름 : ${sessionScope.name } <br />
	나이 : ${sessionScope.age } <br /><hr />
	
	이름 : ${requestScope.name } <br />
	나이 : ${requestScope.age } <br /><hr />
</body>
</html>