package io.business.conditions;

import io.business.properties.Physical;
import io.business.properties.Property;

/**
 * @author zerodi
 */
public class IsPhysical implements Condition {

    @Override
    public boolean validate(Property property) {
        if (!(property instanceof Physical)) {
            return false;
        }

        return ((Physical)property).isPhysical();
    }
}
