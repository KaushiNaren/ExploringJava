package common;

public class Employee implements Comparable<Employee> {
	private final int id;

	private final String name;

	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return id + "  , " + name;
	}

	public int compareTo(Employee obj) {
		Employee emp = (Employee) obj;
		return this.getId() - emp.getId();
	}
}
