<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	<meta charset="UTF-8">
	<link href="webjars/bootstrap/5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
	<script type="text/javascript" src="webjars/bootstrap/5.1.3/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="webjars/jquery/3.6.0/dist/jquery.js"></script>
	<script type="text/javascript">
		$(function(){
			alert('Hello Webjars');
		});
	</script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<button class="btn btn-primary">부트스트랩 버튼</button>
</body>
</html>
