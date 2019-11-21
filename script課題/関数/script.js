document.write("■■■問1■■■<br><br>");
function cicleArea(radius){
    return radius * radius * 3.14;
}

var a = 5;
var b = 7;
var c = 10;

document.write("半径" + a + "cm^2の円の面積：");
document.write(cicleArea(a)+ "<br>");
document.write("半径" + b + "cm^2の円の面積：");
document.write(cicleArea(b)+ "<br>");
document.write("半径" + c + "cm^2の円の面積：");
document.write(cicleArea(c));


document.write("<br><br><br><br>■■■問2■■■<br><br>");
function totalPrice(adult,child){
    return adult*500 + child*200;
}

document.write("Aグループの合計金額：" + totalPrice(2,4) + "円です。<br>");
document.write("Bグループの合計金額：" + totalPrice(1,3) + "円です。<br>");
document.write("Cグループの合計金額：" + totalPrice(3,7) + "円です。<br>");



