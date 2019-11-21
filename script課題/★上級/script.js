document.write("■■■問1■■■<br><br>");

document.write("ココカラ---------<br>");
for (var i = 1; i <= 25; i++){
    if(i % 2 == 1) {
        document.write("★");
        if(i % 5 == 0) {
            document.write("<br>");
        }
    } else {
        if(i % 2 == 0) {
            document.write("☆");
            if(i % 5 == 0) {
                document.write("<br>");
            }
        }
    }
}
document.write("---------ココマデ");


document.write("<br><br><br><br>■■■問2■■■<br><br>");
document.write("ココカラ---------<br>");
for (var i = 1; i <= 25; i++){
    if(i % 6 == 1) {
        document.write("☆");
        if(i % 5 == 0) {
            document.write("<br>");
        }
    } else {
        if(!(i % 6 == 1)) {
            document.write("★");
            if(i % 5 == 0) {
                document.write("<br>");
            }
        }
    }
}
document.write("---------ココマデ");


document.write("<br><br><br><br>■■■問3■■■<br><br>");
document.write("ココカラ---------<br>");

for (var i = 0; i < 5; i++){
    for (var j = 0; j <= i; j++){
        if(j == i){
            document.write("☆");
        } else {
            document.write("★");
        }
    }
    document.write("<br>");
}

document.write("---------ココマデ");

