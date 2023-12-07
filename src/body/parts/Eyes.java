package body.parts;

import abstractions.BodyPart;
import abstractions.Creature;
import base.Human;
import enums.Characteristics;
import enums.ItemType;

public class Eyes extends BodyPart {
    private String color;
    private int quantity;
    private boolean closed;
    private boolean isHeated;
    public Eyes(String name, Creature owner) {
        super(name, owner);
    }
    public Eyes(String color, Creature owner, boolean closed, int quantity) {
        super("глаза", owner);
        this.color = color;
        this.closed = closed;
        this.quantity = quantity;

    }

    public void open() {
        this.closed = false;
        System.out.println(getOwner() + " открыл " + getName());
    }

    public boolean areClosed() {
        return closed;
    }

    public void close() {
        this.closed = true;
        System.out.println(getOwner() + " открыл " + getName());
    }

    @Override
    protected boolean isHeated() {
        return false;
    }

    @Override
    public void hit() {
        isHeated = true;
        System.out.println(this + " повреждены");
        if (getOwner() instanceof Human) {
            ((Human)getOwner()).shout();
        }
    }

    public void expand() {
        System.out.println(this + " " + getOwner() + " расширились");
        getOwner().addTypes(Characteristics.SCARED);
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
