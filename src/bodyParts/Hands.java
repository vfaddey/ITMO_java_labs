package bodyParts;

import aClasses.BodyPart;
import aClasses.Creature;
import enums.ItemType;

public class Hands extends BodyPart {
    private boolean isHeated;
    private int quantity;

    public Hands(String name, Creature owner) {
        super("руки", owner);
    }

    public Hands(String name, int quantity, Creature owner,  boolean isHeated) {
        super(name, owner);
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
        isHeated = true;
        System.out.println(this + " сломаны");
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
