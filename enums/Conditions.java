package enums;

public enum Conditions {

    KNEELING("стоит на коленях"),
    SLEEP("спит"),
    THIRSTY("хочет пить");


    private final String translation;

    Conditions(String translation) {
        this.translation = translation;
    }

    @Override
    public String toString() {
        return translation;
    }
}
