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
<form action="CheckerServlet" method="post">
	<label for="keywords">キーワード選択:</label>
        <select name="keywords" id="keywords">
            <option value="危険度：大">危険度：大</option>
            <option value="危険度：中">危険度：中</option>
            <option value="危険度：小">危険度：小</option>
        </select>
        <br>
        <input type="submit" value="検索">
</form>
<a href="WelcomeServlet">ログアウト</a>
</body>
</html>