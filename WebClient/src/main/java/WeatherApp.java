import apiutil.WeatherClient;
import configutil.Config;
import configutil.ConfigLoader;
import controller.ForecastFinder;

public class WeatherApp {

    public static void main(String[] args) {
        Config config = ConfigLoader.loadConfig();
        ForecastFinder forecastFinder = new ForecastFinder(config);
        forecastFinder.run();
    }
}
