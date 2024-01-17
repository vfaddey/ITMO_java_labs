package abstractions;

import enums.ItemType;
import interfaces.Hitter;

import java.util.Objects;

public abstract class BodyPart implements Hitter {
    private final String name;
    protected boolean isHeated;
    private final Creature owner;

    public BodyPart(String name, Creature owner) {
        this.name = name;
        this.owner = owner;
    }

    protected String getName() {
        return this.name;
    }
    public boolean belongsTo(Creature creature) {
        return this.owner.equals(creature);
    }

    public abstract boolean isHeated();
    public Creature getOwner() {
        return this.owner;
    }

    @Override
    public String toString() {
        if (owner == null) return "";
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
    public abstract ItemType getType();


}
