package weather;

import enums.WeatherType;

import java.util.ArrayList;
import java.util.Arrays;

public class Weather {
    private ArrayList<WeatherType> weather;

    public Weather(WeatherType... types) {
        this.weather.addAll(Arrays.asList(types));
    }

    public void getState() {
        System.out.print("На улице ");
        for (WeatherType type : weather) {
            System.out.print(type);
        }
    }

}
