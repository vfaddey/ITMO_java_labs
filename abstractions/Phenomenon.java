package abstractions;

import base.Location;

public abstract class Phenomenon {
    private final String name;
    private final Location location;

    public Phenomenon(String name, Location location) {
        this.name = name;
        this.location = location;
        location.setPhenomenon(this);
    }

    public Location getLocation() {
        return location;
    }

    public abstract void interact();

    @Override
    public String toString() {
        return name;
    }


}
