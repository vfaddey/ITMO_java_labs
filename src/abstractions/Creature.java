package abstractions;

import enums.Characteristics;
import base.Location;
import exceptions.InvalidAgeException;
import exceptions.LocationException;
import interfaces.Interactable;
import interfaces.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public abstract class Creature implements Position {
    protected String name;
    protected int age;
    private Location location;
    protected ArrayList<Characteristics> characteristics = new ArrayList<>();
    protected Creature lookOnCreature;
    protected Item lookOnItem;
    protected BodyPart lookOnBodyPart;


    public Creature(String name, int age, Location loc, Characteristics... characteristics) throws InvalidAgeException {
        this.name = name;
        try {
            setAge(age);
        }
        catch (InvalidAgeException e) {
            System.out.println(e);
            setAge(18);
        }
        this.location = loc;
        this.characteristics.addAll(Arrays.asList(characteristics));
    }

    public Creature(String name, int age, Characteristics... characteristics) throws InvalidAgeException {
        this.name = name;
        try {
            setAge(age);
        }
        catch (InvalidAgeException e) {
            System.out.println(e);
            setAge(18);
        }
        this.characteristics.addAll(Arrays.asList(characteristics));
    }

    public void setLocation(Location loc) {
        this.location = loc;
        loc.setCreatures(this);
    }

    private void setAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Возраст не может быть меньше нуля");
        }
        else {
            this.age = age;
        }
    }

    public Location getLocation() {
        return location;
    }

    public void addTypes(Characteristics... characteristics) {
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

    public void setTypes(Characteristics... characteristics) {
        this.characteristics = (ArrayList<Characteristics>) Arrays.asList(characteristics);
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

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    protected abstract void voice(String str);
    protected abstract boolean hears(Creature creature);
    public abstract void look(Creature creature);
    public abstract void look(Item item);
    public abstract void look(BodyPart bodyPart);
    protected abstract void sleep();
    protected abstract void wakeUp();
    protected abstract boolean isSleeping();

}
