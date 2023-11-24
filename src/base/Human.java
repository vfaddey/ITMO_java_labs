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
    public Bone bones = new Bone("кости", this);
    public Body body = new Body("тело", this);
    public Hair hair = new Hair("темные", this);
    public Hands hands = new Hands("руки", 2, this, false);
    public Legs legs = new Legs("ноги", this);
    public Head head = new Head("голова", this);

    public Human(String name, int age, Location loc, Characteristics... characteristics) {
        super(name, age, loc, characteristics);
        loc.setCreatures(this);
    }

    public Human(String name, int age, Characteristics... characteristics) {
        super(name, age, characteristics);
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
        }
        else {
            System.out.println(this + " закричал");
            for (Creature creature : getLocation().getCreatures()) {
                if (!creature.hasType(Characteristics.SCARED)) creature.setType(Characteristics.SCARED);
            }
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
        if (bodyPart.getType() == ItemType.CREEPY) {
            this.head.eyes.expand();
        }
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

    public void fallOnKnees() {
        this.legs.bend();
        this.setType(Characteristics.KNEELING);
    }

    @Override
    public void moveTo(Location place) {
        if (this.hasType(Characteristics.KNEELING)) {
            System.out.println(this + "не может идти, он" + Characteristics.KNEELING);
        }
        else {
            getLocation().removeCreatures(this);
            setLocation(place);
            place.setCreatures(this);
            if (characteristics.contains(Characteristics.DIRTY)) {
                getLocation().setItems(new Dirt("грязь"));
                System.out.println(name + " пришел на " + place + ", оставив за собой грязные следы");
            }
            else System.out.println(name + " пришел на " + place);
        }

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


    public boolean equals(Object object) {
        if (this == object) return true;
        if (this.getClass() == object.getClass() && this.name.equals(((Human) object).name) && this.head.getOwner() == ((Human) object).head.getOwner()) {
            return true;
        }
        Human human = (Human) object;
        return this.characteristics == human.characteristics;
    }
}
