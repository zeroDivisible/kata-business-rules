package io.business.conditions;

import io.business.Product;
import io.business.properties.Name;
import io.business.properties.Property;

/**
 * @author zerodi
 */
public class HasName implements Condition {

    private final String name;

    public HasName(String name) {
        this.name = name;
    }

    @Override
    public boolean validate(Product product) {
        for (Property property : product.getProperties()) {
            if (property instanceof Name) {
                return name.equals(((Name) property).getName());
            }
        }

        return false;
    }

    @Override
    public boolean validate(Property property) {
        return property instanceof Name && name.equals(((Name)property).getName());
    }

    public String getName() {
        return name;
    }
}
