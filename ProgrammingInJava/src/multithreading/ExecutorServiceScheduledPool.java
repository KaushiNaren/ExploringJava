package multithreading;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceScheduledPool {
	public static void main(String... args) 
	{
		
	
		
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
		
		Runnable task = null;
		System.out.println("Time is :"+new Date());
		for (int i = 0; i < 30; i++) {
			
			TPoolTask tTask = new TPoolTask(i);		
			task = tTask::task;		
			
			pool.scheduleWithFixedDelay(task, 20, 2, TimeUnit.SECONDS);
		}
		
		pool.shutdown();
		

	}

}

class SCTPTask {

	private final int taskId;

	public SCTPTask(int taskId) {
		this.taskId = taskId;
	}

	public void task() {
		try {
			System.out.println(taskId + "---->" + new Date());
			
		} catch (Exception ex) {

		}
	}
}
