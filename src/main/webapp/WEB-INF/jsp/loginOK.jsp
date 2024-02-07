<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/main.css">
<title>誤飲チェッカー</title>
<script>
    // カテゴリが変更された時に呼び出される関数
    function updateKeywords() {
        // 選択されたカテゴリの値を取得
        var selectedCategory = document.getElementById("category").value;

        // カテゴリに基づいてキーワードのセレクトボックスを更新
        var keywordsSelect = document.getElementById("keywords");
        keywordsSelect.innerHTML = "";  // 一旦リセット

        if (selectedCategory === "category1") {
            // 食品に関連するキーワードを追加
            var option1 = document.createElement("option");
            option1.value = "red";
            option1.text = "チョコレート";
            keywordsSelect.add(option1);

            var option2 = document.createElement("option");
            option2.value = "yellow";
            option2.text = "みかん";
            keywordsSelect.add(option2);

            var option3 = document.createElement("option");
            option3.value = "green";
            option3.text = "ささみ";
            keywordsSelect.add(option3);

            var option4 = document.createElement("option");
            option4.value = "green";
            option4.text = "納豆";
            keywordsSelect.add(option4);

            var option5 = document.createElement("option");
            option5.value = "green";
            option5.text = "サツマイモ";
            keywordsSelect.add(option5);

            var option6 = document.createElement("option");
            option6.value = "red";
            option6.text = "生魚";
            keywordsSelect.add(option6);

            var option7 = document.createElement("option");
            option7.value = "red";
            option7.text = "ブドウ";
            keywordsSelect.add(option7);

            var option7 = document.createElement("option");
            option7.value = "red";
            option7.text = "ねぎ類";
            keywordsSelect.add(option7);

            var option8 = document.createElement("option");
            option8.value = "red";
            option8.text = "レーズン";
            keywordsSelect.add(option8);

            var option9 = document.createElement("option");
            option9.value = "red";
            option9.text = "アボカド";
            keywordsSelect.add(option9);

            var option10 = document.createElement("option");
            option10.value = "yellow";
            option10.text = "チーズ";
            keywordsSelect.add(option10);
            
        } else if (selectedCategory === "category2") {
            // 液体に関連するキーワードを追加
        	var option1 = document.createElement("option");
            option1.value = "red";
            option1.text = "コーヒー";
            keywordsSelect.add(option1);

            var option2 = document.createElement("option");
            option2.value = "red";
            option2.text = "牛乳";
            keywordsSelect.add(option2);

            var option3 = document.createElement("option");
            option3.value = "red";
            option3.text = "ココア";
            keywordsSelect.add(option3);

            var option4 = document.createElement("option");
            option4.value = "red";
            option4.text = "醤油";
            keywordsSelect.add(option4);
            
        }else if (selectedCategory === "category3") {
            // その他のキーワードを追加
        	var option1 = document.createElement("option");
            option1.value = "red";
            option1.text = "たばこ";
            keywordsSelect.add(option1);

            var option2 = document.createElement("option");
            option2.value = "red";
            option2.text = "布類、ひも等";
            keywordsSelect.add(option2);

            var option3 = document.createElement("option");
            option3.value = "yellow";
            option3.text = "髪の毛";
            keywordsSelect.add(option3);

        }
    }
</script>
</head>
<body>
<h1>ペット誤飲チェッカー</h1>
<p>ようこそ<c:out value="${userId}"/>さん、<c:out value="${petName}"/>ちゃん</p>
<p>誕生日:<c:out value="${petBd}"/></p>
<p>年齢:<c:out value="${ageYears}"/>歳<c:out value="${ageMonth}"/>か月</p>
<form action="CheckerServlet" method="post">
    <label for="category">種類選択:</label>
    <select name="category" id="category" onchange="updateKeywords()">
    	<option value="choice">カテゴリを選択してください</option>
        <option value="category1">食品</option>
        <option value="category2">液体</option>
        <option value="category3">その他</option>
    </select>
    <br>
    <label for="keywords">キーワード選択:</label>
    <select name="keywords" id="keywords"></select>
    <br>
    <input type="submit" value="検索">
</form>
<a href="WelcomeServlet">ログアウト</a>
</body>
</html>