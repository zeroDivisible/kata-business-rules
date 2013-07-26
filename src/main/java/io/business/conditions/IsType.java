package io.business.conditions;

import io.business.Product;
import io.business.properties.Physical;
import io.business.properties.Property;
import io.business.properties.Type;

/**
 * @author zerodi
 */
public class IsType implements Condition{

    private final String type;

    public IsType(String type) {
        this.type = type;
    }

    @Override
    public boolean validate(Product product) {
        for (Property property : product.getProperties()) {
            if (property instanceof Type) {
                return ((Type) property).getType().equals(type);
            }
        }

        return false;
    }

    @Override
    public boolean validate(Property property) {
        if (!(property instanceof Type)) {
            return false;
        }

        return ((Type) property).getType().equals(type);
    }
}
