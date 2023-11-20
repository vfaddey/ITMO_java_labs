package phenomenons;

import aClasses.Creature;
import aClasses.Phenomenon;
import base.Location;

import enums.Characteristics;
import interfaces.Hitter;

public class Fear extends Phenomenon implements Hitter {
    private Location location;
    private String name = "ужас";

    public Fear(Location location) {
        this.location = location;
        location.setPhenomenon(this);
    }

    public Fear(String name, Location location) {
        this.name = name;
        this.location = location;
        location.setPhenomenon(this);
    }

    public void interact() {
        System.out.println(this + " нарастал");
        hit();
    }

    @Override
    public void hit() {
        for (Creature creature : this.location.getCreatures()) {
            creature.setType(Characteristics.SCARED);
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
