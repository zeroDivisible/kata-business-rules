package io.business;

import io.business.properties.Property;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Class representing a product. By default product is a blank canvas and it's properties are mostly defined
 * by whichever {@link Property Properties} will be added to it.
 * @author zerodi
 */
public class Product {

    private Collection<Property> properties = new ArrayList<>();
    private Payment relatedPayment;

    public Collection<Property> getProperties() {
        return properties;
    }

    public void addProperty(Property property) {
        properties.add(property);
        property.setParentProduct(this);
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


    public void setRelatedPayment(Payment payment) {
        this.relatedPayment = payment;
    }

    public Payment getRelatedPayment() {
        return relatedPayment;
    }

    public Product withProperties(Property... properties) {
        for (Property property : properties) {
            this.addProperty(property);
        }

        return this;
    }
}
