package general;

import java.util.Arrays;

import java.util.List;

public class UnionOperations {

	public static void main(String... args) {
		Employee e1 = new Employee(1, "naren1");
		Employee e2 = new Employee(2, "naren2");

		Employee e22 = new Employee(2, "naren2");
		Employee e3 = new Employee(3, "naren3");

		List<Employee> set1 = Arrays.asList(e1, e2);
		List<Employee> set2 = Arrays.asList(e22, e3);

		List<String> set11 = Arrays.asList("e1", "e2");
		List<String> set22 = Arrays.asList("e2", "e3");

		SetManipulation<String> setM = new SetManipulation<String>();
		System.out.println("======UNION==========");
		setM.setUnion(set11, set22);
		System.out.println("======SET1 - SET2==========");
		setM.setNegation(set11, set22);
		System.out.println("======SET2 - SET1==========");
		setM.setNegation(set22, set11);

		SetManipulation<Employee> setMObject = new SetManipulation<Employee>();
		System.out.println("======EMPLOYEE SET UNION==========");
		setMObject.setUnion(set1, set2);
		System.out.println("======EMPLOYEE SET1-SET2==========");
		setMObject.setNegation(set1, set2);
		System.out.println("======EMPLOYEE SET2-SET1========");
		setMObject.setNegation(set2, set1);
	}
}

class SetManipulation<T> {

	public void setUnion(List<T> set1, List<T> set2) {
		set1.forEach(System.out::println);
		set2.stream().filter(x -> !set1.contains(x)).forEach(System.out::println);

	}

	public void setNegation(List<T> set1, List<T> set2) {
		set1.stream().filter(x -> !set2.contains(x)).forEach(System.out::println);
	}

}

class Employee {
	private final int id;
	private final String name;

	public Employee(int id, String name) {
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

	public int hasCode() {
		return this.id;
	}

	public boolean equals(Object obj) {
		Employee emp = (Employee) obj;
		return this.getId() == emp.getId() && this.getName().equals(this.getName());
	}
}
