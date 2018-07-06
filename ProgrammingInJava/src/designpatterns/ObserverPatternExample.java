package designpatterns;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class ObserverPatternExample {
	public static void main(String... args) {
		BaseForeCastStationChennai baseStation = new BaseForeCastStationChennai();
		baseStation.subscribe(new NilgiriStation("NIL"));
		baseStation.subscribe(new CoimbatoreStation("CBE"));
		baseStation.subscribe(new ErodeStation("ER"));

		new Thread(baseStation::startWheatherForeCasting).start();

	}

}

abstract class WeatherStation {
	protected String code;

	public abstract void update(String latestWhether);

	public String getCode() {
		return this.code;
	}
}

class NilgiriStation extends WeatherStation {
	public NilgiriStation(String code) {
		this.code = code;
	}

	@Override
	public void update(String latestWhether) {
		System.out.println("Weather at Nilgiri::" + latestWhether);
	}

}

class CoimbatoreStation extends WeatherStation {

	public CoimbatoreStation(String code) {
		this.code = code;
	}

	@Override
	public void update(String latestWhether) {
		System.out.println("Weather at Coimbatore::" + latestWhether);

	}

}

class ErodeStation extends WeatherStation {

	public ErodeStation(String code) {
		this.code = code;
	}

	@Override
	public void update(String latestWhether) {
		System.out.println("Weather at Erode::" + latestWhether);

	}

}

class BaseForeCastStationChennai {
	private final List<WeatherStation> stationList;

	public BaseForeCastStationChennai() {
		this.stationList = new ArrayList<WeatherStation>();
	}

	public void subscribe(WeatherStation subStation) {
		this.stationList.add(subStation);
	}

	public void startWheatherForeCasting() {
		System.out.println("Whether Forecast System Activated !!!!!");
		Random random = new Random();
		int min = 20;

		while (true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println(new Date());
			System.out.println("----------------------");

			this.stationList.forEach(station -> {
				int tempMin = min;
				if (station.getCode().equals("NIL")) {
					tempMin = 10;
				}

				String whether = tempMin + random.nextInt(10) + " °C ";
				station.update("Current Temprature is : " + whether);
			});

			System.out.println("\n\n\n");

		}

	}

}
