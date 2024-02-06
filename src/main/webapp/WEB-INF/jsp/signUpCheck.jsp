<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate, java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/main.css">
<title>ユーザー登録確認</title>
</head>
<body>
<h1>ユーザー登録確認</h1>
    
    <%-- セッションスコープからデータを取得 --%>
    <% String userId = (String) session.getAttribute("userId"); %>
    <% String pass = (String) session.getAttribute("pass"); %>
    <% String petName = (String) session.getAttribute("petName"); %>
    <% String animals = (String) session.getAttribute("animals"); %>
    <% LocalDate petBd = (LocalDate) session.getAttribute("petBd"); %>

    <%-- データを表示 --%>
    <p>ユーザーID: <%= userId %></p>
    <p>パスワード: <%= pass %></p>
    <p>ペットのお名前: <%= petName %></p>
    <p>ユーザーID: <%= animals %></p>
    <p>ペットの誕生日: <%= petBd.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) %></p>

    <%-- 他の表示や処理を追加 --%>
    <form action="SignUpResultServlet" method="post">
        <input type="submit" value="登録">
    </form>
</body>
</html>