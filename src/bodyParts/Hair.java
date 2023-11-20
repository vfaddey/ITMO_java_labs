package bodyParts;

import aClasses.BodyPart;
import aClasses.Creature;
import enums.ItemType;

public class Hair extends BodyPart {
    private String color;
    private final boolean isHeated = false;

    public Hair(String color, Creature owner) {
        super("волосы", owner);
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

    @Override
    public ItemType getType() {
        return null;
    }
}
