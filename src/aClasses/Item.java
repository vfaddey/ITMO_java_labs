package aClasses;


import enums.ItemType;
import base.Location;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public abstract class Item {
    protected boolean interactable = true;
    private Location location;
    private final String name;
    protected ArrayList<ItemType> types = new ArrayList<>();

    public Item(String name) {
        this.name = name;
    }


    protected abstract boolean isInteractable();

    protected void setType(ItemType... types) {
        this.types.addAll(Arrays.asList(types));
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        location.placeItem(this);
        this.location = location;
    }

    public boolean hasType(ItemType type) {
        return this.types.contains(type);
    }

    protected abstract void interact(Creature creature);

    @Override
    public String toString() {
        return name;
    }


    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Item)) return false;
        if (object.hashCode() != this.hashCode()) return false;
        Item otherItem = (Item) object;
        return otherItem.name.equals(this.name) && otherItem.location.equals(this.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, types);
    }
}
