package body;

import abstractions.BodyPart;
import abstractions.Creature;
import base.Human;
import body.parts.Hands;
import body.parts.Legs;
import enums.Characteristics;
import enums.ItemType;

public class Body extends BodyPart {

    private final Hands hands = new Hands("руки", 2, getOwner(), false);
    private final Legs legs = new Legs("ноги", getOwner());
    private boolean isHeated;

    public Body(String name, Creature owner) {
        super(name, owner);
    }

    @Override
    public boolean isHeated() {
        return isHeated;
    }

    @Override
    public void hit() {
        this.isHeated = true;
        System.out.println(getName() + " сломано");
        if (getOwner() instanceof Human) {
            ((Human) getOwner()).shout();
        }
    }

    public Hands getHands() {
        return hands;
    }

    public Legs getLegs() {
        return legs;
    }
    @Override
    public ItemType getType() {
        return null;
    }

    public static class Bone extends BodyPart {
        private String name;
        private boolean isHeated;
        private ItemType type;

        public Bone(String name, Creature owner) {
            super(name, owner);
        }


        public void tremble() {
            if (getOwner() != null) {
                for (Creature other : getOwner().getLocation().getCreatures()) {
                    if (!other.hasType(Characteristics.SCARED))
                        other.addTypes(Characteristics.SCARED);
                }
                System.out.println(this + " " + getOwner() + " дрожат");
            }
            else {
                System.out.println(this + " " + getOwner() + " дрожат");
            }
            this.type = ItemType.CREEPY;
        }

        public void move() {
            if (getOwner() != null) {
                for (Creature other : getOwner().getLocation().getCreatures()) {
                    if (!other.hasType(Characteristics.SCARED))
                        other.addTypes(Characteristics.SCARED);
                }
                System.out.println(this + " " + getOwner() + " шевелятся");
            }
            else {
                System.out.println(this + " " + getOwner() + " шевелятся");
            }
            this.type = ItemType.CREEPY;
        }

        public void crawl() {
            if (getOwner() != null) {
                for (Creature other : getOwner().getLocation().getCreatures()) {
                    if (!other.hasType(Characteristics.SCARED))
                        other.addTypes(Characteristics.SCARED);
                }
                System.out.println(this + " " + getOwner() + " ползают");
            }
            else {
                System.out.println(this + " " + getOwner() + " ползают");
            }
            this.type = ItemType.CREEPY;
        }

        @Override
        protected String getName() {
            return name;
        }

        @Override
        public boolean isHeated() {
            return isHeated;
        }

        @Override
        public void hit() {
            isHeated = true;
            System.out.println(this + " сломаны");
            if (getOwner() instanceof Human) {
                ((Human)getOwner()).shout();
            }
        }


        @Override
        public ItemType getType() {
            return this.type;
        }
    }
}
