package bodyParts;

import aClasses.BodyPart;
import aClasses.Creature;
import enums.Characteristics;

public class Bone extends BodyPart {

    private String name;
    private Creature belongsTo;
    private boolean isHeated;

    public Bone(String name) {
        super(name);
    }

    public void setOwner(Creature owner) {
        this.belongsTo = owner;
    }

    public Creature getOwner() {
        return belongsTo;
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
}
