package io.business;

import io.business.properties.Physical;
import io.business.properties.Property;
import io.business.properties.State;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author zerodi
 */
public class Product {

    private Collection<Property> properties = new ArrayList<>();

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

    /**
     * Retrieves property of given class.
     * @param tClass
     * @param <T>
     * @return
     */
    public <T extends Property> T getProperty(Class<T> tClass) {
        for (Property property : properties) {
            if (property.getClass().equals(tClass)) {
                return (T) property;
            }
        }

        return null;
    }


    public void removeProperties(Class<? extends Property> propertyClass) {
        Iterator iterator = properties.iterator();

        while (iterator.hasNext()) {
            Property property = (Property) iterator.next();
            if (property.getClass().equals(propertyClass)) {
                iterator.remove();
            }
        }
    }
}
