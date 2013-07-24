package io.business.conditions;

import io.business.properties.Property;

/**
 * @author zerodi
 */
public interface Condition {

    public boolean validate(Property property);
}
