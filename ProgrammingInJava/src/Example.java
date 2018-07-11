
public class Example {

	public static void main(String... args) {

		Thread t1 = new Thread(new Task101()::executeTask);
		Thread t2 = new Thread(Task102::executeTask);
		t1.start();
		t2.start();

		Thread t3 = new Thread(() -> System.out.println("hi"));
		t3.start();

	}
}

class Task101 {

	public void executeTask() {

		System.out.println("Inside Task1..." + Thread.currentThread().getName());
	}
}

class Task102 {

	public static void executeTask() {

		System.out.println("Inside Task2..." + Thread.currentThread().getName());
	}
}