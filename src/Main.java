import aClasses.Item;
import base.Group;
import enums.Characteristics;
import base.Human;
import base.Location;
import enums.ItemType;
import items.Apple;
import bodyParts.Bone;
import items.Dirt;
import phenomenons.Fear;

public class Main {
    public static void main(String[] args) {

        Location woodedHill = new Location("лесистый холм");
        Location cemetery = new Location("кладбище");
        Location lawn = new Location("поляна");


        Item apple = new Apple("яблоко", "красное");
        lawn.placeItem(apple);

        Dirt dirt = new Dirt("грязь");

        Fear fear = new Fear(lawn);

        Bone bones = new Bone("кости");

        Human luis = new Human("Луис", 29, Characteristics.HAPPY, Characteristics.HUNGRY);
        Human paskou = new Human("Паскоу", 20, Characteristics.HUNGRY, Characteristics.SAD);

        Group group = new Group(luis, paskou);

        group.moveTo(woodedHill);
        dirt.interact(luis);

        luis.wakeUp();

        group.moveTo(lawn);
        fear.interact();
        paskou.lough();
        paskou.eyes.expand();

        luis.show(paskou, luis.bones);

        bones.move();
        bones.crawl();
        bones.tremble();

        luis.voice("Ты должен закричать, чтобы проснуться; неважно, что ты скажешь Рэчел, Элли, Гэджу, соседям, ты должен закричать, чтобы проснуться.  Закричатьчтобыпроснутьсязакричатьчтобы..");
        luis.shout();
    }
}
