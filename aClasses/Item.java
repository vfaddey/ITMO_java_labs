package aClasses;


import enums.ItemType;
import base.Location;

import java.util.ArrayList;
import java.util.Arrays;

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

    public Location getLocation(Location location) {
        return this.location;
    }

    public boolean hasType(ItemType type) {
        return this.types.contains(type);
    }

    protected abstract void interact(Creature creature);

    @Override
    public String toString() {
        return name;
    }


}
