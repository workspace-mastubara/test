package jp.co.internous.action;

public class Test {

	public static void main(String[] args) {

		Person taro = new Person();
		taro.name = "山田太郎";
		taro.age = 20;
		taro.phoneNumber = "090-1234-5678";
		taro.address = "taro@gmail.com";

		System.out.println(taro.name);
		System.out.println(taro.age);
		System.out.println(taro.phoneNumber);
		System.out.println(taro.address);
		taro.talk();
		taro.walk();
		taro.run();


		Person ziro = new Person();
		ziro.name = "木村次郎";
		ziro.age = 18;
		ziro.phoneNumber = "090-2345-6789";
		ziro.address = "ziro@gmail.com";

		System.out.println(ziro.name);
		System.out.println(ziro.age);
		System.out.println(ziro.phoneNumber);
		System.out.println(ziro.address);
		ziro.talk();
		ziro.walk();
		ziro.run();


		Person hanako = new Person();
		hanako.name = "鈴木花子";
		hanako.age = 16;
		hanako.phoneNumber = "090-3456-7890";
		hanako.address = "hanako@gmail.com";

		System.out.println(hanako.name);
		System.out.println(hanako.age);
		System.out.println(hanako.phoneNumber);
		System.out.println(hanako.address);
		hanako.talk();
		hanako.walk();
		hanako.run();


		Person yumea = new Person();
		yumea.name = "松原夢亜";
		yumea.age = 23;
		yumea.phoneNumber = "090-4567-8901";
		yumea.address = "yumea@gmail.com";

		System.out.println(yumea.name);
		System.out.println(yumea.age);
		System.out.println(yumea.phoneNumber);
		System.out.println(yumea.address);
		yumea.talk();
		yumea.walk();
		yumea.run();


		Robot aibo = new Robot();
		aibo.name = "aibo";

		aibo.talk();
		aibo.walk();
		aibo.run();


		Robot asimo = new Robot();
		asimo.name = "asimo";

		asimo.talk();
		asimo.walk();
		asimo.run();


		Robot pepper = new Robot();
		pepper.name = "pepper";

		pepper.talk();
		pepper.walk();
		pepper.run();


	}

}
