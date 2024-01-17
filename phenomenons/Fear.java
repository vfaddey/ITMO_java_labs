package phenomenons;

import abstractions.Creature;
import abstractions.Phenomenon;
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
            creature.addTypes(Characteristics.SCARED);
            for (Creature person : getLocation().getCreatures()) {
                if (person instanceof Human) {
                    ((Human) person).getBones().tremble();
                    ((Human) person).getBones().crawl();
                    ((Human) person).getBones().move();
                }
                person.addTypes(Characteristics.WEAK);
            }
        }
    }
}
