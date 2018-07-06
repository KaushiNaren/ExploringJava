package multithreading;

public class SimulateDeadLock {
	private static String lock1 = new String();
	private static String lock2 = new String();

	public static void main(String... args) {

		Thread t1 = new Thread(() -> 
		{
			while(true)
			{
				synchronized (lock1) {
					synchronized (lock2) {
						System.out.println("Thread1 acquired two locks");
						
					}
					
				}
			}

		});
		t1.start();

		Thread t2 = new Thread(() -> 
		{
			
			while(true)
			{
				synchronized (lock2) {
					synchronized (lock1) {
						System.out.println("Thread2 acquired two locks");
						
					}
					
				}
			}
			

		});
		t2.start();

	}

}
