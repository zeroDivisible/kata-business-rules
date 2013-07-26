package io.business.conditions;

import io.business.Product;
import io.business.properties.Property;
import io.business.properties.State;

/**
 * @author zerodi
 */
public class HasState implements Condition{

    private final State state;

    public HasState(State state) {
        this.state = state;
    }

    @Override
    public boolean validate(Product product) {
        return false;  //TODO Implement
    }

    @Override
    public boolean validate(Property property) {
        return property instanceof State && state.equals(property);
    }
}
