package enums;

public enum Language {
    RUSSIAN("русский"),
    ENGLISH("английский"),
    GERMAN("немецкий"),
    FRENCH("французский"),
    CHINESE("китайский"),
    UNKNOWN("неизвестный");

    private final String translation;
    Language(String translation) {
        this.translation = translation;
    };

    @Override
    public String toString() {
        return this.translation;
    }

}
