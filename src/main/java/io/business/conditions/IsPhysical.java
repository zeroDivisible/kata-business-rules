package io.business.conditions;

import io.business.Product;
import io.business.properties.Physical;
import io.business.properties.Property;

/**
 * @author zerodi
 */
public class IsPhysical implements Condition {

    private final boolean expected;

    public IsPhysical(boolean expected) {
        this.expected = expected;
    }

    @Override
    public boolean validate(Product product) {
        for (Property property : product.getProperties()) {
            if (property instanceof Physical) {
                return ((Physical) property).isPhysical() == expected;
            }
        }

        return false;
   }

    @Override
    public boolean validate(Property property) {
        return property instanceof Physical && ((Physical) property).isPhysical() == expected;
    }
}
