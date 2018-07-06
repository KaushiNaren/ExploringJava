package multithreading;


public class ThreadJoinExample {
	public static void main(String... args) throws InterruptedException{
		Runnable task1 = JoinTask1::task;
		Runnable task2 = JoinTask2::task;

		Thread t1 = new Thread(task1);
		t1.start();
		
		t1.join();

		Thread t2 = new Thread(task2);
		t2.start();
		t2.join();

		System.out.println("Main method Ends !!!!!!1");

	}

}

class JoinTask1 {
	public static void task() {
		try {
			Thread.sleep(1000);
			System.out.println("JoinTask1... Completed !!!!!!!");
		} catch (InterruptedException ex) {

		}

	}

}

class JoinTask2 {
	public static void task() {
		try {
			Thread.sleep(5000);
			System.out.println("JoinTask2... Completed !!!!!!!");
		} catch (InterruptedException ex) {

		}

	}

}
