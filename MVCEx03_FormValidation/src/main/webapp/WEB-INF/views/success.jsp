<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Student Enrollment Detail Confirmation</title>
	<link href="<c:url value='/resources/css/custom.css' />" rel="stylesheet"></link>
</head>
<body>
	<div class="success">
		Confirmation message : ${success}
		<br>
		We have also sent you a confirmation mail to your email address : ${student.email}.
	</div>
</body>
</html>