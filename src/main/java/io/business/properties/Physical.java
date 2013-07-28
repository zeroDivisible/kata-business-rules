package io.business.properties;

import io.business.Product;

/**
 * @author zerodi
 */
public class Physical extends Property {
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

    @Override
    public String toString() {
        return "{physical = '" + physical + "'}";
    }
}
