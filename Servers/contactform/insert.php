<?php
mb_internal_encoding("utf8");

 $pdo = new PDO("mysql:dbname=lesson02;host=localhost;","root","mysql");
 
$pdo->exec("insert into contactform(name,mail,age,comments)
values('".$_POST['name']."','".$_POST['mail']."','".$_POST['age']."','".$_POST['comment']."');");
?>

<!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<title>お問い合わせフォームを作る</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
    
<body>
    <h1>お問い合わせフォーム</h1>
    
    <div>
        <p>
        お問い合わせ有難うございました。<br>3営業日以内に担当者よりご連絡差し上げます。
        </p>
    </div>
</body>
    
</html>
