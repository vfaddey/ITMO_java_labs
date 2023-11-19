package bodyParts;

import aClasses.BodyPart;

public class Hair extends BodyPart {
    private String color;
    private final boolean isHeated = false;
    public Hair() {
        super("волосы");
    }
    public Hair(String color) {
        this.color = color;
    }
    @Override
    protected String getName() {
        return null;
    }

    @Override
    protected boolean isHeated() {
        return isHeated;
    }

    @Override
    public void hit() {

    }

    @Override
    public String getState() {
        return null;
    }
}
