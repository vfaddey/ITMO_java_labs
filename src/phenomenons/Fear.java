package phenomenons;

import aClasses.Creature;
import aClasses.Phenomenon;
import base.Human;
import base.Location;

import enums.Characteristics;
import interfaces.Hitter;

public class Fear extends Phenomenon implements Hitter {

    public Fear(String name, Location location) {
        super(name, location);
    }

    @Override
    public void interact() {
        System.out.println(this + " нарастал");
        hit();
    }

    @Override
    public void hit() {
        for (Creature creature : getLocation().getCreatures()) {
            creature.setType(Characteristics.SCARED);
            for (Creature person : getLocation().getCreatures()) {
                ((Human) person).bones.tremble();
                ((Human) person).bones.crawl();
                ((Human) person).bones.move();
            }
        }
    }
}
