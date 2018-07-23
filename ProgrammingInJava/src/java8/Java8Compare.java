package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Java8Compare {

	public static void main(String... args) {

		EmpComparator8 emp1 = new EmpComparator8(1, "shanthi");
		EmpComparator8 emp2 = new EmpComparator8(2, "kaushi");
		EmpComparator8 emp3 = new EmpComparator8(3, "amrith");

		List<EmpComparator8> list = new ArrayList<EmpComparator8>();
		list.add(emp2);
		list.add(emp1);
		list.add(emp3);

		System.out.println("Before Sorting->:");
		list.forEach(System.out::println);

		System.out.println("Java8 Compare Method 11111");
		Collections.sort(list, Comparator.comparing(EmpComparator8::getId));
		list.sort(Comparator.comparing(EmpComparator8::getId));

		Collections.sort(list, (e1, e2) -> e1.getName().compareTo(e2.getName()));
		Collections.sort(list, Comparator.comparing(EmpComparator8::getId));
		list.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));

		list.sort(Comp1::compareeeee);

	}

}

class Comp1 {
	public static int compareeeee(EmpComparator8 emp1, EmpComparator8 emp2) {
		return emp1.getId() - emp2.getId();
	}
}

class EmpComparator8 {

	private final int id;
	private final String name;

	public EmpComparator8(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String toString() {
		return id + "->" + name;
	}

}
