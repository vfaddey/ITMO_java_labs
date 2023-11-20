package bodyParts;

import aClasses.BodyPart;
import aClasses.Creature;
import aClasses.Item;
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
                    other.setType(Characteristics.SCARED);
            }
            System.out.println(this + " дрожат");
        }
        else {
            System.out.println(this + " дрожат");
        }
        this.type = ItemType.CREEPY;
    }

    public void move() {
        if (getOwner() != null) {
            for (Creature other : getOwner().getLocation().getCreatures()) {
                if (!other.hasType(Characteristics.SCARED))
                    other.setType(Characteristics.SCARED);
            }
            System.out.println(this + " шевелятся");
        }
        else {
            System.out.println(this + " шевелятся");
        }
        this.type = ItemType.CREEPY;
    }

    public void crawl() {
        if (getOwner() != null) {
            for (Creature other : getOwner().getLocation().getCreatures()) {
                if (!other.hasType(Characteristics.SCARED))
                    other.setType(Characteristics.SCARED);
            }
            System.out.println(this + " ползают");
        }
        else {
            System.out.println(this + " ползают");
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
