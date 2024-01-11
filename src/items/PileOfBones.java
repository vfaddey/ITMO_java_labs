package items;

import abstractions.Creature;
import abstractions.Item;

public class PileOfBones extends Item {
    public PileOfBones(String name) {
        super(name);
    }

    @Override
    protected boolean isInteractable() {
        return false;
    }

    @Override
    public void interact(Creature creature) {

    }
}
