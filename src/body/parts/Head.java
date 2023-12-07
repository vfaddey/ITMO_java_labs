package body.parts;

import abstractions.BodyPart;
import abstractions.Creature;
import base.Human;
import enums.ItemType;

public class Head extends BodyPart {
    private boolean isHeated;
    public Eyes eyes;
    public Nose nose;
    public Face face;

    public Head(String name, Creature owner) {
        super(name, owner);
        this.eyes = new Eyes("глаза", owner);
        this.nose = new Nose("нос", owner);
        this.face = new Face("лицо", owner);
    }

    public Head(String name, Eyes eyes, Nose nose, Face face, Creature owner,  boolean isHeated) {
        super(name, owner);
        this.eyes = eyes;
        this.nose = nose;
        this.face = face;
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
        this.eyes.hit();
        this.face.hit();
        this.nose.hit();
        System.out.println(this + " сломана");
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
