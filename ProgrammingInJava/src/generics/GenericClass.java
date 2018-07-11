package generics;

public class GenericClass {

	public static void main(String... args) {

		GenericType<String> typeString = new GenericType<String>();
		typeString.setValue("naren1");
		System.out.println(typeString.getVale());

		GenericType<EmpG> typeEmp = new GenericType<EmpG>();
		typeEmp.setValue(new EmpG(1, "kaushi"));
		System.out.println(typeEmp.getVale());

	}

}

class GenericType<T> {
	T value;

	public void setValue(T value) {
		this.value = value;
	}

	public T getVale() {
		return value;
	}

}

class EmpG {
	private final int id;
	private final String name;

	public EmpG(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String toString() {
		return "ID=" + id + " , Name=" + name;
	}

}
