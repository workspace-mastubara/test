<!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<title>お問い合わせ内容確認</title>
</head>

<link rel="stylesheet" type="text/css" href="confirm.css">
    
    <haeder>
        <h1>お問い合わせ内容確認</h1>
    </haeder>
    
    <main>
        <div class="box">
            
        <p>お問い合わせ内容はこちらで宜しいでしょうか？<br>よろしければ｢送信｣するボタンを押して下さい。</p>
        
        <div class="answer">
        <label>名前</label><br>
        <?php echo $_POST['name']; ?>
        </div>
        
        <div class="answer">
        <label>メールアドレス</label><br>
        <?php echo $_POST['mail']; ?>
        </div>
        
        <div class="answer">
        <label>年齢</label><br>
        <?php echo $_POST['age']; ?>
        </div>
        
        <div class="answer">
        <label>コメント</label><br>
        <?php echo $_POST['comment']; ?>
        </div>
        
        <form action="index.html">
            <input type="submit" value="戻って修正する" class="modify">
        </form>
            
        <form action="insert.php" method="post">                
            <input type="submit" value="登録する" class="regist">
            <input type="hidden" value="<?php echo $_POST["name"]; ?>" name="name">
            <input type="hidden" value="<?php echo $_POST["mail"]; ?>" name="mail">
            <input type="hidden" value="<?php echo $_POST["age"]; ?>" name="age">
            <input type="hidden" value="<?php echo $_POST["comment"]; ?>" name="comment">
        </form>
            
        </div>
        
    </main>
    
    
