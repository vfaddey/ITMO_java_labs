package bodyParts;

import aClasses.BodyPart;

public class Face extends BodyPart {
    private boolean isHeated;

    public Face(String name) {
        super(name);
    }

    public Face(String name, boolean isHeated) {
        super(name);
        this.isHeated = isHeated;
    }

    @Override
    protected boolean isHeated() {
        return isHeated;
    }

    @Override
    public String getState() {
        return null;
    }

    @Override
    public void hit() {

    }
}
