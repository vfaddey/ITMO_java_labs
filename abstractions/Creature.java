package abstractions;

import enums.Characteristics;
import base.Location;
import exceptions.InvalidAgeException;
import interfaces.Position;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

public abstract class Creature implements Position {
    protected String name;
    protected int age;
    protected Location location;
    protected HashSet<Characteristics> characteristics = new HashSet<>();
    protected Creature lookOnCreature;
    protected Item lookOnItem;
    protected BodyPart lookOnBodyPart;


    public Creature(String name, int age, Location loc, Characteristics... characteristics) throws InvalidAgeException {
        this.name = name;
        try {
            setAge(age);
        }
        catch (InvalidAgeException e) {
            System.out.println(e.toString());
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
            System.out.println(e.toString());
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
        } else if (age > 200) {
            throw new InvalidAgeException("Возраст не модет быть больше 200");
        } else {
            this.age = age;
        }
    }

    public Location getLocation() {
        return location;
    }

    public void addTypes(Characteristics... characteristics) {
        if (characteristics.length == 1) {
            if (!this.characteristics.contains(characteristics[0])) {
                this.characteristics.add(characteristics[0]);
                System.out.println(this + " " + characteristics[0]);
            }
        } else {
            System.out.println(this + " ");
            for (Characteristics characteristic : characteristics) {
                if (!this.characteristics.contains(characteristic)) {
                    this.characteristics.add(characteristic);
                    System.out.print(characteristic + ", ");
                }
            }
            System.out.println();
        }
    }


    public boolean hasType(Characteristics characteristic) {
        return characteristics.contains(characteristic);
    }

    public void removeTypes(Characteristics... characteristics) {
        Arrays.asList(characteristics).forEach(this.characteristics::remove);
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

    public abstract void voice(String str);
    protected abstract boolean hears(Creature creature);
    public abstract void look(Creature creature);
    public abstract void look(Item item);
    public abstract void look(BodyPart bodyPart);
    public abstract void sleep();
    public abstract void wakeUp();


}
