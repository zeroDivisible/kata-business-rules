package io.business;

import io.business.properties.Property;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author zerodi
 */
public class Product {

    private Collection<Property> properties = new ArrayList<>();
    private List<Payment> associatedPayments = new ArrayList<>();

    public Collection<Property> getProperties() {
        return properties;
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


    public List<Payment> getAssociatedPayments() {
        return associatedPayments;
    }

    public void addAssociatedPayment(Payment payment) {
        associatedPayments.add(payment);
    }

    public void setAssociatedPayments(List<Payment> associatedPayments) {
        this.associatedPayments = associatedPayments;
    }
}
