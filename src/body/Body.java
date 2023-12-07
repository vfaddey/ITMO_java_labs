package body;

import abstractions.BodyPart;
import abstractions.Creature;
import base.Human;
import enums.ItemType;

public class Body extends BodyPart {
    private boolean isHeated;

    public Body(String name, Creature owner) {
        super(name, owner);
    }

    @Override
    protected boolean isHeated() {
        return false;
    }

    @Override
    public void hit() {
        this.isHeated = true;
        System.out.println(getName() + " сломано");
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
