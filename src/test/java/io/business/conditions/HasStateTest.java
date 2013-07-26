package io.business.conditions;

import io.business.properties.Property;
import io.business.properties.State;
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
        hasInactiveState = new HasState(State.INACTIVE);
        hasActiveState = new HasState(State.ACTIVE);
    }


    @Test
    public void testingForInactiveStateShouldBeTrueForInactiveStates() throws Exception {
        // given
        Property state = State.INACTIVE;

        // when
        boolean resultForInactiveTest = hasInactiveState.validate(state);
        boolean resultForActiveTest = hasActiveState.validate(state);

        // then
        assertThat(resultForInactiveTest).isEqualTo(true);
        assertThat(resultForActiveTest).isEqualTo(false);
    }
}
