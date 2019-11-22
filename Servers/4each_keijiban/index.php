<!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<title>4each掲示板</title>    
</head>

<link rel="stylesheet" type="text/css" href="style.css"> 
    
<body>
    
<?php 

mb_internal_encoding("utf8");

$pdo = new PDO("mysql:dbname=lesson01;host=localhost;","root","mysql");
$stmt = $pdo->query("select * from 4each_keijiban");
    
?>
    

    <img src="4eachblog_logo.jpg">
    
    <header>
        <ul class="header">
            <li>トップ</li>
            <li>プロフィール</li>
            <li>4eachについて</li>
            <li>登録フォーム</li>
            <li>問い合わせ</li>
            <li>その他</li>
        </ul>
    </header>
    
    <main>
    <div class="left">
    <h1>プログラミングに役立つ掲示板</h1>
        <div class="box">
            <p class="form">入力フォーム</p>
                <form method="post" action="insert.php">
                    <label>ハンドルネーム</label>
                        <input type="text" name="handlename"  class="handlename">
                    <label>タイトル</label>
                        <input type="text" name="title" class="title">
                    <label>コメント</label>
                        <textarea cols="40" rows="4" name="comments" class="comments"></textarea>
            
                    <input type="submit" value="投稿する" class="button">
            
                </form>
        </div>
    
        <?php
    
            foreach ($stmt as $row){
            echo "<div class='box2'>";
            echo "<h2>".$row['title']."</h2>";
            echo "<div class='contents'>";
            echo $row['comments'];
            echo "<div class='handlename'>posted by".$row['handlename']."</div>";
            echo "</div>";
            echo "</div>";
            }
        ?>
        
        
    </div>
    
    <div class="right">
        <h2>人気の記事</h2>
            <ul class="link">
                <li>PHPオススメ本</li>
                <li>PHP Myadminの使い方</li>
                <li>今人気のエディタ Top5</li>
                <li>HTMLの基礎</li>
            </ul>
    
         <h2>オススメリンク</h2>
            <ul class="link">
                <li>インターノウス株式会社</li>
                <li>XAMPPのダウンロード</li>
                <li>Eclipseのダウンロード</li>
                <li>Bracketsのダウンロード</li>
            </ul>
    
         <h2>カテゴリ</h2>
            <ul class="link">
                <li>HTML</li>
                <li>PHP</li>
                <li>MySQL</li>
                <li>JavaScript</li>
            </ul>
    </div>
    </main>
    <footer>
        <p>copyright © internous | 4each blog the which provides A to Z about programming.</p>
    </footer>
</body>