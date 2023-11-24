package base;

import aClasses.Creature;
import interfaces.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Group implements Position {
    private ArrayList<Human> people = new ArrayList<>();

    public Group(Human... people) {
        this.people.addAll(Arrays.asList(people));
    }

    @Override
    public void moveTo(Location place) {
        for (Human person: people) {
            person.setLocation(place);
        }
        System.out.println(this + " пришли на " + place);
    }

    @Override
    public void rotateTo(Creature creature) {
        for (Human person: people) {
            person.look(creature);
        }
    }

    @Override
    public Location getLocation() {
        for (int i = 1; i < people.size(); i++) {
            if (!people.get(i).getLocation().equals(people.get(0).getLocation()))
                return null;
        }
        return people.get(0).getLocation();
    }

    @Override
    public String toString() {
        return "Они";
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Group)) return false;
        Group otherGroup = (Group) object;
        if (this.people.size() != otherGroup.people.size()) return false;
        int sumThis = 0, sumOther = 0;
        for (int i = 0; i < people.size(); i++) {
            sumThis += this.people.get(i).hashCode();
            sumOther += this.people.get(i).hashCode();
        }
        return sumThis == sumOther;
    }
}
