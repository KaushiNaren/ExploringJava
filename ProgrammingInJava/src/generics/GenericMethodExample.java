package generics;

public class GenericMethodExample {
	public static void main(String... args) {
		GenericMethod gm = new GenericMethod();
		//System.out.println(gm.isEquals("naren1", "naren1"));
		//System.out.println(gm.isEquals(45, 45));
		//System.out.println(gm.isEquals(45, "naren"));

		EmpG emp1 = new EmpG(1, "kaushi");
		//EmpG emp2 = emp1;
		EmpG emp2 = new EmpG(1, "kaushi");

		System.out.println(gm.isEquals(emp1, emp2));

	}

}

class GenericMethod {

	public <T> boolean isEquals(T t1, T t2) {
		return t1.equals(t2);

	}
}
