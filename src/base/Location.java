package base;

import aClasses.Creature;
import aClasses.Item;
import aClasses.Phenomenon;

import java.util.ArrayList;
import java.util.Arrays;


public class Location {
    private final String name;
    private ArrayList<Creature> creatures = new ArrayList<>();
    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Phenomenon> phenomenons = new ArrayList<>();

    public Location(String name) {
        this.name = name;
    }

    public Location(String name, Item... items) {
        this.name = name;
        this.items.addAll(Arrays.asList(items));
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void placeItem(Item item) {
        items.add(item);
    }
    public void setItems(Item... items) {
        this.items.addAll(Arrays.asList(items));
    }

    public void setCreatures(Creature... creatures) {
        this.creatures.addAll(Arrays.asList(creatures));
    }

    public void removeCreatures(Creature... creatures) {
        for (Creature creature : creatures) {
            this.creatures.remove(creature);
        }
    }

    public Creature[] getCreatures() {
        Creature[] creatures = new Creature[this.creatures.size()];
        return this.creatures.toArray(creatures);
    }

    public Item[] getItems() {
        Item[] items = new Item[this.items.size()];
        return this.items.toArray(items);
    }

    public void setPhenomenon(Phenomenon... phenomenon) {
        this.phenomenons.addAll(Arrays.asList(phenomenon));
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
