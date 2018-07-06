package general;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class ComparableExample {

	public static void main(String... args) {

		EmpComparable emp1 = new EmpComparable(1, "naren1");
		EmpComparable emp2 = new EmpComparable(2, "naren2");
		EmpComparable emp3 = new EmpComparable(3, "naren3");

		List<EmpComparable> list = new ArrayList<EmpComparable>();
		list.add(emp2);
		list.add(emp1);
		list.add(emp3);

		System.out.println("Before Sorting->:");
		list.forEach(System.out::println);
		System.out.println("After Sorting->:");
		Collections.sort(list);
		list.forEach(System.out::println);
	}

}

class EmpComparable implements Comparable<EmpComparable> {
	private final int id;
	private final String name;

	public EmpComparable(int id, String name) {
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

	public int compareTo(EmpComparable emp) {
		return this.getId() - emp.getId();
	}
}
