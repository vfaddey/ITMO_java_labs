package aClasses;

import enums.Characteristics;
import base.Location;
import interfaces.Interactable;
import interfaces.Position;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Creature implements Interactable, Position {
    protected String name;
    protected int age;
    private Location location;
    protected ArrayList<Characteristics> characteristics = new ArrayList<>();
    protected Creature lookOnCreature;
    protected Item lookOnItem;
    protected BodyPart lookOnBodyPart;


    public Creature(String name, int age, Location loc, Characteristics... characteristics) {
        this.name = name;
        this.age = age;
        this.location = loc;
        this.characteristics.addAll(Arrays.asList(characteristics));
    }

    public Creature(String name, int age, Characteristics... characteristics) {
        this.name = name;
        this.age = age;
        this.characteristics.addAll(Arrays.asList(characteristics));
    }

    public void setLocation(Location loc) {
        this.location = loc;
        loc.setCreatures(this);
    }

    public Location getLocation() {
        return location;
    }

    public void setType(Characteristics... characteristics) {
        this.characteristics.addAll(Arrays.asList(characteristics));
        if (characteristics.length == 1) {
            System.out.println(this + " " + characteristics[0]);
        }
        else {
            System.out.print(this + " ");
            for (Characteristics characteristic : characteristics) {
                System.out.print(characteristic + ", ");
            }
            System.out.println();
        }
    }

    public boolean hasType(Characteristics characteristic) {
        return characteristics.contains(characteristic);
    }

    public void removeTypes(Characteristics... characteristics) {
        this.characteristics.removeAll(Arrays.asList(characteristics));
        if (characteristics.length == 1)
            System.out.println(name + " больше не " + characteristics[0]);
        else {
            System.out.print(name + " больше не ");
            for (Characteristics characteristic : characteristics) {
                if (characteristic != characteristics[characteristics.length-1])
                    System.out.print(characteristic + ", ");
                else
                    System.out.print(characteristic);
            }
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return name;
    }

    protected abstract void voice(String str);
    protected abstract boolean hears(Creature creature);
    protected abstract void look(Creature creature);
    protected abstract void look(Item item);
    protected abstract void look(BodyPart bodyPart);
    protected abstract void sleep();
    protected abstract void wakeUp();
    protected abstract boolean isSleeping();

}
