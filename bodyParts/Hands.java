package bodyParts;

import aClasses.BodyPart;

public class Hands extends BodyPart {
    private boolean isHeated;
    private int quantity;

    public Hands() {
        super("руки");
    }

    public Hands(int quantity, boolean isHeated) {
        super("руки");
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
