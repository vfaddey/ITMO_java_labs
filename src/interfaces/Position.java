package interfaces;

import abstractions.Creature;
import base.Location;

public interface Position {
    void moveTo(Location place);
    void rotateTo(Creature creature);
    Location getLocation();
}
