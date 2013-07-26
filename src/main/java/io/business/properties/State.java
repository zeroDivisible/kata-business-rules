package io.business.properties;

import io.business.Product;
import org.omg.PortableInterceptor.ACTIVE;
import org.omg.PortableInterceptor.INACTIVE;

import java.math.BigDecimal;

/**
 * Property describing a state of something
 * @author zerodi
 */
public class State extends Property {
    private final String state;

    public State(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof State)) return false;

        State state1 = (State) o;

        if (state != null ? !state.equals(state1.state) : state1.state != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return state != null ? state.hashCode() : 0;
    }
}
