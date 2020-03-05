package general;

public class FizzBuzz {
	public String response(int num) {
		String res = "";
		for (int i = 1; i <= 100; i++) {
			if (i % 15 == 0) {
				res = "FizzBuzz";
			} else if (i % 3 == 0) {
				res = "Fizz";
			} else if (i % 5 == 0) {
				res = "Buzz";
			} else {
				res = String.valueOf(i);
			}
			System.out.println(res);
		}
		return res;
	}
}

//このプログラム言語を選択したのはなぜですか。
//　御社の求人表の開発言語にjavaとC#の記載があり、経験のあるjavaを選択しました。

//作成時に工夫したこと、苦労した点は何ですか。
//　工夫した点：System.out.printlnを何度も使用せず、変数resの値を更新することでforブロックの後に処理した点
//　苦労した点：Testコードの予想が立たず、調べながらコードを書いた点

//作成時に参考にしたものがあれば記載してください。
//　URL：https://qiita.com/tentom/items/80357538f023be61b483