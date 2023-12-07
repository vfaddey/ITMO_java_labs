package items;

import abstractions.Creature;
import abstractions.Item;
import base.Location;
import interfaces.Transformer;

public class Brushwood extends Item implements Transformer {

    public Brushwood(String name, Location location) {
        super(name);
        location.setItems(this);
        super.setLocation(location);
    }

    @Override
    protected boolean isInteractable() {
        return false;
    }

    @Override
    protected void interact(Creature creature) {

    }

    @Override
    public void transformInto(Item item) {
        if (!this.equals(item)) {
            getLocation().placeItem(item);
            getLocation().removeItem(this);
            System.out.println(this + " превратился в " + item);
        }
    }

}
