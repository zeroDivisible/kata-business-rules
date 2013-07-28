package io.business.conditions;

import io.business.Product;
import io.business.properties.Property;

/**
 * Interface which needs to be implemented by all classes which want to be a condition in a business process
 * @author zerodi
 */
public interface Condition {

    public boolean validate(Product product);
    public boolean validate(Property property);
}
