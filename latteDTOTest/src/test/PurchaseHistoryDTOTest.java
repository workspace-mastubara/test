package test;

public class PurchaseHistoryDTOTest {
	// test String setImageFileName()
		@Test
		public void test_setImageFileName_null() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = null;

			dto.setImageFileName(expected);
			String actual = dto.getImageFileName();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setImageFileName_emptyCharacter() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "";

			dto.setImageFileName(expected);
			String actual = dto.getImageFileName();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setImageFileName_space() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = " ";

			dto.setImageFileName(expected);
			String actual = dto.getImageFileName();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setImageFileName_fullSpace() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "　";

			dto.setImageFileName(expected);
			String actual = dto.getImageFileName();
			assertEquals(expected,actual);
		}

		@Test
		public void test_setImageFileName_alphabeticCharacters() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "abc";

			dto.setImageFileName(expected);
			String actual = dto.getImageFileName();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setImageFileName_halfWidthDigit() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "123";

			dto.setImageFileName(expected);
			String actual = dto.getImageFileName();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setImageFileName_hiragana() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "てすと";

			dto.setImageFileName(expected);
			String actual = dto.getImageFileName();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setImageFileName_katakana() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "テスト";

			dto.setImageFileName(expected);
			String actual = dto.getImageFileName();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setImageFileName_kanji() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "漢字";

			dto.setImageFileName(expected);
			String actual = dto.getImageFileName();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setImageFileName_all() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "漢字 テスト　てすと123abc";

			dto.setImageFileName(expected);
			String actual = dto.getImageFileName();
			assertEquals(expected,actual);
		}

		// test String getReleaseCompany()
		@Test
		public void test_getReleaseCompany_null() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = null;

			dto.setReleaseCompany(expected);
			String actual = dto.getReleaseCompany();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getReleaseCompany_emptyCharacter() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "";

			dto.setReleaseCompany(expected);
			String actual = dto.getReleaseCompany();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getReleaseCompany_space() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = " ";

			dto.setReleaseCompany(expected);
			String actual = dto.getReleaseCompany();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getReleaseCompany_fullSpace() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "　";

			dto.setReleaseCompany(expected);
			String actual = dto.getReleaseCompany();
			assertEquals(expected,actual);
		}

		@Test
		public void test_getReleaseCompany_alphabeticCharacters() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "abc";

			dto.setReleaseCompany(expected);
			String actual = dto.getReleaseCompany();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getReleaseCompany_halfWidthDigit() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "123";

			dto.setReleaseCompany(expected);
			String actual = dto.getReleaseCompany();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getReleaseCompany_hiragana() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "てすと";

			dto.setReleaseCompany(expected);
			String actual = dto.getReleaseCompany();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getReleaseCompany_katakana() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "テスト";

			dto.setReleaseCompany(expected);
			String actual = dto.getReleaseCompany();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getReleaseCompany_kanji() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "漢字";

			dto.setReleaseCompany(expected);
			String actual = dto.getReleaseCompany();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getReleaseCompany_all() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "漢字 テスト　てすと123abc";

			dto.setReleaseCompany(expected);
			String actual = dto.getReleaseCompany();
			assertEquals(expected,actual);
		}

		// test String setReleaseCompany()
		@Test
		public void test_setReleaseCompany_null() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = null;

			dto.setReleaseCompany(expected);
			String actual = dto.getReleaseCompany();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setReleaseCompany_emptyCharacter() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "";

			dto.setReleaseCompany(expected);
			String actual = dto.getReleaseCompany();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setReleaseCompany_space() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = " ";

			dto.setReleaseCompany(expected);
			String actual = dto.getReleaseCompany();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setReleaseCompany_fullSpace() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "　";

			dto.setReleaseCompany(expected);
			String actual = dto.getReleaseCompany();
			assertEquals(expected,actual);
		}

		@Test
		public void test_setReleaseCompany_alphabeticCharacters() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "abc";

			dto.setReleaseCompany(expected);
			String actual = dto.getReleaseCompany();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setReleaseCompany_halfWidthDigit() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "123";

			dto.setReleaseCompany(expected);
			String actual = dto.getReleaseCompany();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setReleaseCompany_hiragana() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "てすと";

			dto.setReleaseCompany(expected);
			String actual = dto.getReleaseCompany();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setReleaseCompany_katakana() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "テスト";

			dto.setReleaseCompany(expected);
			String actual = dto.getReleaseCompany();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setReleaseCompany_kanji() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "漢字";

			dto.setReleaseCompany(expected);
			String actual = dto.getReleaseCompany();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setReleaseCompany_all() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "漢字 テスト　てすと123abc";

			dto.setReleaseCompany(expected);
			String actual = dto.getReleaseCompany();
			assertEquals(expected,actual);
		}

		// test String getReleaseDate()
		@Test
		public void test_getReleaseDate_null() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = null;

			dto.setReleaseDate(expected);
			String actual = dto.getReleaseDate();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getReleaseDate_emptyCharacter() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "";

			dto.setReleaseDate(expected);
			String actual = dto.getReleaseDate();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getReleaseDate_space() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = " ";

			dto.setReleaseDate(expected);
			String actual = dto.getReleaseDate();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getReleaseDate_fullSpace() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "　";

			dto.setReleaseDate(expected);
			String actual = dto.getReleaseDate();
			assertEquals(expected,actual);
		}

		@Test
		public void test_getReleaseDate_alphabeticCharacters() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "abc";

			dto.setReleaseDate(expected);
			String actual = dto.getReleaseDate();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getReleaseDate_halfWidthDigit() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "123";

			dto.setReleaseDate(expected);
			String actual = dto.getReleaseDate();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getReleaseDate_hiragana() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "てすと";

			dto.setReleaseDate(expected);
			String actual = dto.getReleaseDate();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getReleaseDate_katakana() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "テスト";

			dto.setReleaseDate(expected);
			String actual = dto.getReleaseDate();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getReleaseDate_kanji() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "漢字";

			dto.setReleaseDate(expected);
			String actual = dto.getReleaseDate();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getReleaseDate_all() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "漢字 テスト　てすと123abc";

			dto.setReleaseDate(expected);
			String actual = dto.getReleaseDate();
			assertEquals(expected,actual);
		}

		// test String setReleaseDate()
		@Test
		public void test_setReleaseDate_null() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = null;

			dto.setReleaseDate(expected);
			String actual = dto.getReleaseDate();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setReleaseDate_emptyCharacter() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "";

			dto.setReleaseDate(expected);
			String actual = dto.getReleaseDate();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setReleaseDate_space() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = " ";

			dto.setReleaseDate(expected);
			String actual = dto.getReleaseDate();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setReleaseDate_fullSpace() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "　";

			dto.setReleaseDate(expected);
			String actual = dto.getReleaseDate();
			assertEquals(expected,actual);
		}

		@Test
		public void test_setReleaseDate_alphabeticCharacters() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "abc";

			dto.setReleaseDate(expected);
			String actual = dto.getReleaseDate();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setReleaseDate_halfWidthDigit() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "123";

			dto.setReleaseDate(expected);
			String actual = dto.getReleaseDate();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setReleaseDate_hiragana() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "てすと";

			dto.setReleaseDate(expected);
			String actual = dto.getReleaseDate();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setReleaseDate_katakana() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "テスト";

			dto.setReleaseDate(expected);
			String actual = dto.getReleaseDate();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setReleaseDate_kanji() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "漢字";

			dto.setReleaseDate(expected);
			String actual = dto.getReleaseDate();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setReleaseDate_all() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "漢字 テスト　てすと123abc";

			dto.setReleaseDate(expected);
			String actual = dto.getReleaseDate();
			assertEquals(expected,actual);
		}

		// test int getTotalPrice()
		@Test
		public void test_getTotalPrice_max() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			int expected = 2147483647;

			dto.setTotalPrice(expected);
			int actual = dto.getTotalPrice();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getTotalPrice_min() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			int expected = -2147483648;

			dto.setTotalPrice(expected);
			int actual = dto.getTotalPrice();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getTotalPrice_0() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			int expected = 0;

			dto.setTotalPrice(expected);
			int actual = dto.getTotalPrice();
			assertEquals(expected,actual);
		}

		// test int setTotalPrice()
		@Test
		public void test_setTotalPrice_max() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			int expected = 2147483647;

			dto.setTotalPrice(expected);
			int actual = dto.getTotalPrice();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setTotalPrice_min() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			int expected = -2147483648;

			dto.setTotalPrice(expected);
			int actual = dto.getTotalPrice();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setTotalPrice_0() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			int expected = 0;

			dto.setTotalPrice(expected);
			int actual = dto.getTotalPrice();
			assertEquals(expected,actual);
		}

		// test String getFamilyName()
		@Test
		public void test_getFamilyName_null() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = null;

			dto.setFamilyName(expected);
			String actual = dto.getFamilyName();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getFamilyName_emptyCharacter() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "";

			dto.setFamilyName(expected);
			String actual = dto.getFamilyName();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getFamilyName_space() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = " ";

			dto.setFamilyName(expected);
			String actual = dto.getFamilyName();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getFamilyName_fullSpace() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "　";

			dto.setFamilyName(expected);
			String actual = dto.getFamilyName();
			assertEquals(expected,actual);
		}

		@Test
		public void test_getFamilyName_alphabeticCharacters() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "abc";

			dto.setFamilyName(expected);
			String actual = dto.getFamilyName();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getFamilyName_halfWidthDigit() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "123";

			dto.setFamilyName(expected);
			String actual = dto.getFamilyName();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getFamilyName_hiragana() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "てすと";

			dto.setFamilyName(expected);
			String actual = dto.getFamilyName();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getFamilyName_katakana() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "テスト";

			dto.setFamilyName(expected);
			String actual = dto.getFamilyName();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getFamilyName_kanji() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "漢字";

			dto.setFamilyName(expected);
			String actual = dto.getFamilyName();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getFamilyName_all() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "漢字 テスト　てすと123abc";

			dto.setFamilyName(expected);
			String actual = dto.getFamilyName();
			assertEquals(expected,actual);
		}

		// test String setFamilyName()
		@Test
		public void test_setFamilyName_null() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = null;

			dto.setFamilyName(expected);
			String actual = dto.getFamilyName();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setFamilyName_emptyCharacter() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "";

			dto.setFamilyName(expected);
			String actual = dto.getFamilyName();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setFamilyName_space() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = " ";

			dto.setFamilyName(expected);
			String actual = dto.getFamilyName();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setFamilyName_fullSpace() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "　";

			dto.setFamilyName(expected);
			String actual = dto.getFamilyName();
			assertEquals(expected,actual);
		}

		@Test
		public void test_setFamilyName_alphabeticCharacters() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "abc";

			dto.setFamilyName(expected);
			String actual = dto.getFamilyName();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setFamilyName_halfWidthDigit() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "123";

			dto.setFamilyName(expected);
			String actual = dto.getFamilyName();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setFamilyName_hiragana() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "てすと";

			dto.setFamilyName(expected);
			String actual = dto.getFamilyName();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setFamilyName_katakana() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "テスト";

			dto.setFamilyName(expected);
			String actual = dto.getFamilyName();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setFamilyName_kanji() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "漢字";

			dto.setFamilyName(expected);
			String actual = dto.getFamilyName();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setFamilyName_all() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "漢字 テスト　てすと123abc";

			dto.setFamilyName(expected);
			String actual = dto.getFamilyName();
			assertEquals(expected,actual);
		}

		// test String getFirstName()
		@Test
		public void test_getFirstName_null() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = null;

			dto.setFirstName(expected);
			String actual = dto.getFirstName();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getFirstName_emptyCharacter() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "";

			dto.setFirstName(expected);
			String actual = dto.getFirstName();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getFirstName_space() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = " ";

			dto.setFirstName(expected);
			String actual = dto.getFirstName();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getFirstName_fullSpace() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "　";

			dto.setFirstName(expected);
			String actual = dto.getFirstName();
			assertEquals(expected,actual);
		}

		@Test
		public void test_getFirstName_alphabeticCharacters() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "abc";

			dto.setFirstName(expected);
			String actual = dto.getFirstName();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getFirstName_halfWidthDigit() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "123";

			dto.setFirstName(expected);
			String actual = dto.getFirstName();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getFirstName_hiragana() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "てすと";

			dto.setFirstName(expected);
			String actual = dto.getFirstName();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getFirstName_katakana() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "テスト";

			dto.setFirstName(expected);
			String actual = dto.getFirstName();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getFirstName_kanji() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "漢字";

			dto.setFirstName(expected);
			String actual = dto.getFirstName();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getFirstName_all() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "漢字 テスト　てすと123abc";

			dto.setFirstName(expected);
			String actual = dto.getFirstName();
			assertEquals(expected,actual);
		}

		// test String getUserAddress()
		@Test
		public void test_getUserAddress_null() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = null;

			dto.setUserAddress(expected);
			String actual = dto.getUserAddress();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getUserAddress_emptyCharacter() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "";

			dto.setUserAddress(expected);
			String actual = dto.getUserAddress();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getUserAddress_space() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = " ";

			dto.setUserAddress(expected);
			String actual = dto.getUserAddress();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getUserAddress_fullSpace() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "　";

			dto.setUserAddress(expected);
			String actual = dto.getUserAddress();
			assertEquals(expected,actual);
		}

		@Test
		public void test_getUserAddress_alphabeticCharacters() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "abc";

			dto.setUserAddress(expected);
			String actual = dto.getUserAddress();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getUserAddress_halfWidthDigit() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "123";

			dto.setUserAddress(expected);
			String actual = dto.getUserAddress();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getUserAddress_hiragana() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "てすと";

			dto.setUserAddress(expected);
			String actual = dto.getUserAddress();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getUserAddress_katakana() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "テスト";

			dto.setUserAddress(expected);
			String actual = dto.getUserAddress();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getUserAddress_kanji() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "漢字";

			dto.setUserAddress(expected);
			String actual = dto.getUserAddress();
			assertEquals(expected,actual);
		}
		@Test
		public void test_getUserAddress_all() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "漢字 テスト　てすと123abc";

			dto.setUserAddress(expected);
			String actual = dto.getUserAddress();
			assertEquals(expected,actual);
		}

		// test String setUserAddress()
		@Test
		public void test_setUserAddress_null() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = null;

			dto.setUserAddress(expected);
			String actual = dto.getUserAddress();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setUserAddress_emptyCharacter() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "";

			dto.setUserAddress(expected);
			String actual = dto.getUserAddress();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setUserAddress_space() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = " ";

			dto.setUserAddress(expected);
			String actual = dto.getUserAddress();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setUserAddress_fullSpace() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "　";

			dto.setUserAddress(expected);
			String actual = dto.getUserAddress();
			assertEquals(expected,actual);
		}

		@Test
		public void test_setUserAddress_alphabeticCharacters() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "abc";

			dto.setUserAddress(expected);
			String actual = dto.getUserAddress();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setUserAddress_halfWidthDigit() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "123";

			dto.setUserAddress(expected);
			String actual = dto.getUserAddress();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setUserAddress_hiragana() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "てすと";

			dto.setUserAddress(expected);
			String actual = dto.getUserAddress();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setUserAddress_katakana() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "テスト";

			dto.setUserAddress(expected);
			String actual = dto.getUserAddress();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setUserAddress_kanji() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "漢字";

			dto.setUserAddress(expected);
			String actual = dto.getUserAddress();
			assertEquals(expected,actual);
		}
		@Test
		public void test_setUserAddress_all() {
			PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
			String expected = "漢字 テスト　てすと123abc";

			dto.setUserAddress(expected);
			String actual = dto.getUserAddress();
			assertEquals(expected,actual);
		}


}
