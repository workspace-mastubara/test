
public class Test {

	public static void main(String[] args) {
		TestUserDAO dao = new TestUserDAO();
		dao.select("taro", "123");
		dao.selectAll();
		dao.selectByName("jiro");
		dao.selectByPassword("789");
		dao.UpDateNameByName("taro", "a");
		dao.UpDateNameByName("jiro", "b");
	}



}
