package io.business.conditions;

import io.business.Product;
import io.business.properties.Physical;
import io.business.properties.Property;

/**
 * @author zerodi
 */
public interface Condition {

    public boolean validate(Product product);
    public boolean validate(Property property);
}
