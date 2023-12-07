package body.parts;

import abstractions.BodyPart;
import abstractions.Creature;
import base.Human;
import enums.Characteristics;
import enums.ItemType;

public class Bone extends BodyPart {
    private String name;
    private boolean isHeated;
    private ItemType type;

    public Bone(String name, Creature owner) {
        super(name, owner);
    }


    public void tremble() {
        if (getOwner() != null) {
            for (Creature other : getOwner().getLocation().getCreatures()) {
                if (!other.hasType(Characteristics.SCARED))
                    other.addTypes(Characteristics.SCARED);
            }
            System.out.println(this + " " + getOwner() + " дрожат");
        }
        else {
            System.out.println(this + " " + getOwner() + " дрожат");
        }
        this.type = ItemType.CREEPY;
    }

    public void move() {
        if (getOwner() != null) {
            for (Creature other : getOwner().getLocation().getCreatures()) {
                if (!other.hasType(Characteristics.SCARED))
                    other.addTypes(Characteristics.SCARED);
            }
            System.out.println(this + " " + getOwner() + " шевелятся");
        }
        else {
            System.out.println(this + " " + getOwner() + " шевелятся");
        }
        this.type = ItemType.CREEPY;
    }

    public void crawl() {
        if (getOwner() != null) {
            for (Creature other : getOwner().getLocation().getCreatures()) {
                if (!other.hasType(Characteristics.SCARED))
                    other.addTypes(Characteristics.SCARED);
            }
            System.out.println(this + " " + getOwner() + " ползают");
        }
        else {
            System.out.println(this + " " + getOwner() + " ползают");
        }
        this.type = ItemType.CREEPY;
    }

    @Override
    protected String getName() {
        return name;
    }

    @Override
    protected boolean isHeated() {
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
    public String getState() {
        return null;
    }

    @Override
    public ItemType getType() {
        return this.type;
    }
}
