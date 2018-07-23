package multithreading;

public class ThreadLocalExample {
	public static void main(String... args) {
		TLocaleTask task = new TLocaleTask();
		Thread t1 = new Thread(task::doSomeThingFunny);
		t1.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException ex) {
		}
		Thread t2 = new Thread(task::doSomeThingFunny);
		t2.start();
	}
}

class TLocaleTask {

	ThreadLocal<String> threadLocal = new ThreadLocal<String>();

	public void doSomeThingFunny() {

		try {
			System.out.println("Settings [" + Thread.currentThread().getName() + "] to ThreadLocal Name");
			threadLocal.set(Thread.currentThread().getName());
			Thread.sleep(20 * 1000);
		} catch (InterruptedException e) {			
			
		}
		System.out.println("\n\n\n");
		System.out.println(" Thread Name [" + Thread.currentThread().getName() + "] is same as ThreadLocal Name---->"
				+ threadLocal.get());
	}
}