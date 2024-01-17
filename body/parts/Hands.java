package body.parts;

import abstractions.BodyPart;
import abstractions.Creature;
import base.Human;
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
    public boolean isHeated() {
        return isHeated;
    }

    @Override
    public void hit() {
        isHeated = true;
        System.out.println(this + " сломаны");
        if (getOwner() instanceof Human) {
            ((Human)getOwner()).shout();
        }
    }


    @Override
    public ItemType getType() {
        return null;
    }
}
