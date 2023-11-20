package aClasses;

import enums.ItemType;
import interfaces.Hitter;

public abstract class BodyPart implements Hitter {
    private String name;
    protected boolean isHeated;
    private Creature owner;

    public BodyPart(String name, Creature owner) {
        this.name = name;
        this.owner = owner;
    }

    protected String getName() {
        return this.name;
    }

    public void setOwner(Creature creature) {
        this.owner = creature;
    }
    public boolean belongsTo(Creature creature) {
        return this.owner.equals(creature);
    }

    public Creature getOwner() {
        return this.owner;
    }

    @Override
    public String toString() {
        return name;
    }
    protected abstract boolean isHeated();
    public abstract String getState();
    public abstract ItemType getType();


}
