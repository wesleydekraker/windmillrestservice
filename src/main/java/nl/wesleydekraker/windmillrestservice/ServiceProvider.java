package nl.wesleydekraker.windmillrestservice;

public class ServiceProvider {
	private static WindmillServiceImpl windmillService = new WindmillServiceImpl();

	public static WindmillServiceImpl getWindmillService() {
		return windmillService;
	}
}
