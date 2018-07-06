package java8;



public class FunctionalInterfaceExample {

	public static void main(String... args) {

		SumInterface sumInterface = (a, b) -> System.out.println(a + b);
		sumInterface.sum(5, 5);
		
		FEmpInterface fEInterface = (Empf emp1, Empf emp2) -> emp1.getName().compareTo(emp2.getName());
	}

}

@FunctionalInterface
interface SumInterface {
	public void sum(int a, int b);
}

@FunctionalInterface
interface FEmpInterface {
	public int sum(Empf emp1, Empf emp2);
}

class Empf {
	private final int id;
	private final String name;

	public Empf(int id, String name) {
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
