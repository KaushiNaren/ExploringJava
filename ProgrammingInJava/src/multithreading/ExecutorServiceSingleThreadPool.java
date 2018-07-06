package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceSingleThreadPool {
	public static void main(String... args) {

		Runnable task1 = STPTask::task;
		Runnable task2 = STPTask::task;
		Runnable task3 = STPTask::task;
		Runnable task4 = STPTask::task;

		ExecutorService pool = Executors.newSingleThreadExecutor();
		pool.execute(task1);
		pool.execute(task2);
		pool.execute(task3);
		pool.execute(task4);
		pool.shutdown();
		System.out.println("Pool Got Shutdown...");
	}
}

class STPTask {
	public static void task() {
		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName());

		} catch (InterruptedException ex) {

		}
	}
}
