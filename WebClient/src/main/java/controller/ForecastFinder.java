package controller;

import apiutil.WeatherClient;
import configutil.Config;
import view.ConsoleView;

public class ForecastFinder {

    private Config config;
    private WeatherClient weatherClient;

    public ForecastFinder(Config config) {
        this.config = config;
        weatherClient = new WeatherClient(config.getApiKey());
    }

    public void run() {

        boolean goAgain = true;
        while (goAgain) {
            String location = CLIInput.getLocation();
            String locationKey = weatherClient.getLocationKey(location);
            // TODO: handle location not found
            String forecast = weatherClient.getForecast(locationKey);
            ConsoleView.printMessage(forecast);
            goAgain = CLIInput.getGoAgain();
        }
    }


}
