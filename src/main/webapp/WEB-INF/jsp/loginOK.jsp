<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>誤飲チェッカー</title>
</head>
<body>
<p>ようこそ<c:out value="${userId}"/>さん</p>
<p><c:out value="${petName}"/>ちゃん</p>
<p><c:out value="${petBd}"/></p>
<p><c:out value="${ageYears}"/>歳<c:out value="${ageMonth}"/>か月</p>
<a href="WelcomeServlet">トップへ</a>
</body>
</html>