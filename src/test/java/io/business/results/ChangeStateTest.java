package io.business.results;

import io.business.Product;
import io.business.properties.State;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * @author zerodi
 */
public class ChangeStateTest {
    private ChangeState changeStateToActive;

    @BeforeMethod
    public void setUp() {
        changeStateToActive = new ChangeState(State.ACTIVE);
    }

    @Test
    public void activatingTheProductShouldChangeItsState() throws Exception {
        //given
        Product product = new Product();
        product.addProperty(State.INACTIVE);

        // when
        changeStateToActive.on(product);

        // then
        assertThat(product.getProperty(State.class)).isEqualTo(State.ACTIVE);
    }
}
