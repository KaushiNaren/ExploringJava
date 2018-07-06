package multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ArrayBlockingQueue;

public class ThreadPoolExecutorExample {
	public static void main(String... args) {

		BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(30);
		ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, blockingQueue);

		Runnable task = null;
		for (int i = 0; i < 30; i++) {
			
			TPoolTask tTask = new TPoolTask(i);		
			task = tTask::task;			
			pool.execute(task);
		}
		pool.shutdown();

	}
}

class TPoolTask {

	private final int taskId;

	public TPoolTask(int taskId) {
		this.taskId = taskId;
	}

	public void task() {
		try {
			System.out.println(taskId + "---->" + Thread.currentThread().getName());
			Thread.sleep(16000);
		} catch (InterruptedException ex) {

		}
	}
}
