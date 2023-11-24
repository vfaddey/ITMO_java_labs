package aClasses;

import base.Location;

public abstract class Phenomenon {
    private String name;
    private Location location;

    public Phenomenon(String name, Location location) {
        this.name = name;
        this.location = location;
        location.setPhenomenon(this);
    }

    public abstract void interact();
}
