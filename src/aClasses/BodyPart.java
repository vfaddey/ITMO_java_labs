package aClasses;

import interfaces.Hitter;

public abstract class BodyPart implements Hitter {
    private String name;
    protected boolean isHeated;
    public BodyPart(String name) {
        this.name = name;
    }

    protected String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return name;
    }
    protected abstract boolean isHeated();
    public abstract String getState();

}
