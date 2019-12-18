import java.util.ArrayList;
import java.util.List;

public class ListPractice {
	public static void main(String[] args){
		List<Person> personList = new ArrayList<Person>();

		Person sato = new Person("sato", 28);
		Person monzen = new Person("monzen", 22);
		Person suzuki = new Person("suzuki", 31);

		personList.add(sato);
		personList.add(monzen);
		personList.add(suzuki);

		for(Person p: personList){
			System.out.println(p.getName() + "は" + p.getAge() + "才");
		}

		System.out.println("1件目は" + personList.get(0).getName() + "さんです");

	}



}
