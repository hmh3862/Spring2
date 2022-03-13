<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>뉴스 읽기</title>
</head>
<body>
	<h2>${rss.channel.title }</h2>
	${rss.channel.description }
	<hr />
	<c:forEach var="item" items="${rss.channel.item }">
	
		<a href="${item.link }">${item.title }(${item.author })</a> <br />
		${item.description }
		<c:if test="${not empty item.image }">
			<img src="${item.image }" alt="${item.image }" />
		</c:if>
		<hr />
		
	</c:forEach>
</body>
</html>