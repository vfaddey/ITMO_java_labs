package items;

import aClasses.Creature;
import aClasses.Item;
import enums.ItemType;
import interfaces.Hitter;

public class Apple extends Item implements Hitter {
    private final String color;
    private boolean isPoisoned = false;

    public Apple(String name, String color) {
        super(name);
        this.color = color;
        setType(ItemType.EDIBLE);
    }

    public Apple(String name, String color, boolean poisoned) {
        super(name);
        this.color = color;
        this.isPoisoned = poisoned;
        setType(ItemType.EDIBLE);
    }

    @Override
    public boolean isInteractable() {
        return true;
    }

    @Override
    public void interact(Creature creature) {
    }

    public String getColor() {
        return color;
    }

    @Override
    public void hit() {

    }
}
