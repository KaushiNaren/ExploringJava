package designpatterns;

import java.util.Date;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Narendian Rangan Manian
 * 
 *         Observer Pattern using Java API Example,
 * 
 *
 */
public class ObserverPatternWithJavaAPIExample {
	public static void main(String... args) {

		BaseStation baseStation = new BaseStation();
		baseStation.addObserver(new SubStation1());
		baseStation.addObserver(new SubStation2());
		new Thread(baseStation::run).start();

	}

}

class BaseStation extends Observable {

	public void subscribe(Observer observer) {
		addObserver(observer);
	}

	public void run() {
		System.out.println("Whether Forecast System Activated !!!!!");
		while (true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("----------------------");
			setChanged();
			notifyObservers(new Date());
			System.out.println("\n");
		}
	}
}

class Notification {

}

class SubStation1 implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("SubStation1 -->" + arg);

	}

}

class SubStation2 implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("SubStation2 -->" + arg);
	}

}
