package io.business.results;

import io.business.Product;
import io.business.properties.State;

/**
 * @author zerodi
 */
public class ChangeState implements Result{
    private final State targetState;

    public ChangeState(State state) {
        this.targetState = state;
    }

    @Override
    public void on(Product product) {
        if (product.hasProperty(State.class)) {
            product.removeProperties(State.class);
        }

        product.addProperty(targetState);
    }
}
