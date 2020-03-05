package general;

import static org.junit.Assert.*;

import org.junit.Test;

public class FizzBuzzTest {
	public static class 引数が3と5の倍数でない {
		FizzBuzz fizzBuzz = new FizzBuzz();

		@Test
		public void 引数に1を与えたら1を返す() {
			assertEquals("1", fizzBuzz.response(1));
		}
	}

	public static class 引数が3のみの倍数 {
		FizzBuzz fizzBuzz = new FizzBuzz();

		@Test
		public void 引数に3を与えたらFizzを返す() {
			assertEquals("Fizz", fizzBuzz.response(3));
		}
	}

	public static class 引数が5のみの倍数 {
		FizzBuzz fizzBuzz = new FizzBuzz();

		@Test
		public void 引数に5を与えたらBuzzを返す() {
			assertEquals("Buzz", fizzBuzz.response(5));
		}
	}

	public static class 引数が3と5の倍 {
		FizzBuzz fizzBuzz = new FizzBuzz();

		@Test
		public void 引数に15を与えたらFizzBuzzを返す() {
			assertEquals("FizzBuzz", fizzBuzz.response(15));
		}
	}

	public static class 引数が無効境界値 {
		FizzBuzz fizzBuzz = new FizzBuzz();

		@Test(expected = IndexOutOfBoundsException.class)
		public void 引数に0を与えたらエラーになる() {
			fizzBuzz.response(0);
		}

		@Test(expected = IndexOutOfBoundsException.class)
		public void 引数に101を与えたらエラーになる() {
			fizzBuzz.response(101);
		}
	}

	public static class 引数が有効境界線値 {
		FizzBuzz fizzBuzz = new FizzBuzz();

		@Test
		public void 引数に1を与えたら1を返す() {
			assertEquals("1", fizzBuzz.response(1));
		}

		@Test
		public void 引数に100を与えたらBuzzを返す() {
			assertEquals("Buzz", fizzBuzz.response(100));
		}
	}
}
