package io.business;

import io.business.properties.Property;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author zerodi
 */
public class Product {

    private boolean physical;
    private Collection<Property> properties = new ArrayList<>();

    public boolean isPhysical() {
        return physical;
    }

    public void setPhysical(boolean physical) {
        this.physical = physical;
    }

    public Collection<Property> getProperties() {
        return properties;
    }

    public void setProperties(Collection<Property> properties) {
        this.properties = properties;
    }

    public void addProperty(Property property) {
        properties.add(property);
    }

    public boolean hasProperty(Class<? extends Property> propertyClass) {
        for (Property property : properties) {
            if (property.getClass().equals(propertyClass)) {
                return true;
            }
        }

        return false;
    }
}
