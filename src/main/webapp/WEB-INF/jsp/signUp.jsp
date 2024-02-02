<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
</head>
<body>
<form action="SignUpServlet" method="post">
ユーザーID:<input type="text" name="userId"><br>
ペットのお名前:<input type="text" name="petName"><br>
ペットの種類:<input type="text" name="animals"><br>
ペットの誕生日:<input type="date" name="petBd"><br>
パスワード:<input type="password" name="pass"><br>
<input type="submit" value="確認">
</form>
</body>
</html>