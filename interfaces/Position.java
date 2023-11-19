package interfaces;

import aClasses.Creature;
import base.Location;

public interface Position {

    void moveTo(Location place);
    void rotateTo(Creature creature);
    Location getLocation();
}
