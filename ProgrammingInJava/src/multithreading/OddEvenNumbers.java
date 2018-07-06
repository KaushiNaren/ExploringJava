package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Narendiran Rangan Manian
 * 
 *         Simple Program to Print Odd and Even Numbers in Sequence( Flavor of
 *         Producer Consumer Problem )
 *
 */
public class OddEvenNumbers {
	public static void main(String... args) {
		ExecutorService pool = Executors.newFixedThreadPool(2);
		Numbers numer = new Numbers();
		pool.execute(numer::printOdd);
		pool.execute(numer::printEven);
		pool.shutdown();
	}
}

class Numbers {

	private boolean oddFlag = true;

	public void printOdd() {
		for (int i = 1; i < 10; i++) {
			try {
				if ((i % 2 != 0)) {
					synchronized (this) {
						if (oddFlag == false) {
							this.wait();
						}
						print(i);
						oddFlag = false;
						this.notify();
					}
				}

			} catch (InterruptedException ex) {

			}
		}
	}

	public void printEven() {
		for (int i = 1; i < 10; i++) {
			try {
				if ((i % 2) == 0) {
					synchronized (this) {
						if (oddFlag == true) {
							this.wait();
						}
						print(i);
						oddFlag = true;
						this.notify();
					}
				}
			} catch (InterruptedException ex) {

			}
		}
	}

	private void print(int num) {
		System.out.println(num);
	}
}
