package body.parts;

import aClasses.BodyPart;
import aClasses.Creature;
import base.Human;
import enums.ItemType;

public class Legs extends BodyPart {
    private boolean isHeated;
    private int quantity;
    private boolean bended = false;

    public Legs(String name, Creature owner) {
        super(name, owner);
    }

    public Legs(String name, Creature owner, int quantity, boolean isHeated) {
        super(name, owner);
        this.quantity = quantity;
        this.isHeated = isHeated;
    }

    public void bend() {
        System.out.println(this + " " + getOwner() + " согнулись");
        this.bended = true;
    }

    public boolean areBended() {
        return this.bended;
    }

    public void unbend() {
        System.out.println(this + " " + getOwner() + " разогнулись");
        this.bended = false;
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
        if (getOwner() instanceof Human) {
            ((Human)getOwner()).shout();
        }
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
