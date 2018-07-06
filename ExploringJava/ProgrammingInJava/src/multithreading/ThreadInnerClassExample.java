package multithreading;

import java.util.Date;

public class ThreadInnerClassExample {
	public static void main(String... args) {

		Thread t = new Thread(new Runnable() {
			int count = 0;

			public void run() {
				while (count < 5) {
					try {
						Thread.sleep(2000);
						System.out.println("Option1->" + new Date());
						count++;

					} catch (InterruptedException ex) {
					}
				}
			}
		});
		t.start();

		Runnable runnable = () -> {
			int count = 0;
			while (count < 5) {
				try {
					Thread.sleep(2000);
					System.out.println("Option2->" + new Date());
					count++;

				} catch (InterruptedException ex) {
				}
			}
		};

		new Thread(runnable).start();
	}
}