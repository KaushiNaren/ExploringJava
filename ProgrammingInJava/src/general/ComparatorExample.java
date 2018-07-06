package general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {
	public static void main(String... args) {

		EmpComparator emp1 = new EmpComparator(1, "shanthi");
		EmpComparator emp2 = new EmpComparator(2, "kaushi");
		EmpComparator emp3 = new EmpComparator(3, "amrith");

		List<EmpComparator> list = new ArrayList<EmpComparator>();
		list.add(emp2);
		list.add(emp1);
		list.add(emp3);

		System.out.println("Before Sorting->:");
		list.forEach(System.out::println);
		System.out.println("Sorting based on Emp ID->:");
		Collections.sort(list, new EmpIDSorter());
		list.forEach(System.out::println);
		System.out.println("Sorting based on Emp Name->:");
		Collections.sort(list, new EmpNameSorter());
		list.forEach(System.out::println);

		System.out.println("Java8V1 Sorting based on Emp ID->:");		
		Comparator<EmpComparator> java8Sorter = (e1, e2) -> e1.getId() - e2.getId();
		Collections.sort(list, java8Sorter);
		list.forEach(System.out::println);
		
		System.out.println("Java8V2 Sorting based on Emp ID->:");		
		Comparator<EmpComparator> java8SorterV2 = Comparator.comparing(EmpComparator::getId);
		Collections.sort(list, java8SorterV2);
		list.forEach(System.out::println);

	}

}

class EmpComparator {

	private final int id;
	private final String name;

	public EmpComparator(int id, String name) {
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

class EmpIDSorter implements Comparator<EmpComparator> {
	public int compare(EmpComparator emp1, EmpComparator emp2) {
		return emp1.getId() - emp2.getId();
	}
}

class EmpNameSorter implements Comparator<EmpComparator> {
	public int compare(EmpComparator emp1, EmpComparator emp2) {
		return emp1.getName().compareTo(emp2.getName());
	}
}
