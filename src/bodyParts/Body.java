package bodyParts;

import aClasses.BodyPart;

public class Body extends BodyPart {
    private boolean isHeated;

    public Body(String name) {
        super(name);
    }

    @Override
    protected boolean isHeated() {
        return false;
    }

    @Override
    public void hit() {
        this.isHeated = true;
        System.out.println(getName() + " сломано");
    }

    @Override
    public String getState() {
        return null;
    }
}
