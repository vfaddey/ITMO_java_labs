package items;

import aClasses.Creature;
import aClasses.Item;
import enums.Characteristics;
import enums.ItemType;

public class Dirt extends Item {
    protected boolean interactable = false;


    public Dirt(String name) {
        super(name);
        setType(ItemType.LIQUID, ItemType.CREEPY);
    }

    @Override
    public void interact(Creature creature) {
        System.out.println(this + " просачивается в конечностях " + creature);
        creature.setType(Characteristics.DIRTY);
    }

    @Override
    public boolean isInteractable() {
        return  interactable;
    }


}
