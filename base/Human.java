package base;

import aClasses.BodyPart;
import aClasses.Creature;
import aClasses.Item;
import bodyParts.*;
import enums.Characteristics;
import enums.ItemType;
import items.Dirt;

import java.util.ArrayList;
import java.util.Arrays;


public class Human extends Creature {

    private final ArrayList<Item> inventory = new ArrayList<>();
    public BodyPart bones = new Bone("кости");
    public BodyPart body = new Body("тело");
    public Eyes eyes = new Eyes("зеленые", true, 2);
    public BodyPart nose = new Nose();
    public BodyPart hair = new Hair("темные");
    public BodyPart hands = new Hands(2, false);
    public BodyPart legs = new Legs();
    public BodyPart head = new Head(eyes, nose);

    public Human(String name, int age, Location loc, Characteristics... characteristics) {
        super(name, age, loc, characteristics);
        loc.setCreatures(this);
    }

    public Human(String name, int age, Characteristics... characteristics) {
        super(name, age, characteristics);
    }

    private void setBodyParts(BodyPart... bodyParts) {

    }

    public void lough() {
        if (characteristics.contains(Characteristics.HAPPY)) {
            System.out.println(name + " громко посмеялся");
        }
        else if (characteristics.contains(Characteristics.SAD)) {
            System.out.println(name + " не посмеялся. Ему грустно");
        }
    }

    public void shout() {
        if (Math.random() < .4d) {
            System.out.println(this + " попытался закричать, но не смог");
            for (Creature creature : getLocation().getCreatures()) {
                creature.setType(Characteristics.SCARED);
            }
        }
        else {
            System.out.println(this + " закричал");
        }
    }

    @Override
    public void voice(String str) {
        System.out.println(name + " сказал: " + str);
    }

    public void sayTo(String phrase,Human human) {
        if (human.hears(this)) {
            System.out.println(this + " сказал " + human + "у: " + phrase);
            System.out.println(human + " его услышал");
        }
        else {
            System.out.println(this + " сказал " + human + "у: " + phrase);
            System.out.println("Но " + human + " его не услышал");
        }
    }

    @Override
    public boolean hears(Creature creature) {
        if (Math.random() < 0.5d) return true;
        return this.getLocation() == creature.getLocation();
    }

    @Override
    protected void look(Creature creature) {
        lookOnCreature = creature;
        lookOnItem = null;
        lookOnBodyPart = null;
        System.out.println(name + " посмотрел на " + creature);
    }

    @Override
    protected void look(Item item) {
        lookOnItem = item;
        lookOnBodyPart = null;
        lookOnCreature = null;
        System.out.println(name + " посмотрел на " + item);
    }

    @Override
    protected void look(BodyPart bodyPart) {
        lookOnBodyPart = bodyPart;
        lookOnCreature = null;
        lookOnItem = null;
        System.out.println(name + " посмотрел на " + bodyPart);
    }

    @Override
    public void take(Item item) {
        if ((Arrays.asList(this.getLocation().getItems())).contains(item)) {
            if (item.hasType(ItemType.HEAVY)) {
                if (this.characteristics.contains(Characteristics.STRONG)) {
                    inventory.add(item);
                    getLocation().removeItem(item);
                    System.out.println(this + " подобрал тяжелый " + item + ", потому что он" + Characteristics.STRONG);
                }
                else if (Math.random() < 0.1d) {
                    inventory.add(item);
                    getLocation().removeItem(item);
                    System.out.println(this + " с трудом поднял тяжелый " + item);
                }
                else System.out.println(this + " не может взять " + item + ", он слишком тяжелый");
            }
            else{
                inventory.add(item);
                getLocation().removeItem(item);
                System.out.println(this + " подобрал " + item);
            }
        }
        else {
            System.out.println(this + " не может взять " + item + ", оно далеко");
        }

    }

    @Override
    public void put(Item item) {
        if (this.has(item)) {
            inventory.remove(item);
            getLocation().placeItem(item);
            System.out.println(this + " положил " + item);
        }
        else {
            System.out.println(this + " не может положить " + item);
        }

    }

    @Override
    public void sleep() {
        if (Math.random() < 0.4d) {
            characteristics.add(Characteristics.SLEEP);
        }
        else {
            System.out.println(this + " тщетно пытался заснуть");
        }
    }

    @Override
    public boolean isSleeping() {
        return characteristics.contains(Characteristics.SLEEP);
    }

    @Override
    public void wakeUp() {
        if (Math.random() < 0.4d) {
            characteristics.remove(Characteristics.SLEEP);
            System.out.println(this + " проснулся");
        }
        else {
            System.out.println(this + " тщетно пытался проснуться");
        }

    }

    public void showInventory() {
        System.out.println("У " + this + " есть");
        for (Item item: inventory) {
            System.out.println(item);
        }
    }

    public boolean has(Item item) {
        return inventory.contains(item);
    }

    public void hit(BodyPart bodyPart) {
        bodyPart.hit();
    }

    public void heatSmbBodyPart(Creature creature, BodyPart bodyPart) {
        bodyPart.hit();
        System.out.println(this + " повредил " + bodyPart + ", которая принадлежит" + creature);
    }

    public void show(Human person, Item item) {
        System.out.println(this + " указал " + person + " на " + item);
        person.look(item);
    }

    public void show(Human person, BodyPart bodyPart) {
        System.out.println(this + " указал " + person + " на " + bodyPart);
        person.look(bodyPart);
    }

    @Override
    public void moveTo(Location place) {
        getLocation().removeCreatures(this);
        setLocation(place);
        place.setCreatures(this);
        if (characteristics.contains(Characteristics.DIRTY)) {
            getLocation().setItems(new Dirt("грязь"));
            System.out.println(name + " пришел на " + place + ", оставив за собой грязные следы");
        }
        else System.out.println(name + " пришел на " + place);
    }

    @Override
    public void rotateTo(Creature creature) {
        System.out.println(this + " повернулся к " + creature);
        look(creature);
    }

    @Override
    public void eat(Item item) {
        if (item.hasType(ItemType.EDIBLE) && this.hasType(Characteristics.HUNGRY) && this.has(item)) {
            System.out.println(this + " съел " + item);
            this.removeTypes(Characteristics.HUNGRY);
        }
        else if (item.hasType(ItemType.EDIBLE) && !this.hasType(Characteristics.HUNGRY) && this.has(item)){
            System.out.println(this + " не стал есть " + item + ", он не голодный");
        }
        else if (item.hasType(ItemType.EDIBLE) && this.hasType(Characteristics.HUNGRY) && this.has(item)) {
            System.out.println(this + "не стал есть " + item + ", хотя хотел есть");
        }
        else {
            System.out.println(this + "не стал есть " + item + ", оно не съедобное");
        }
    }

}
