<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/main.css">
<title>誤飲チェッカー</title>
</head>
<body>
<h1>ログイン</h1>
<div class="center-container">
	<form action="LoginServlet" method="post">
		ユーザーID:<input type="text" name="userId"><br>
		パスワード:<input type="password" name="pass"><br>
		<input type="submit" value="ログイン">
		<a href="WelcomeServlet">キャンセル</a>
	</form>
</div>
</body>
</html>