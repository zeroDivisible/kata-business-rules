package io.business.properties;

/**
 * @author zerodi
 */
public class Physical implements Property {
    private boolean physical;

    public Physical(boolean physical) {
        this.physical = physical;
    }

    public boolean isPhysical() {
        return physical;
    }

    public void setPhysical(boolean physical) {
        this.physical = physical;
    }
}
