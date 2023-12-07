package body.parts;

import abstractions.BodyPart;
import abstractions.Creature;
import enums.ItemType;

public class Nose extends BodyPart {
    public Nose(String name, Creature owner) {
        super(name, owner);
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
        System.out.println(this + " сломан");
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
