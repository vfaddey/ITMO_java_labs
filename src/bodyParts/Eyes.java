package bodyParts;

import aClasses.BodyPart;
import aClasses.Creature;
import enums.Characteristics;

public class Eyes extends BodyPart {
    private String name;
    private String color;
    private int quantity;
    private boolean closed;
    private Creature owner;
    private boolean isHeated;
    public Eyes(String name) {
        super(name);
    }
    public Eyes(String color, boolean closed, int quantity) {
        this.name = "глаза";
        this.color = color;
        this.closed = closed;
        this.quantity = quantity;

    }

    public void open() {
        this.closed = false;
        System.out.println(owner + " открыл " + getName());
    }

    public boolean areClosed() {
        return closed;
    }

    public void close() {
        this.closed = true;
        System.out.println(owner + " открыл " + getName());
    }

    public void setOwner(Creature owner) {
        this.owner = owner;
    }

    public Creature getOwner() {
        return owner;
    }

    @Override
    protected String getName() {
        return this.name;
    }

    @Override
    protected boolean isHeated() {
        return false;
    }

    @Override
    public void hit() {

    }

    public void expand() {
        System.out.println(this + " " + owner + " расширились");
        owner.setType(Characteristics.SCARED);
    }

    @Override
    public String getState() {
        return null;
    }
}
