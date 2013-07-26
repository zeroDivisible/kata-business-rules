package io.business.properties;

import org.omg.PortableInterceptor.INACTIVE;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * @author zerodi
 */
public class StateTest {
    private State state;

    @BeforeMethod
    public void setUp() {
        state = new State("INACTIVE");
    }

    @Test
    public void creationOfStateShouldAllowRetrievingThisState() throws Exception {
        // then
        assertThat(state).isEqualTo(new State("INACTIVE"));
    }
}
