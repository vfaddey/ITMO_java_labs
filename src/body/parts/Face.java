package body.parts;

import aClasses.BodyPart;
import aClasses.Creature;
import base.Human;
import enums.ItemType;

public class Face extends BodyPart {
    private boolean isHeated;

    public Face(String name, Creature owner) {
        super(name, owner);
    }

    public Face(String name, Creature owner, boolean isHeated) {
        super(name, owner);
        this.isHeated = isHeated;
    }

    @Override
    protected boolean isHeated() {
        return isHeated;
    }

    @Override
    public String getState() {
        return null;
    }

    @Override
    public ItemType getType() {
        return null;
    }

    @Override
    public void hit() {
        isHeated = true;
        System.out.println(this + " истекает кровью");
        if (getOwner() instanceof Human) {
            ((Human)getOwner()).shout();
        }
    }
}
