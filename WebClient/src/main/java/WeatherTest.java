import apiutil.WeatherClient;
import configutil.Config;
import configutil.ConfigLoader;
import view.ConsoleView;

public class WeatherTest {
    public static void main(String[] args) {

        Config config = ConfigLoader.loadConfig();
        WeatherClient client = new WeatherClient(config.getApiKey());
        String locationKey = client.getLocationKey("Oakland");
        String forecast = client.getForecast(locationKey);
        ConsoleView.printMessage(forecast);

    }
}
