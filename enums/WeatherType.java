package enums;

public enum WeatherType {
    LIGHT("светло"),
    DARK("темно"),
    RAIN("лил дождь"),
    MOON("светила луна"),
    SUN("светило Cолнце"),
    SHYSKY("чистое небо"),
    CLOUDY("облачно"),
    SNOW("шел снег"),
    FOG("туманно");

    private final String translation;

    WeatherType(String translation) {
        this.translation = translation;
    }

    @Override
    public String toString() {
        return translation;
    }
}
