<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/main.css">
<title>ユーザー登録</title>
</head>
<body>
<h1>ユーザー登録</h1>
<div class="center-container">
	<form action="SignUpServlet" method="post" class="right-align">
		ユーザーID:<input type="text" name="userId" placeholder="英数字10文字以下"><br>
		パスワード:<input type="password" name="pass"><br>
		ペットのお名前:<input type="text" name="petName"><br>
		ペットの種類:<input type="text" name="animals"><br>
		ペットの誕生日:<input type="date" name="petBd"><br>
		<input type="submit" value="確認">
		<a href="WelcomeServlet" class="left-align">キャンセル</a>
	</form>
</div>
</body>
</html>