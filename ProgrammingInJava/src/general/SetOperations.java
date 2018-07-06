package general;

import java.util.HashSet;
import java.util.Set;

public class SetOperations {

	public static void main(String... args) {
		Employee1 e1 = new Employee1(1, "naren1");
		Employee1 e2 = new Employee1(2, "naren2");
		System.out.println(e2.hashCode());

		Employee1 e22 = new Employee1(2, "naren2");
		System.out.println(e22.hashCode());
		Employee1 e3 = new Employee1(3, "naren3");

		Set<Employee1> set = new HashSet<Employee1>();
		set.add(e1);
		set.add(e2);
		set.add(e22);
		set.add(e3);

		set.forEach(System.out::println);

	}

}

class Employee1 {
	private final int id;
	private final String name;

	public Employee1(int id, String name) {
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

	public int hashCode() {
		return this.id;
	}

	public boolean equals(Object obj) {
		Employee1 emp = (Employee1) obj;
		return this.getId() == emp.getId() && this.getName().equals(this.getName());
	}
}