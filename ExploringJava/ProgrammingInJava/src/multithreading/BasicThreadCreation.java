package multithreading;

/**
 * @author nranganmanian
 * 
 *         Different ways of creationg threads.
 *
 */
public class BasicThreadCreation {
	public static void main(String... args) {

		Runnable task1 = OddTask::annanRombaKettavar;
		new Thread(task1).start();
	}
}

class OddTask {

	public static void annanRombaKettavar() {

		System.out.println("output======");
		for (int i = 1; i < 20; i++) {
			int n = i % 2;
			if (n != 0) {
				System.out.println("ODD->" + i);
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException ex) {

			}
		}
	}
}

class EvenTask {
	public static void run() {
		for (int i = 1; i < 20; i++) {
			int n = i % 2;
			if (n == 0) {
				System.out.println("Even->" + i);
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException ex) {

			}
		}
	}
}