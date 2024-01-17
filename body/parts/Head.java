package body.parts;

import abstractions.BodyPart;
import abstractions.Creature;
import base.Human;
import enums.Characteristics;
import enums.ItemType;

public class Head extends BodyPart {
    private boolean isHeated;
    public Eyes eyes;
    public Nose nose;
    public Face face;
    public Hair hair;

    public Head(String name, Creature owner) {
        super(name, owner);
        this.eyes = new Eyes("глаза", owner);
        this.nose = new Nose("нос", owner);
        this.face = new Face("лицо", owner);
        this.hair = new Hair("темные", owner);
    }

    @Override
    protected String getName() {
        return null;
    }

    @Override
    public boolean isHeated() {
        return isHeated;
    }

    @Override
    public void hit() {
        isHeated = true;
        this.eyes.hit();
        this.face.hit();
        this.nose.hit();
        System.out.println(this + " сломана");
        if (getOwner() instanceof Human) {
            ((Human)getOwner()).shout();
        }
    }

    @Override
    public ItemType getType() {
        return null;
    }

    public class Hair extends BodyPart {
        private String color;
        private boolean isHeated = false;

        public Hair(String color, Creature owner) {
            super("волосы", owner);
            this.color = color;
        }
        @Override
        protected String getName() {
            return null;
        }

        @Override
        public boolean isHeated() {
            return isHeated;
        }

        @Override
        public void hit() {
            this.isHeated = true;
            System.out.println(this + " выдраны");
        }


        @Override
        public ItemType getType() {
            return null;
        }
    }

    public class Nose extends BodyPart {
        public Nose(String name, Creature owner) {
            super(name, owner);
        }

        @Override
        protected String getName() {
            return null;
        }

        @Override
        public boolean isHeated() {
            return false;
        }

        @Override
        public void hit() {
            isHeated = true;
            System.out.println(this + " сломан");
        }

        @Override
        public ItemType getType() {
            return null;
        }
    }

    public class Face extends BodyPart {
        private boolean isHeated;

        public Face(String name, Creature owner) {
            super(name, owner);
        }

        public Face(String name, Creature owner, boolean isHeated) {
            super(name, owner);
            this.isHeated = isHeated;
        }

        @Override
        public boolean isHeated() {
            return isHeated;
        }

        @Override
        public ItemType getType() {
            return null;
        }

        public void getDown() {
            System.out.println(this + getOwner().toString() + "опустилось вниз");
        }

        @Override
        public void hit() {
            isHeated = true;
            System.out.println(this + " истекает кровью");
            if (getOwner() instanceof Human) {
                ((Human)getOwner()).shout();
            }
        }
    }

    public class Eyes extends BodyPart {
        private String color;
        private int quantity;
        private boolean closed;
        private boolean isHeated;
        public Eyes(String name, Creature owner) {
            super(name, owner);
        }
        public Eyes(String color, Creature owner, boolean closed, int quantity) {
            super("глаза", owner);
            this.color = color;
            this.closed = closed;
            this.quantity = quantity;

        }

        public void open() {
            this.closed = false;
            System.out.println(getOwner() + " открыл " + getName());
        }

        public boolean areClosed() {
            return closed;
        }

        public void close() {
            this.closed = true;
            System.out.println(getOwner() + " открыл " + getName());
        }

        @Override
        public boolean isHeated() {
            return isHeated;
        }

        @Override
        public void hit() {
            isHeated = true;
            System.out.println(this + " повреждены");
            if (getOwner() instanceof Human) {
                ((Human)getOwner()).shout();
            }
        }

        public void expand() {
            System.out.println(this + " " + getOwner() + " расширились");
            getOwner().addTypes(Characteristics.SCARED);
        }


        @Override
        public ItemType getType() {
            return null;
        }

    }
}
