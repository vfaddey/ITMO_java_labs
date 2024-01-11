import abstractions.Creature;
import abstractions.Item;
import base.Group;
import body.parts.Head;
import enums.Characteristics;
import base.Human;
import base.Location;
import enums.ItemType;
import enums.Language;
import enums.WeatherType;
import exceptions.InvalidAgeException;
import exceptions.LocationException;
import interfaces.Eater;
import items.*;
import phenomenons.Fear;
import weather.Weather;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws LocationException, InvalidAgeException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        class World {
            private String name;
            private ArrayList<Location> locations = new ArrayList<>();
            public World(String name, Location... locations) {
                this.name = name;
                this.locations.addAll(List.of(locations));
            }

            public void spin() {
                System.out.println(name + " завертелся вокруг");
                for (Location location : this.locations){
                    for (Creature creature : location.getCreatures()) {
                        creature.addTypes(Characteristics.ASTONISHED);
                        if (creature instanceof Human) {
                            ((Human) creature).shout();
                        }
                    }
                }
            }

            @Override
            public String toString() {
                return name;
            }
        }


        Location woodedHill = new Location("лесистый холм");
        Location cemetery = new Location("кладбище");
        Location lawn = new Location("поляна");
        Item apple = new Apple("яблоко", "красное");
        lawn.placeItem(apple);
        Dirt dirt = new Dirt("грязь");
        Fear fear = new Fear("ужас", lawn);
        Human luis = new Human("Луис", 29, Characteristics.HAPPY, Characteristics.HUNGRY);
        Human paskou = new Human("Паскоу", 20, Characteristics.HUNGRY, Characteristics.SAD);
        Group group = new Group(luis, paskou);
        Weather weather = new Weather(WeatherType.MOON, WeatherType.DARK);
        PileOfBones pileOfBones = new PileOfBones("груда костей");
        Brushwood brushwood = new Brushwood("валежник", lawn);

        World world = new World("Мир", woodedHill, cemetery, lawn);

        luis.setLanguages(Language.RUSSIAN, Language.ENGLISH);
        paskou.setLanguages(Language.RUSSIAN, Language.ENGLISH, Language.UNKNOWN);

        Item memorial = new Item("памятник") {
            @Override
            protected boolean isInteractable() {
                return false;
            }

            @Override
            public void interact(Creature creature) {
                System.out.println(this + "повалился на землю");
            }
        };
        memorial.setType(ItemType.HEAVY);
        memorial.setLocation(lawn);



        group.moveTo(woodedHill);
        dirt.interact(luis);
        luis.wakeUp();
        group.moveTo(lawn);
        fear.interact();
        brushwood.transformInto(pileOfBones);
        weather.getState();
        luis.fallOnKnees();
        luis.show(paskou, luis.bones);
        luis.voice("Ты должен закричать, чтобы проснуться; неважно, что ты скажешь Рэчел, Элли, Гэджу, соседям, ты должен закричать, чтобы проснуться.  Закричатьчтобыпроснутьсязакричатьчтобы..");
        luis.head.face.hit();
        paskou.sayTo("Я пришел как друг", luis);

        try {
            luis.show(paskou, memorial);
        }
        catch (LocationException e) {
            System.out.println(e.toString());
        }
        paskou.sayToOnLanguage("*что то*", luis, Language.UNKNOWN);
        luis.touch(memorial);

        world.spin();


    }
}
