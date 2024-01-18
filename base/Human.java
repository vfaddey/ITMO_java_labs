package base;

import abstractions.BodyPart;
import abstractions.Creature;
import abstractions.Item;
import body.Body;
import body.parts.*;
import enums.Characteristics;
import enums.Conditions;
import enums.ItemType;
import enums.Language;
import exceptions.InvalidAgeException;
import exceptions.LanguageException;
import exceptions.LocationException;
import interfaces.Eater;
import interfaces.Interactable;
import items.Dirt;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;


public class Human extends Creature implements Eater, Interactable {

    private final ArrayList<Item> inventory = new ArrayList<>();
    private final HashSet<Conditions> conditions = new HashSet<>();
    private final HashSet<Language> languages = new HashSet<>();
    private final Body.Bone bones = new Body.Bone("кости", this);
    private final Body body = new Body("тело", this);
    private final Head head = new Head("голова", this);

    public Human(String name, int age, Location loc, Characteristics... characteristics) throws InvalidAgeException {
        super(name, age, loc, characteristics);
        loc.setCreatures(this);
    }

    public Human(String name, int age, Characteristics... characteristics) throws InvalidAgeException {
        super(name, age, characteristics);
    }

    public HashSet<Conditions> getConditions() {
        return conditions;
    }

    public void setConditions(Conditions... conditions) {
        this.conditions.addAll(Arrays.asList(conditions));
    }
    public Head getHead() {
        return head;
    }

    public Body getBody() {
        return body;
    }

    public Body.Bone getBones() {
        return bones;
    }

    public void setLanguages(Language... languages) {
        this.languages.addAll(Arrays.asList(languages));
    }

    public boolean knowsLanguage(Language language) {
        return this.languages.contains(language);
    }

    public void laugh() {
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
                if (!creature.hasType(Characteristics.SCARED)) {
                    creature.addTypes(Characteristics.SCARED);
                    if (creature instanceof Human) {
                        creature.look(this);
                    }
                }
            }
        }
    }

    @Override
    public void voice(String str) {
        System.out.println(name + " сказал: " + str);
        if (this.location.hasEcho()) {
            if (Math.random() < 0.5d) {
                System.out.println("Звук отразился и " + this + " услышал эхо");
            }
        }
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

    public void sayToOnLanguage(String phrase, Human human, Language language) throws LanguageException {
        if (!this.knowsLanguage(language)) {
            throw new LanguageException(this + " не знает этого языка");
        }
        if (human.knowsLanguage(language)) {
            if (human.hears(this)) {
                System.out.println(this + " сказал на " + language + " языке " + human + "у: " + phrase);
                System.out.println(human + " его услышал");
            }
            else {
                System.out.println(this + " сказал на " + language + " языке " + human + "у: " + phrase);
                System.out.println("Но " + human + " его не услышал");
            }
        }
        else if (human.hears(this)) {
            if (Math.random() < 0.3d) {
                System.out.println(this + " сказал на " + language + " языке " + human + "у: " + phrase);
                System.out.println(human + "с трудом понял, что сказал" + this);
            }
        }
        else {
            System.out.println(this + " сказал на " + language + " языке " + human + "у: " + phrase);
            System.out.println(human + "не понимал этого языка");
        }
    }

    @Override
    public boolean hears(Creature creature) {
        if (Math.random() < 0.5d) return true;
        return this.getLocation() == creature.getLocation();
    }

    @Override
    public void look(Creature creature) {
        lookOnCreature = creature;
        lookOnItem = null;
        lookOnBodyPart = null;
        System.out.println(name + " посмотрел на " + creature);
    }

    @Override
    public void look(Item item) {
        lookOnItem = item;
        lookOnBodyPart = null;
        lookOnCreature = null;
        System.out.println(name + " посмотрел на " + item);
    }

    @Override
    public void look(BodyPart bodyPart) {
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

    public void touch(Item item) {
        if (item.isInteractable()) {
            System.out.println(this + " задел " + item);
            if (Math.random() < 0.3d) {
                try{
                    Method interactMethod = item.getClass().getMethod("interact", Creature.class);
                    interactMethod.invoke(item, this);
                } catch (NoSuchMethodException | SecurityException | InvocationTargetException | IllegalAccessException ignored) {

                }

            }
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
            conditions.add(Conditions.SLEEP);
            this.getHead().eyes.close();
        }
        else {
            System.out.println(this + " тщетно пытался заснуть");
        }
    }


    @Override
    public void wakeUp() {
        if (Math.random() < 0.4d) {
            conditions.remove(Conditions.SLEEP);
            this.getHead().eyes.open();
            System.out.println(this + " проснулся");
        }
        else {
            System.out.println(this + " тщетно пытался проснуться");
        }

    }


    public boolean has(Item item) {
        for (Item ownItem : inventory) {
            if (ownItem.equals(item)) return true;
        }
        return false;
    }

    public void hit(BodyPart bodyPart) {
        bodyPart.hit();
    }

    public void hitSmbBodyPart(Creature creature, BodyPart bodyPart) {
        if (bodyPart.belongsTo(creature)) {
            bodyPart.hit();
            System.out.println(this + " повредил " + bodyPart + ", которая принадлежит" + creature);
        }

    }

    public void show(Human person, Item item) throws LocationException {
        if (getLocation().containsItem(item)) {
            System.out.println(this + " указал " + person + " на " + item);
            person.look(item);
        }
        else {
            throw new LocationException("В данной локации нет " + item + ", на него нельзя указать");
        }
    }

    public void show(Human person, BodyPart bodyPart) {
        if (person != this) {
            System.out.println(this + " указал " + person + " на " + bodyPart);
            person.look(bodyPart);
        }
    }

    public void fallOnKnees() {
        this.body.getLegs().bend();
        this.setConditions(Conditions.KNEELING);
    }

    @Override
    public void moveTo(Location place) {
        if (this.conditions.contains(Conditions.KNEELING)) {
            System.out.println(this + "не может идти, он" + Conditions.KNEELING);
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

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Human person)) return false;
        if (this.hashCode() != object.hashCode()) return false;
        return person.name.equals(this.name) && person.age == this.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, getLocation(), inventory);
    }

}
