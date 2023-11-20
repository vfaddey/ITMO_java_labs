package bodyParts;

import aClasses.BodyPart;

public class Head extends BodyPart {
    private boolean isHeated;
    public BodyPart eyes;
    public BodyPart nose;

    public Head(BodyPart eyes, BodyPart nose) {
        super("голова");
        this.eyes = eyes;
        this.nose = nose;
    }

    public Head(String name, Eyes eyes, boolean isHeated) {
        super(name);
        this.eyes = eyes;
        this.isHeated = isHeated;
    }

    @Override
    protected String getName() {
        return null;
    }

    @Override
    protected boolean isHeated() {
        return false;
    }

    @Override
    public void hit() {

    }

    @Override
    public String getState() {
        return null;
    }
}
