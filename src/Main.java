import aClasses.Item;
import base.Group;
import body.parts.Bone;
import enums.Characteristics;
import base.Human;
import base.Location;
import enums.WeatherType;
import items.Apple;
import items.Brushwood;
import items.Dirt;
import items.PileOfBones;
import phenomenons.Fear;
import weather.Weather;

public class Main {
    public static void main(String[] args) {

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

        System.out.println(luis.equals(paskou));

    }
}
