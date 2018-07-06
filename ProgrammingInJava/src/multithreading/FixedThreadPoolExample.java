package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExample {
	public static void main(String... args) {

		ExecutorService pool = Executors.newFixedThreadPool(3);
		Runnable task = null;
		Thread t = null;

		for (int i = 0; i < 20; i++) {
			task = FTPTask::ftpTask;
			pool.execute(task);
		}
		pool.shutdown();
	}
}

class FTPTask {

	public static void ftpTask() {
		for (int i = 0; i < 5; i++) {
			try {
				System.out.println(Thread.currentThread().getName());
				Thread.sleep(2000);

			} catch (InterruptedException ex) {
			}
		}
	}
}
