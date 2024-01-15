package enums;

public enum Characteristics {
    STRONG("сильный"),
    WEAK("слабый"),
    SKINNY("худой"),
    FAT("толстый"),
    GOOD("хороший"),
    BAD("плохой"),
    KIND("добрый"),
    EVIL("злой"),
    HAPPY("счастливый"),
    SAD("грустный"),
    HUNGRY("голодный"),
    SCARED("напуган"),
    ASTONISHED("ошоломлен"),
    DIRTY("грязный");

    private final String translation;

    Characteristics(String translation) {
        this.translation = translation;
    }

    @Override
    public String toString() {
        return translation;
    }

}
