package io.business.conditions;

import io.business.Product;
import io.business.properties.Property;
import io.business.properties.State;
import org.omg.PortableInterceptor.ACTIVE;
import org.omg.PortableInterceptor.INACTIVE;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * @author zerodi
 */
public class HasStateTest {
    private Condition hasInactiveState;
    private Condition hasActiveState;


    @BeforeMethod
    public void setUp() {
        hasInactiveState = new HasState(new State("INACTIVE"));
        hasActiveState = new HasState(new State("ACTIVE"));
    }


    @Test
    public void testingForInactiveStateShouldBeTrueForInactiveStates() throws Exception {
        // given
        Property state = new State("INACTIVE");

        // when
        boolean resultForInactiveTest = hasInactiveState.validate(state);
        boolean resultForActiveTest = hasActiveState.validate(state);

        // then
        assertThat(resultForInactiveTest).isEqualTo(true);
        assertThat(resultForActiveTest).isEqualTo(false);
    }

    @Test
    public void testingForInactiveProductShouldBeTrueForInactiveStates() throws Exception {
        // given
        Product product = new Product();
        product.addProperty(new State("INACTIVE"));

        // when
        boolean resultForInactiveTest = hasInactiveState.validate(product);
        boolean resultForActiveTest = hasActiveState.validate(product);

        // then
        assertThat(resultForInactiveTest).isEqualTo(true);
        assertThat(resultForActiveTest).isEqualTo(false);
    }

}
