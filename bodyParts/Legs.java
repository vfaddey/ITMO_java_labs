package bodyParts;

import aClasses.BodyPart;

public class Legs extends BodyPart {
    private boolean isHeated;
    private int quantity;

    public Legs() {
        super("ноги");
    }

    public Legs(String name, int quantity, boolean isHeated) {
        super(name);
        this.quantity = quantity;
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
