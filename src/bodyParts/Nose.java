package bodyParts;

import aClasses.BodyPart;
import aClasses.Creature;
import enums.ItemType;

import javax.script.ScriptEngine;

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
