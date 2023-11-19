package bodyParts;

import aClasses.BodyPart;

public class Nose extends BodyPart {
    public Nose() {
        super("нос");
    }

    @Override
    protected String getName() {
        return null;
    }

    @Override
    protected boolean isHeated() {
        return false;
    }

    @Override
    public void hit() {

    }

    @Override
    public String getState() {
        return null;
    }
}
